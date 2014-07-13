/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package typ1;

import java.util.*;
import java.lang.System;
import java.io.*;


/**
 *
 * @author sarah
 */
abstract public class Contact {
    private int id;
    public void setId(int newValue){ id = newValue; }
    public int getId(){ return id; }
    
    private String firstName;
    public String getFirstName(){ return firstName; }
    public void setFirstName(String newValue){ firstName = newValue;}
    
    private String lastName;
    public String getLastName(){ return lastName; }
    public void setLastName(String newValue){ lastName = newValue;}

    private String address;
    public String getAddress(){ return address; }
    public void setAddress(String newValue){ address = newValue;}
    
    private String phoneNumber;
    public String getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(String newValue){ phoneNumber = newValue; }
    
    private String email;
    public String getEmail(){return email;}
    public void setEmail(String newValue){ email = newValue; }
    
    
    Contact (BufferedReader keyboard, int id) throws IOException {
        String input;

        System.out.println("First Name: ");
        input = keyboard.readLine();
        this.setFirstName(input);
        
        System.out.println("Last Name: ");
        input = keyboard.readLine();
        this.setLastName(input);
        
        System.out.println("Address: ");
        input = keyboard.readLine();
        this.setAddress(input);
        
        System.out.println("Phone Number: ");
        input = keyboard.readLine();
        this.setPhoneNumber(input);
        
        System.out.println("Email: ");
        input = keyboard.readLine();
        this.setEmail(input);
    }
    
    
    public String toString(){
        return "ID: "+this.getId()+"\n"+"name: "+this.getFirstName()+" "+this.getLastName();
    }

}
