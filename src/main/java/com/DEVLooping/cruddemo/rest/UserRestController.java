package com.DEVLooping.cruddemo.rest;

import org.springframework.web.bind.annotation.*;

import com.DEVLooping.cruddemo.entity.User;
import com.DEVLooping.cruddemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;
    public UserRestController(UserService theUserService){
        userService = theUserService;
    }
    // exponer "/users" y retornar todos los usuarios

    @GetMapping("/users")
    public List<User> findAll(){
        List<User> theUsers = userService.findAll();
        

        return theUsers;
    }

    @GetMapping("/users/{userId}")
    public User findById(@PathVariable int userId){
        User theUser = userService.findById(userId);
        if (theUser == null){
            throw new RuntimeException("User id not found - " + userId );
        }
        return theUser;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User theUser){
        theUser.setId(0);

        User dbUser = userService.save(theUser);

        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser){

        User dbUser = userService.save(theUser);

        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User tempUser = userService.findById(userId);

        if (tempUser==null){
            throw new RuntimeException("User id not found - "+userId);
        }
        userService.deleteById(userId);
        return "Deleted user id - "+userId;
    }
}
