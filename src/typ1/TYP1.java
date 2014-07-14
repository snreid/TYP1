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
    public static ArrayList<Contact> contactList = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(in);
        String input;
        
        do{
            System.out.println("**** MAIN MENU ****");
            System.out.println("1. Add a Business Contact");
            System.out.println("2. Add a Personal Contact");
            System.out.println("3. Display Contacts");
            System.out.println("Please enter number of what you would like to do, or type 'quit' to exit: ");
            input = keyboard.readLine();
            
//            System.out.println("Here's what you entered: " + input);
            
            if(input.equals("quit") || input.equals("q")){ 
                break; 
            }
            else if(input.equals("1")){
                System.out.println("**** BUSINESS CONTACT ****");
                BusinessContact b = new BusinessContact(keyboard);
                contactList.add(b);
            }
            else if(input.equals("2")){
                System.out.println("**** PERSONAL CONTACT ****");
                PersonalContact p = new PersonalContact(keyboard);
                contactList.add(p);
            }
            else if (input.equals("3") && contactList.size() > 0){
                
                do{
                    int index = 0;
                    System.out.println("**** CONTACTS MENU ****");
                    for(Contact contact : contactList){
                        System.out.println(index+"\t"+contact.getFirstName()+" "+contact.getLastName());
                        index++;
                    }
                    System.out.println("Type number preceding contact to see full details, or 'quit' to go back to the Main Menu:");
                    input = keyboard.readLine();
                    if(input.equals("quit") || input.equals("q")){
                        break;
                    }
                    else{
                        try{
                            int contact = Integer.parseInt(input);
                            System.out.println("**** DETAILS ****");
//                            TODO identify contact by type (Business or personal).
                            Contact c = contactList.get(contact);
                            System.out.println(c.getClass());
                            System.out.println(c.toString());
                        }
                        catch(NumberFormatException e){
                            System.out.println("You must enter a valid number.");
                        }
                    }
                }while(!input.equals("quit") && !input.equals("q") );
//                emptied out 'input' variable, since it will still contain 'quit'/'q' when exiting this loop, and will exit the next main menu loop as well.
                input = "";
            }
            else{System.out.println("No contacts have been created. Please create contacts before attempting to view."); }
            
        }while( !input.equals("quit") && !input.equals("q") );

    }
    
}
