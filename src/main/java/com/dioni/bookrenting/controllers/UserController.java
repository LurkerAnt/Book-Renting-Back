package com.dioni.bookrenting.controllers;

import com.dioni.bookrenting.controllers.dtos.UpdateUserBody;
import com.dioni.bookrenting.controllers.dtos.UserBody;
import com.dioni.bookrenting.entities.User;
import com.dioni.bookrenting.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping("/user")
    public boolean createUser(@RequestBody UserBody userBody) {
        userService.createUser(userBody);
        return true;
    }

    @PutMapping("/user/{username}")
    public boolean updateUser(
            @RequestBody UpdateUserBody userBody,
            @PathVariable String username
    ) {
        userService.updateUser(username, userBody);
        return true;
    }

    @DeleteMapping("/user/{username}")
    public boolean deleteUser(
            @PathVariable String username
    ) {
        userService.deleteUser(username);
        return true;
    }

}
