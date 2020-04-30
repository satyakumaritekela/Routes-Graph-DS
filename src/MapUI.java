/***** Author: Satya Kumar Itekela, Banner ID: B00839907 ****/

import java.io.*;
import java.util.*;

public class MapUI {

    public static void main(String[] args) {
        // Define variables to manage user input

        String userCommand = "";
        String userArgument = "";
        Scanner userInput = new Scanner( System.in );

        // Define variables to catch the return values of the methods

        boolean booleanOutcome;
        Void voidOutcome;

        // Define the list that we will test.

        HalifaxMap testList = new HalifaxMap();

        // Process the user input until they provide the command "quit"

        do {
        	System.out.println("What type of action do u want to perform??");
            // Find out what the user wants to do
            userCommand = userInput.next();
            userArgument = userInput.nextLine();
            userArgument = userArgument.trim();
            String[] intArray = userArgument.split(" ");
            int[] userIntArgument = new int[intArray.length];
            
            if(userArgument.length() > 0) { 
            	try {                   
                    for(int i = 0; i < intArray.length; i++) {
                        userIntArgument[i]=Integer.parseInt(intArray[i]); 
                    }   
            	} 
            	catch(NumberFormatException ne) {
            		userIntArgument = null;
            	}              	
            }
            
            /* Do what the user asked for. */
            /* Added a new argument display for displaying the level of lists*/
            if(userCommand.equalsIgnoreCase("newIntersection")) {
            	try {
                	if(userIntArgument.length <= 2) {
                    	try {
                            booleanOutcome = testList.newIntersection( userIntArgument[0], userIntArgument[1] );
                            System.out.println("newIntersection ("+userIntArgument[0]+","+userIntArgument[1]+") outcome " + booleanOutcome );               		
                    	}
                    	catch(IndexOutOfBoundsException ie) {
                    		System.out.println("Please pass coordinates (x,y) correctly.");
                    	}           		
                	}
                	else {
                		System.out.println("Please check the parameters. Can pass only 2 integers to create new Intersection");            		
                	}            		
            	}
            	catch(NullPointerException ne) {
            		System.out.println("Please check the command. Can pass only Integers / Cannot pass null value(s) / Check the spaces correctly.");
            	}
            } 
            else if (userCommand.equalsIgnoreCase("defineRoad")) {
            	try {
                	if(userIntArgument.length <= 4) {
    	            	try {
    	                    booleanOutcome = testList.defineRoad( userIntArgument[0],userIntArgument[1], userIntArgument[2], userIntArgument[3] );
    	                    System.out.println("defineRoad outcome " + booleanOutcome );               		
    	            	}
    	            	catch(IndexOutOfBoundsException ie) {
    	            		System.out.println("Please pass coordinates (x1,y1) and (x2,y2) correctly. Pass 4 Integer values.");
    	            	}          		
                	}
                	else {
                		System.out.println("Please check the parameters. Can pass only 4 integers to create new Road");            		
                	}            		
            	}
            	catch(NullPointerException ne) {
            		System.out.println("Please check the command. Can pass only Integers / Cannot pass null value(s) / Check the spaces correctly.");
            	}
            } 
            else if (userCommand.equalsIgnoreCase("navigate")) {
            	try {
                	if(userIntArgument.length <= 4) {
    	            	try {
    	                	voidOutcome = testList.navigate( userIntArgument[0],userIntArgument[1], userIntArgument[2], userIntArgument[3] );
    	                    System.out.println("navigate outcome " + voidOutcome );              		
    	            	}
    	            	catch(IndexOutOfBoundsException ie) {
    	            		System.out.println("Please pass coordinates (x1,y1) and (x2,y2) correctly. Pass 4 Integer values.");
    	            	}
                	}
                	else {
                		System.out.println("Please check the parameters. Can pass only 4 integers to create new Road");            		
                	}             		
            	}
            	catch(NullPointerException ne) {
            		System.out.println("Please check the command. Can pass only Integers / Cannot pass null value(s) / Check the spaces correctly.");
            	}           	
            } 
            else if (userCommand.equalsIgnoreCase("displayMap")) {
                booleanOutcome = testList.displayMap();
                System.out.println("Display outcome " + booleanOutcome );
            } 
            else if (userCommand.equalsIgnoreCase("quit")) {
                System.out.println ("Quit");
            } 
            else {
                    System.out.println ("Bad command: " + userCommand);
            }
        } while (!userCommand.equalsIgnoreCase("quit"));

        // The user is done so close the stream of user input before ending.

        userInput.close();
    }
}