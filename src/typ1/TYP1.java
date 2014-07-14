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
    /**
     * @param args the command line arguments
     */
    
    
    //Collection for holding contacts.
    public static ArrayList<Contact> contactList = new ArrayList();
    
    public static void main(String[] args) throws IOException {
        
        //Create "keyboard" for receiving input from user.
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(in);
        
        //input variable receives last line entered by user from "keyboard".
        String input;
        
        do{
            //Output Main Menu options until user types 'quit' or 'q'.
            System.out.println("**** MAIN MENU ****");
            System.out.println("1. Add a Business Contact");
            System.out.println("2. Add a Personal Contact");
            System.out.println("3. Display Contacts");
            System.out.println("Please enter number of what you would like to do, or type 'quit' to exit: ");
            input = keyboard.readLine();
            
            //Quit the application immediately.
            if(input.equals("quit") || input.equals("q")){ 
                break; 
            }
            //If 1 is entered, create a new business contact.
            else if(input.equals("1")){
                System.out.println("**** BUSINESS CONTACT ****");
                BusinessContact b = new BusinessContact(keyboard);
                contactList.add(b);
            }
            //If 2 is entered, create a new personal contact.
            else if(input.equals("2")){
                System.out.println("**** PERSONAL CONTACT ****");
                PersonalContact p = new PersonalContact(keyboard);
                contactList.add(p);
            }
            //if 3 is entered, and there are contacts in the contactList ArrayList, list the contacts.
            else if (input.equals("3") && contactList.size() > 0){
                
                do{
                    //Sub-Menu/Contacts Menu. Continues to be displayed until user types 'quit' or 'q'.
                    //index variable for displaying number of contact index in array.
                    int index = 0;
                    //Outputting each user.
                    System.out.println("**** CONTACTS MENU ****");
                    for(Contact contact : contactList){
                        System.out.println(index+"\t"+contact.getFirstName()+" "+contact.getLastName());
                        index++;
                    }
                    
                    //Directions for displaying details of contact or going back to Main Menu.
                    System.out.println("Type number preceding contact to see full details, or 'quit' to go back to the Main Menu:");
                    input = keyboard.readLine();
                    if(input.equals("quit") || input.equals("q")){
                        break;
                    }
                    else{
                        try{
                            int contact = Integer.parseInt(input);
                            System.out.println("**** DETAILS ****");
                            Contact c = contactList.get(contact);
                            System.out.println(c.toString());
                        }
                        catch(NumberFormatException e){
                            //Error message if entry cannot be parsed to an integer.
                            System.out.println("You must enter a valid number.");
                        }
                    }
                }while(!input.equals("quit") && !input.equals("q") );
                
                //Empty 'input' variable before exiting this loop, since it will still contain 'quit'/'q', and will unintentionally exit the next main menu loop as well.
                input = "";
            }
            else if (input.equals("3")){
                //Error message for case where user has selected to display contacts, but contacts arraylist is empty.
                System.out.println("No contacts have been created. Please create contacts before attempting to view."); 
            }
            else{
                //Catch all other user entries that do not match an option.
                System.out.println("Invalid entry. Please try again."); 
            }
            
        }while( !input.equals("quit") && !input.equals("q") );
    }
}
