/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package typ1;
import java.util.*;
import java.lang.*;
import java.lang.System;
import java.io.*;

/**
 *
 * @author sarah
 */
public class TYP1 {
    public static int incrementer = 0;
    public static ArrayList<Contact> contactList = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(in);
        String input;
        
        do{
            System.out.println("**** MENU ****");
            System.out.println("1. Enter New Business Contact");
            System.out.println("2. Enter New Personal Contact");
            System.out.println("3. View All Contacts");
            System.out.println("Please enter number of what you would like to do, or type 'quit': ");
            input = keyboard.readLine();
            
            System.out.println("Here's what you entered: " + input);
            
            if(input.equals("quit") || input.equals("q")){ 
                break; 
            }
            else if(input.equals("1")){
                BusinessContact b = new BusinessContact(keyboard, setNewRecordID());
                contactList.add(b);
            }
            else if(input.equals("2")){
                PersonalContact p = new PersonalContact(keyboard, setNewRecordID());
                contactList.add(p);
            }
            else if (input.equals("3")){
                int index = 0;
                for(Contact contact : contactList){
                    System.out.println(index+"\t"+contact.getFirstName()+" "+contact.getLastName());
                    index++;
                }
                do{
                    System.out.println("Type number of contact to see full details, or 'quit' to go back to the main menu:");
                    input = keyboard.readLine();
                    if(input.equals("quit") || input.equals("q")){
                        break;
                    }
                    else{
                        Contact c = contactList.get(Integer.parseInt(input));
                        System.out.println(c.toString());
                    }
                }while(!input.equals("quit") && !input.equals("q") );
            }
            
        }while( !input.equals("quit") && !input.equals("q") );

    }
    public static int setNewRecordID(){
        incrementer++;
        return incrementer;
    }
    
}
