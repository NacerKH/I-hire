/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.User;
import Services.UserServices;
import java.util.ArrayList;

/**
 *
 * @author Dhiaeddsn
 */
public class Main {
    
    public static void main(String[] args){
        
        UserServices.GetInstance().GetAll(); 
        
        ArrayList<User> users =  UserServices.GetInstance().GetAll(); 
         
        System.out.println("the total are: " + users.size());
        
    }
}
