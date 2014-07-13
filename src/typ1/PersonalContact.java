/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package typ1;
import java.util.*;
import java.io.*;
import java.lang.System;

/**
 *
 * @author sarah
 */
public class PersonalContact extends Contact{
    
    private String birthdate;
    public String getBirthdate(){ return birthdate; }
    public void setBirthdate(String newValue){ birthdate = newValue; }
    
    PersonalContact(BufferedReader keyboard) throws IOException{
        super(keyboard);
        String input;
        
        System.out.println("Birthdate: ");
        input = keyboard.readLine();
        setBirthdate(input);
    }
    
    public String toString(){
        return super.toString() + "\nBirthdate: " + this.getBirthdate();    
    }
}
