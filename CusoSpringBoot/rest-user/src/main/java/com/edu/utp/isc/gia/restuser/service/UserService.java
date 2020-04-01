/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.gia.restuser.service;

import com.edu.utp.isc.gia.restuser.web.dto.Consecutivo;
import com.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class UserService {
     private List<UserDto> users = new ArrayList<>();
     
     public UserDto insert(UserDto user){
         user.setId(Consecutivo.generarConsecutivo((ArrayList<UserDto>) users));
         user.setUsername(user.getUsername().toLowerCase());
         users.add(user);
         return user;
     }
     
     public List<UserDto> getAll() {
        return users;
    }
     
    public UserDto getOne(Long id) {
        for(UserDto u : users){
            if(Objects.equals(u.getId(), id)){
                return u;
            }
        }
        return null;
    }
    
    public UserDto updateOne(Long id, UserDto user){
        UserDto us = getOne(id);
        if(us != null){
            user.setId(id);
            users.set(users.indexOf(us), user);
            return getOne(id);
        }
        return null;
        
        
    }
    public Boolean deleteOne(Long id){
        boolean remove = users.remove(getOne(id));
        return remove;
    }
}
