package com.example.userManagementSystem.controller;

import com.example.userManagementSystem.service.UserService;
import com.example.userManagementSystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Get all user by this endpoint
    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUsersFromService();
    }
    //Add users...
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user){
       return userService.addUserInService(user);
    }
    //get user by id..
    @RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String userId){
        return userService.getUserByIdFromService(userId);
    }
    //Delete user....
    @DeleteMapping(value = "/deleteUserById/{userId}")
    public String deleteUserById(@PathVariable String userId){
        return userService.removeUserById(userId);
    }

    //update user

    @PutMapping(value = "/updateUserById/{userId}/{status}")
    public String updateUserById(@PathVariable String userId, @PathVariable String status){
        return userService.updateUserById(userId, status);
    }



}
