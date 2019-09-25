/**
 * PantherID: 2705029
 * Class: COP 2210 – Spring 2017
 * Assignment #4
 * Date: April 12th, 2017
 * 
 * PantherID of Original Owner: 5970602
 * 
 * We hereby swear and affirm that this work is solely our own, and not the work
 * or the derivative of the work of someone else.
 */

/**
 * The EasterBunnyTester program implements the EasterBunnyHunt class. This
 * program runs all of the methods and makes the EasterBunnyHunt class work.
 * @author 2705029 & 5970602
 * @version 1.7
 */
import javax.swing.*;
public class EasterBunnyTester {
    
    /**
     * This main method runs the methods from EasterBunnyHunt using a try-and-
     * catch.
     * @param args the command line arguments
     */
    public static void main (String args[]) {
        
        EasterBunnyHunt bunnyHunt = new EasterBunnyHunt();
        
        // do-while loop to run all methods of EasterBunnyHunt while the
        // private boolean endingRoom is false
        do {

            bunnyHunt.setBunnyHuntProperties();
            bunnyHunt.enterWorld();
            bunnyHunt.getMainPark1();
            
        } while (bunnyHunt.endingIsFalse (false));
        
    }
    
}