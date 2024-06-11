package com.example.ioc.contoller;

import com.example.ioc.User;
import com.example.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InitialController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {

        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
}
