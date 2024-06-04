package com.dgut.repair.controller;

import com.dgut.repair.Response;
import com.dgut.repair.dao.User;
import com.dgut.repair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user/login")
    public Response login(@RequestParam String user_name, @RequestParam String user_psd){
        return userService.loginCheck(user_name,user_psd);
    }
    @GetMapping("/user/{id}")
    public Response getUserById(@PathVariable int id){
        return Response.newSuccess(userService.getUserById(id));
    }

    @PostMapping("/user")
    public Response addUser(@RequestBody User user){
        return Response.newSuccess(userService.addUser(user));
    }
}
