/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.gia.restuser.web.controller;

import com.edu.utp.isc.gia.restuser.service.UserService;
import com.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Michael
 */
@RestController
@RequestMapping("user")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping() // POST http://localhost:8080/user
    public UserDto save(@RequestBody UserDto user){
        return userService.insert(user);
    }
    
    @PostMapping("/{user}/rol") // POST http://localhost:8080/user/1/rol
    public UserDto saveUserRol(@PathVariable("user")String id, UserDto user){
        return null;
    }
    
    @GetMapping()
    public List<UserDto> listAll(){
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    public UserDto findOne(@PathVariable("id") Long id){
        return userService.getOne(id);
    }
    
    @DeleteMapping("/{id}")
    public Boolean removeOne(@PathVariable("id") Long id){
        return userService.deleteOne(id);
    }
    
    @PutMapping("/{id}")
    public UserDto updateOne(@PathVariable("id") Long id, @RequestBody UserDto user){
        return userService.updateOne(id, user);
    }
}
