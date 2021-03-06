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
public class BusinessContact extends Contact {
    //Initializing BusinessContact specific attributes with getters and setters.
    private String jobTitle;
    public String getJobTitle(){ return jobTitle; }
    public void setJobTitle(String newValue){ jobTitle = newValue; }
    
    private String organization;
    public String getOrganization(){ return organization; }
    public void setOrganization( String newValue ){ organization = newValue; }
    
    
    BusinessContact(BufferedReader keyboard) throws IOException{
        //Requesting info from user on BusinessContact specific attributes after super() has run.
        super(keyboard);
        
        String input;
        
        System.out.println("Job Title: ");
        input = keyboard.readLine();
        this.setJobTitle(input);
        
        System.out.println("Organization: ");
        input = keyboard.readLine();
        this.setOrganization(input);
    };
    
    
    
    public String toString(){
        //Outputting BusinessContact specific attributes. Appended to super.
       return "Type: Business Contact\n"+super.toString()+"\nJob Title: "+this.getJobTitle()+"\nOrganization: "+this.getOrganization()+"\n";
    }
    
    
}
