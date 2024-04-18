package com.DEVLooping.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DEVLooping.cruddemo.entity.Permission;
import com.DEVLooping.cruddemo.service.PermissionService;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class PermissionRestController {

    private PermissionService permissionService;

    public PermissionRestController(PermissionService thePermissionService) {
        permissionService = thePermissionService;
    }
    // exponer "/permissions" y retornar todos los usuarios

    @GetMapping("/")
    public List<Permission> findAll() {
        List<Permission> thePermissions = permissionService.findAll();

        return thePermissions;
    }

    @GetMapping("/{permissionId}")
    public Permission findById(@PathVariable int permissionId) {
        Permission thePermission = permissionService.findById(permissionId);
        if (thePermission == null) {
            throw new PermissionNotFoundException("Permission id not found - " + permissionId);
        }
        return thePermission;
    }

    @PostMapping("/")
    public Permission addPermission(@RequestBody Permission thePermission) {
        thePermission.setId(0);

        Permission dbPermission = permissionService.save(thePermission);

        return dbPermission;
    }

    @PutMapping("/{permissionId}")
    public Permission updatepPermission(@PathVariable int permissionId, @RequestBody Permission updatedPermission) {
        Permission existingPermission = permissionService.findById(permissionId);
        if (existingPermission == null) {
            throw new PermissionNotFoundException("Permission not found with id: " + permissionId);
        }

        existingPermission.setName_permission(updatedPermission.getName_permission());
        existingPermission.setDesc_permission(updatedPermission.getDesc_permission());
        // Guardar el permiso actualizado en la base de datos
        Permission savedPermission = permissionService.save(existingPermission);
        return savedPermission;
    }

    @DeleteMapping("/{permissionId}")
    public Permission softDeletePermission(@PathVariable int permissionId) {
        Permission existingPermission = permissionService.findById(permissionId);
        if (existingPermission == null) {
            throw new PermissionNotFoundException("Permission not found with id: " + permissionId);
        }

        // Guardar el usuario desactivado en la base de datos
        Permission updatedPermission = permissionService.save(existingPermission);
        return updatedPermission;
    }

    @RestControllerAdvice
    class PermissionRestControllerAdvice {
        @ExceptionHandler
        public ResponseEntity<String> handleNotFoundException(PermissionNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "{ status : " + HttpStatus.NOT_FOUND.value() + ", message:" + ex.getMessage() + "}");
        }

        @ExceptionHandler
        public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "{ status : " + HttpStatus.INTERNAL_SERVER_ERROR.value() + ", message:" + ex.getMessage() + "}");
        }

    }

    class PermissionNotFoundException extends RuntimeException {
        public PermissionNotFoundException(String message) {
            super(message);
        }
    }
}
