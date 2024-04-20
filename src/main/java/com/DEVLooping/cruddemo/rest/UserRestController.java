package com.DEVLooping.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DEVLooping.cruddemo.entity.User;
import com.DEVLooping.cruddemo.service.EncryptService;
import com.DEVLooping.cruddemo.service.UserService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserService userService;
    private EncryptService encryptService = new EncryptService();

    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }
    // exponer "/users" y retornar todos los usuarios

    @GetMapping("/")
    public List<User> findAll() {
        List<User> theUsers = userService.findAll();

        return theUsers;
    }

    @GetMapping("/login/")
    public HttpStatus loginUser(@RequestParam String username, @RequestParam String password) {
        
        String encryptedPassword = encryptService.encrypt(password);
        User theUser = userService.loginUser(username, encryptedPassword);
        if (theUser == null) {
            return HttpStatus.UNAUTHORIZED;
        }
        return HttpStatus.OK;
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable int userId) {
        User theUser = userService.findById(userId);
        if (theUser == null) {
            throw new UserNotFoundException("User id not found - " + userId);
        }
        return theUser;
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User theUser) {
        theUser.setId(0);
        theUser.setCreated_at(new Date());
        // Encriptar contraseña utilizando Jasypt
        String encryptedPassword = encryptService.encrypt(theUser.getPassword());
        theUser.setPassword(encryptedPassword);
        User dbUser = userService.save(theUser);

        return dbUser;
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        User existingUser = userService.findById(userId);
        if (existingUser == null) {
            throw new UserNotFoundException("User not found with id: " + userId);
        }

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setUserType(updatedUser.getUserType());

        // Guardar el usuario actualizado en la base de datos
        User savedUser = userService.save(existingUser);
        return savedUser;
    }

    @DeleteMapping("/{userId}")
    public User softDeleteUser(@PathVariable int userId) {
        User existingUser = userService.findById(userId);
        if (existingUser == null) {
            throw new UserNotFoundException("User not found with id: " + userId);
        }

        // Actualizar los atributos del usuario para "eliminarlo" de forma lógica
        existingUser.setDeactivated_at(new Date());
        existingUser.setStatus("inactive");

        // Guardar el usuario desactivado en la base de datos
        User updatedUser = userService.save(existingUser);
        return updatedUser;
    }

    @GetMapping("/desencriptar/{userId}")
    public User decryptPassword(@PathVariable int userId) {
        User existingUser = userService.findById(userId);
        if (existingUser == null) {
            throw new UserNotFoundException("User not found with id: " + userId);
        }

        // Desencriptar la contraseña del usuario
        String decryptedPassword = encryptService.decrypt(existingUser.getPassword());
        existingUser.setPassword(decryptedPassword);

        return existingUser;
    }
    
    @RestControllerAdvice
    class UserRestControllerAdvice {
        @ExceptionHandler
        public ResponseEntity<String> handleNotFoundException(UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "{ status : " + HttpStatus.NOT_FOUND.value() + ", message:" + ex.getMessage() + "}");
        }

        @ExceptionHandler
        public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "{ status : " + HttpStatus.INTERNAL_SERVER_ERROR.value() + ", message:" + ex.getMessage() + "}");
        }

    }

    class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
