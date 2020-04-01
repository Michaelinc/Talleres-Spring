/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.gia.restuser.web.dto;

import java.util.ArrayList;

/**
 *
 * @author Usuario UTP
 */
public class Consecutivo {
    
    public static Long generarConsecutivo(ArrayList<UserDto> users){
        if(users.isEmpty()){
            return 1L;
        }else{
            Long id = users.get(users.size() - 1).getId() + 1;
            return id;
        }
       
    }
}
