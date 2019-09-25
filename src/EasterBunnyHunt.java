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
 * @author 2705029 & 5970602
 * @version 1.7
 */

import javax.swing.*;
public class EasterBunnyHunt {

    // importation of ImageIcon classes
    ImageIcon aerynsOverlookMap = new ImageIcon ("aerynsoverlook.png");
    ImageIcon festiveFallsMap = new ImageIcon ("festivefalls.png");
    ImageIcon floweringForestMap = new ImageIcon ("floweringforest.png");
    ImageIcon fullMap = new ImageIcon ("fullmap.png");
    ImageIcon gardenGateMap = new ImageIcon ("gardengatemap.png");
    ImageIcon gardensMap = new ImageIcon ("gardens.png");
    ImageIcon mainParkMap = new ImageIcon ("mainparkmap.png");
    ImageIcon peacefulPondMap = new ImageIcon ("peacefulpond.png");
    ImageIcon ravensTowerMap = new ImageIcon ("ravensTower.png");
    ImageIcon readingNookMap = new ImageIcon ("readingnook.png");
    ImageIcon springMeadowMap = new ImageIcon ("springmeadow.png");
    
    // initialization of variable explorerName - input by the user
    private String explorerName;
    
    // initialization of boolean endingRoom to determine whether the game ends
    // or not in a certain room
    private boolean endingRoom;
    
    // initialization of integers to count how many times user visits an area
    int visitedAerynsOverlook, visitedBunnyBridge, visitedButterflyGarden,
        visitedFestiveFalls, visitedFloweringForest, visitedGardenGate,
        visitedMainPark = 1, visitedPeacefulPond, visitedRavensTower,
        visitedReadingNook, visitedRoseGarden, visitedSpringMeadow;
    
    /**
     * The endingIsFalse() boolean is for the do-while loop in the 
     * EasterBunnyTester class. This is a default constructor so that when the
     * ending does become true, the game will exit using System.exit(0);
     * @return false
     */
    public boolean endingIsFalse (boolean endingRoom) {
        
        System.exit(0);
        return false;
    
    }
    
    /**
     * The setBunnyHuntProperties() method is an introduction for the game.
     * The user is introduced to the game and enters their name.
     */
    public void setBunnyHuntProperties() {
        
        // greeting
        JOptionPane.showMessageDialog (null, "Hello! You are about to start "
            + "\nyour quest to find the Easter Bunny.", "Welcome",
            JOptionPane.INFORMATION_MESSAGE);
        
        // input of caretaker name, colony name, & starting amount of amoebas
        explorerName = JOptionPane.showInputDialog ("What is your name?", 
            "Enter Name");
        
        // while loop to show error if user doesn't enter name
        while (explorerName.equals("null") && explorerName.equals("")) {
            
            JOptionPane.showMessageDialog (null, "Please enter in your name.",
                "Error Detected", JOptionPane.WARNING_MESSAGE);
            
            setBunnyHuntProperties();
            
        }
        
    }
    
    /**
     * The enterWorld() method is a further extension of the previous method,
     * in which the user is told they're on a quest to find the Easter Bunny.
     * The user is given and shown a map and enters the world of the game.
     */
    public void enterWorld() {
        
        // intialization of objects to have custom buttons
        Object[] thankYou = {"Thank You"};
        Object[] enterWorld = {"I'm Ready"};
        Object[] openMap = {"Open Map"};
        Object[] closeMap = {"Close Map"};
        
        // beginning of hunt
        JOptionPane.showOptionDialog (null, "Hello, " + explorerName +
            "!\nYou have begun your quest to find\nthe ever-elusive Easter "
            + "Bunny.\nWe wish you the best of luck!",
            explorerName + "'s Quest", JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null, thankYou, thankYou[0]);
        
        JOptionPane.showOptionDialog (null, "Are you ready, " + explorerName
            + "?\nYour quest is about to begin.", explorerName + "'s Quest",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            enterWorld, enterWorld[0]);
        
        // acquiring of map
        JOptionPane.showOptionDialog (null, "You have been granted a special "
            + "map to aid you on your quest.\nPlease open it to begin, " 
            + explorerName + ".", explorerName + "'s Quest",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
            openMap, openMap[0]);
        
        // opening of map
        JOptionPane.showOptionDialog (null, "", "Map",
            JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, fullMap,
            closeMap, closeMap[0]);
        
    }
    
    /**
     * The getMainPark1() method is the intro to the game. It is the first area
     * you enter no matter what. This method is only used once as the user 
     * cannot exit from here. The getMainPark2() method allows the user to exit
     * the park, officially ending the game. From this method, you may go to the
     * Spring Meadow, the Garden Gate, or Aeryn's Overlook.
     */
    public void getMainPark1() {
        
        // intialization of objects to have custom buttons (for choices)
        Object[] choiceBranchPark = {"Go to Spring Meadow",
            "Open the Garden Gate", "Go to Aeryn's Overlook"};
        
        // beginning of entry
        JOptionPane.showMessageDialog (null, "Welcome. You have now entered the"
            + " Park.\nNote: You may go back to places as many\ntimes as you "
            + "wish.", explorerName + "'s Quest",
            JOptionPane.INFORMATION_MESSAGE);
        
        // beginning of options
        int mainPark = JOptionPane.showOptionDialog (null, "To the west, "
            + "you have the Spring Meadow.\nTo the east, you have the Garden"
            + "Gate.\nLastly, you have Aeryn's Overlook to the south.",
            "Main Park", JOptionPane.PLAIN_MESSAGE,
            JOptionPane.YES_NO_CANCEL_OPTION, fullMap, choiceBranchPark,
            choiceBranchPark[0]);
        
        // if choosing to go to Spring Meadow
        if (mainPark == JOptionPane.YES_OPTION) {
            getSpringMeadow();
        }

        // if choosing to go to Garden Gate
        else if (mainPark == JOptionPane.NO_OPTION) {
            getGardenGate();
        }

        // if choosing to go to Aeryn's Overlook
        else if (mainPark == JOptionPane.CANCEL_OPTION) {
            getAerynsOverlook();
        }

        // if pressing the 'x'
        else {
            endingIsFalse (true);
        }
    
    }
    
    /**
     * The getSpringMeadow() method shows an initial dialog and gives the user
     * the ability to explore the Big Oak Tree or a Babbling Brook. Then, the 
     * user may go to the Reading Nook using getReadingNook() or go back to the 
     * Main Park using getMainPark2().
     */
    public void getSpringMeadow() {
        
        Object[] choiceBranchMeadow = {"Explore the Big Oak Tree",
            "Explore the Babbling Brook", "Go to the Reading Nook",
            "Go to Main Park"};
        
        int springMeadow = JOptionPane.showOptionDialog (null, "You have chosen"
            + " the Spring Meadow.\nIn the Spring Meadow, there is a Big Oak "
            + "Tree and a Babbling Brook.\nTo the south, there is a Reading "
            + "Nook.\n\nYou have visited here " + visitedSpringMeadow + " "
            + "time(s).", "Spring Meadow", JOptionPane.PLAIN_MESSAGE,
            JOptionPane.YES_NO_CANCEL_OPTION, springMeadowMap,
            choiceBranchMeadow, choiceBranchMeadow[0]);
            
        // if exploring the Big Oak Tree
        if (springMeadow == JOptionPane.YES_OPTION) {
            
            // for loop to increment times visited, this is in every option
            // individually
            for (visitedSpringMeadow = 0; visitedSpringMeadow < 999;
                visitedSpringMeadow++) {
                
                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + "explore the Big Oak Tree.\nUnderneath, you have found "
                    + "two Easter eggs\nand a neatly-packaged marshmellow Peep."
                    , "Big Oak Tree", JOptionPane.INFORMATION_MESSAGE);
                
                visitedSpringMeadow += 1;
                getSpringMeadow();
                
            }
                
        }

        // if exploring the Babbling Brook
        else if (springMeadow == JOptionPane.NO_OPTION) {
                
            for (visitedSpringMeadow = 0; visitedSpringMeadow < 999;
                visitedSpringMeadow++) {
                
                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + "explore the Babbling Brook.\nYou gaze into it, "
                    + "realizing that you see the\nreflection of a bunny in it"
                    + "...", "Babbling Brook", JOptionPane.INFORMATION_MESSAGE);
                
                visitedSpringMeadow += 1;
                getSpringMeadow();
                
            }
            
        }

        // if choosing to go to the Reading Nook
        else if (springMeadow == JOptionPane.CANCEL_OPTION) {
            
            for (visitedSpringMeadow = 0; visitedSpringMeadow < 999;
                visitedSpringMeadow++) {
                
                visitedSpringMeadow += 1;
                getReadingNook();
                
            }
    
        }
            
        // if pressing the 'x'
        else if (springMeadow == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }
        
        // else (if choosing to go back to the Main Park)
        else {
                
            for (visitedSpringMeadow = 0; visitedSpringMeadow < 999;
                visitedSpringMeadow++) {
                
                visitedSpringMeadow += 1;
                getMainPark2();
                
            }
        
        }
        
    }
    
    /**
     * The getReadingNook() method shows an initial dialog and gives the user
     * the ability to explore a Bench Cushion and a Bookshelf. Then, the user
     * can go back to the Spring Meadow using getSpringMeadow().
     */
    public void getReadingNook() {
        
        Object[] choiceBranchNook = {"Explore the Bench Cushion",
            "Explore the Bookshelf", "Go to Spring Meadow"};
        
        int readingNook = JOptionPane.showOptionDialog (null, "You have chosen "
            + "to go to the Reading Nook.\nInside, you find a Bench Cushion and"
            + " a Bookshelf.\nTo the north is Spring Meadow.\n\nYou have "
            + "visited here " + visitedReadingNook + " time(s).", "Reading Nook"
            , JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
            readingNookMap, choiceBranchNook, choiceBranchNook[0]);

        // if exploring the Bench Cushion
        if (readingNook == JOptionPane.YES_OPTION) {
            
            for (visitedReadingNook = 0; visitedReadingNook < 999;
            visitedReadingNook++) {
            
                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + " explore the\nBench Cushion.\nOn it, you find a picture "
                    + "of yourself\nwhen you were 5 years old,\nstanding with "
                    + "the Easter Bunny...", "Bench Cushion",
                    JOptionPane.INFORMATION_MESSAGE);
    
                visitedReadingNook += 1;
                getReadingNook();
                
            }
        
        }

        // if exploring the Bookshelf
        else if (readingNook == JOptionPane.NO_OPTION) {
            
            for (visitedReadingNook = 0; visitedReadingNook < 999;
            visitedReadingNook++) {
            
                JOptionPane.showMessageDialog (null, "You notice some of the "
                    + "books\non the bookshelf are disheveled.\nYou pull them "
                    + "off the shelf to reveal three\nneatly-packaged "
                    + "marshmellow Peeps.", "Bookshelf",
                    JOptionPane.INFORMATION_MESSAGE);
            
                visitedReadingNook += 1;
                getReadingNook();
                
            }
        
        }

        // if pressing the 'x'
        else if (readingNook == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }

        // else (if choosing to go back to Spring Meadow)
        else {
            
            for (visitedReadingNook = 0; visitedReadingNook < 999;
            visitedReadingNook++) {
            
                visitedReadingNook += 1;
                getSpringMeadow();
            
            }
            
        }
        
    }
    
    /**
     * The getAerynsOverlook() method shows an initial dialog and allows the
     * user to explore a Garden Bench or a Butterfly Bush. Then, the user may go
     * to the Peaceful Pond using getPeacefulPond() or go back to the Main Park
     * using getMainPark2().
     */
    public void getAerynsOverlook() {
        
        Object[] choiceBranchAeryn = {"Explore the Garden Bench",
            "Explore the Butterfly Bush", "Go to the Peaceful Pond",
            "Go to Entrance"};
        
        int aerynsOverlook = JOptionPane.showOptionDialog (null, "You have "
            + "chosen to go to Aeryn's Overlook.\nUpon your arrival, you "
            + "notice a Garden Bench and a Butterfly Bush.\nTo the west, there "
            + "is the Peaceful Pond.\n\nYou have visited here " +
            visitedAerynsOverlook + " time(s).", "Aeryn's Overlook",
            JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
            aerynsOverlookMap, choiceBranchAeryn, choiceBranchAeryn[0]);
            
        // if exploring the Garden Bench
        if (aerynsOverlook == JOptionPane.YES_OPTION) {
            
            for (visitedAerynsOverlook = 0; visitedAerynsOverlook < 999; 
            visitedAerynsOverlook++) {
            
                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + "explore the Garden Bench.\nUnderneath, you have found "
                    + "three Easter eggs\nand a chocolate bunny.",
                    "Garden Bench", JOptionPane.INFORMATION_MESSAGE);
    
                visitedAerynsOverlook += 1;
                getAerynsOverlook();
        
            }
            
        }

        // if exploring the Butterfly Bush
        else if (aerynsOverlook == JOptionPane.NO_OPTION) {
        
            for (visitedAerynsOverlook = 0; visitedAerynsOverlook < 999; 
            visitedAerynsOverlook++) {
            
                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + "explore the Butterfly Bush.\nYou notice a Giant Golden "
                    + "Egg inside of it!", "Butterfly Bush",
                    JOptionPane.INFORMATION_MESSAGE);
            
                visitedAerynsOverlook += 1;
                getAerynsOverlook();
        
            }
            
        }

        // if choosing to go to the Peaceful Pond
        else if (aerynsOverlook == JOptionPane.CANCEL_OPTION) {
        
            for (visitedAerynsOverlook = 0; visitedAerynsOverlook < 999; 
            visitedAerynsOverlook++) {
            
                visitedAerynsOverlook += 1;
                getPeacefulPond();
        
            }
            
        }
        
        // if user presses the 'x'
        else if (aerynsOverlook == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }

        // else (if choosing to go back to Park Entrance)
        else {
        
            for (visitedAerynsOverlook = 0; visitedAerynsOverlook < 999; 
            visitedAerynsOverlook++) {
            
                visitedAerynsOverlook += 1;
                getMainPark2();
            
            }
            
        }
    
    }
    
    /**
     * The getPeacefulPond() method shows an initial dialog and allows the
     * user to explore a Koi Pond. Then, the user may go to Raven's Tower using
     * getRavensTower() or go back to the Peaceful Pond using getPeacefulPond().
     */
    public void getPeacefulPond() {
     
        Object[] choiceBranchPond = {"Explore the Koi Pond",
            "Go to Raven's Tower", "Go to Aeryn's Overlook"};
        
        int peacefulPond = JOptionPane.showOptionDialog (null, "You have chosen"
            + " to go to the Peaceful Pond.\nThe pond is actually a Koi Pond.\n"
            + "To the north, there is Raven's Tower.\nTo the east, there is "
            + "Aeryn's Overlook.\n\nYou have visited here " +
            visitedPeacefulPond + " time(s).", "Peaceful Pond",
            JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
            peacefulPondMap, choiceBranchPond, choiceBranchPond[0]);
        
        // if exploring the Koi Pond
        if (peacefulPond == JOptionPane.YES_OPTION) {
            
            for (visitedPeacefulPond = 0; visitedPeacefulPond < 999;
            visitedPeacefulPond++) {
            
                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + "explore the Koi Pond.\nSuddenly, a koi fish pops out of"
                    + " the water and splashes you!", "Koi Pond",
                    JOptionPane.WARNING_MESSAGE);
            
                visitedPeacefulPond += 1;
                getPeacefulPond();
        
            }
            
        }
        
        // if choosing to go to Raven's Tower
        else if (peacefulPond == JOptionPane.NO_OPTION) {
        
            for (visitedPeacefulPond = 0; visitedPeacefulPond < 999;
            visitedPeacefulPond++) {
                
                visitedPeacefulPond += 1;
                getRavensTower();
            
            }
            
        }
        
        // if choosing to go back to Aeryn's Overlook
        else if (peacefulPond == JOptionPane.CANCEL_OPTION) {
        
            for (visitedPeacefulPond = 0; visitedPeacefulPond < 999;
            visitedPeacefulPond++) {
            
                visitedPeacefulPond += 1;
                getAerynsOverlook();
                
            }
            
        }

        // else (if user presses the 'x')
        else {
            endingIsFalse (true);
            }
            
        }
    
    /**
     * The getRavensTower() method shows an initial dialog and allows the
     * user to explore a Flower Box or a Telescope. If the user chooses the
     * Flower Box, the user wins and the game ends. If exploring the Telescope,
     * the user may go back to the Peaceful Pond using getPeacefulPond().
     */    
    public void getRavensTower() {
        
        Object[] choiceBranchTower = {"Explore the Flower Box",
            "Explore the Telescope", "Go to the Peaceful Pond"};
        
        int ravensTower = JOptionPane.showOptionDialog (null, "You have chosen "
            + "to go to Raven's Tower.\nYou look inside to find a Flower Box "
            + "and a Telescope.\n\nYou have visited here " + visitedRavensTower
            + " time(s).", "Raven's Tower", JOptionPane.PLAIN_MESSAGE,
            JOptionPane.YES_NO_CANCEL_OPTION, ravensTowerMap, choiceBranchTower,
            choiceBranchTower[0]);

        // if exploring the Flower Box
        if (ravensTower == JOptionPane.YES_OPTION) {
            
            JOptionPane.showMessageDialog (null, "You have chosen to explore "
                + "the Flower Box.\nYou open it to find a plush doll of the "
                + "Easter Bunny.", "Flower Box",
                JOptionPane.INFORMATION_MESSAGE);
            
            JOptionPane.showMessageDialog (null, "Great job, " + explorerName + 
                "!\nYou have found a plush doll of the Easter Bunny.\nYou head"
                + "toward the park entrance, completing your quest.", "The End",
                JOptionPane.INFORMATION_MESSAGE);
            
            // endingIsFalse becomes true, thus ending the do-while loop in
            // EasterBunnyTester
            endingIsFalse (true);
            
        }

        // if exploring the Telescope
        else if (ravensTower == JOptionPane.NO_OPTION) {
            
            for (visitedRavensTower = 0; visitedRavensTower < 999;
            visitedRavensTower++) {
            
                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + "explore the Telescope.\nYou see underneath it five "
                    + "chocolate eggs\nand a shining, golden ring.", "Telescope"
                    , JOptionPane.INFORMATION_MESSAGE);
            
                visitedRavensTower += 1;
                getRavensTower();
                
            }
        
        }
        
        // if user presses the 'x'
        else if (ravensTower == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }
        
        // else (if user chooses to go back to Peaceful Pond)
        else {
            
            for (visitedRavensTower = 0; visitedRavensTower < 999;
            visitedRavensTower++) {
            
                visitedRavensTower += 1;
                getPeacefulPond();
                
            }
            
        }
        
    }
    
    /**
     * The getGardenGate() method is the intro to the Garden area of the park.
     * From this method, you may go to the Rose Garden, the Butterfly Garden, or
     * the Flowering Forest.
     */
    public void getGardenGate() {

        Object[] choiceBranchGarden = {"Go to Flowering Forest",
            "Go to the Rose Garden", "Go to the Butterfly Garden"};
        
        int gardenGate = JOptionPane.showOptionDialog (null, "To the east, "
            + "you have the Flowering Forest.\nTo the south, you have the Rose "
            + "Garden.\nTo the southeast, you have the Butterfly Garden.\n\nYou"
            + " have visited here " + visitedGardenGate + " time(s).",
            "The Garden", JOptionPane.PLAIN_MESSAGE,
            JOptionPane.YES_NO_CANCEL_OPTION, gardenGateMap, choiceBranchGarden,
            choiceBranchGarden[0]);
        
        // if choosing the flowering Forest
        if (gardenGate == JOptionPane.YES_OPTION) {
            
            for (visitedGardenGate = 0; visitedGardenGate < 999;
                visitedGardenGate++) {
            
                visitedGardenGate += 1;
                getFloweringForest();
                
            }
            
        }
        
        // if choosing to go to the Rose Garden
        else if (gardenGate == JOptionPane.NO_OPTION) {
            
            for (visitedGardenGate = 0; visitedGardenGate < 999;
                visitedGardenGate++) {
            
                visitedGardenGate += 1;
                getRoseGarden();
                
            }
            
        }
        
        // if user presses the 'x'
        else if (gardenGate == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }
        
        // else (if choosing to go to the Butterfly Garden)
        else {
            
            for (visitedGardenGate = 0; visitedGardenGate < 999;
                visitedGardenGate++) {
            
                visitedGardenGate += 1;
                getButterflyGarden();
                
            }
            
        }
        
    }
    
    /**
     * The getFloweringForest() method shows an initial dialog and allows the
     * user to explore a Rainbow Tree or Tree Swing. Then, the user may go
     * to the Festive Falls using getFestiveFalls() or go back to the Garden
     * Gate using getGardenGate().
     */
    public void getFloweringForest() {
        
        Object[] choiceBranchForest = {"Explore the Tree Swing",
            "Explore the Rainbow Tree", "Go to Festive Falls",
            "Go to Garden Gate"};
            
        int floweringForest = JOptionPane.showOptionDialog (null, "You have"
            + " chosen the Flowering Forest.\nYou first notice that there "
            + "is a Swing hanging from a beautiful Rainbow Tree.\nTo the "
            + "east, there is the Festive Falls.\n\nYou have visited here "
            + visitedFloweringForest + " time(s).", "Flowering Forest",
            JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
            floweringForestMap, choiceBranchForest, choiceBranchForest[0]);
        
         // if exploring the Tree Swing
        if (floweringForest == JOptionPane.YES_OPTION) {
            
            for (visitedFloweringForest = 0; visitedFloweringForest < 999;
                visitedFloweringForest++) {

                JOptionPane.showMessageDialog (null, "You have chosen to "
                    + "explore the Tree Swing.\nYou see sitting on top of it "
                    + "a beautiful Flower Garland to put in your hair.",
                    "Tree Swing", JOptionPane.INFORMATION_MESSAGE);

                visitedFloweringForest += 1;
                getFloweringForest();
                
            }
                
        }

        // if exploring the Rainbow Tree
        else if (floweringForest == JOptionPane.NO_OPTION) {
            
            for (visitedFloweringForest = 0; visitedFloweringForest < 999;
                visitedFloweringForest++) {

                JOptionPane.showMessageDialog (null, "You pass the Tree Swing "
                    + "to examine the Rainbow Tree.\nSuddenly, you see a bunny "
                    + "run very quickly behind it!", "Rainbow Tree",
                    JOptionPane.INFORMATION_MESSAGE);

                visitedFloweringForest += 1;
                getFloweringForest();
                
            }
        
        }
        
        // if choosing to go to the Festive Falls
        else if (floweringForest == JOptionPane.CANCEL_OPTION) {
            
            for (visitedFloweringForest = 0; visitedFloweringForest < 999;
                visitedFloweringForest++) {
            
                visitedFloweringForest += 1;
                getFestiveFalls();
                
            }
            
        }
        
        // if user presses the 'x'
        else if (floweringForest == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }

        // else (if choosing to go back to the Garden Gate)
        else {

            for (visitedFloweringForest = 0; visitedFloweringForest < 999;
                visitedFloweringForest++) {
            
                visitedFloweringForest += 1;
                getGardenGate();
                
            }
            
        }
    
    }
    
    /**
     * The getFestiveFalls() method shows an initial dialog and allows the
     * user to explore a Mossy Rock or a Clump of Daisies. Then, the user may go
     * back to the Flowering Forest using getFloweringForest().
     */
    public void getFestiveFalls() {
        
        Object[] choiceBranchFalls = {"Explore the Mossy Rock",
            "Explore the Clump of Daisies", "Go to Flowering Forest"};
        
        int festiveFalls = JOptionPane.showOptionDialog (null, "You "
            + "have chosen the Festive Falls.\nYou see a Mossy Rock and"
            + " a Clump of Daisies.\nTo the west is the Flowering Forest.\n\n"
            + "You have been here " + visitedFestiveFalls + " times.",
            "Festive Falls", JOptionPane.PLAIN_MESSAGE,
            JOptionPane.YES_NO_CANCEL_OPTION, festiveFallsMap, choiceBranchFalls
            , choiceBranchFalls[0]);
                
        // if exploring Mossy Rock
        if (festiveFalls == JOptionPane.YES_OPTION) {
            
            for (visitedFestiveFalls = 0; visitedFestiveFalls < 999;
                visitedFestiveFalls++) {

                JOptionPane.showMessageDialog (null, "You walk up to the "
                    + "Mossy Rock.\nBehind it, you find about a dozen "
                    + "delicious Cadbury Eggs.", "Mossy Rock",
                    JOptionPane.INFORMATION_MESSAGE);

                visitedFestiveFalls += 1;
                getFestiveFalls();
            
            }
            
        }

        // if exploring Clump of Daisies
        else if (festiveFalls == JOptionPane.NO_OPTION) {
            
            for (visitedFestiveFalls = 0; visitedFestiveFalls < 999;
                visitedFestiveFalls++) {

                JOptionPane.showMessageDialog (null, "You walk up to the "
                    + "Clump of Daisies.\nIn them, you see a bunch of "
                    + "adorable baby chicks playing!", "Clump of Daisies",
                JOptionPane.INFORMATION_MESSAGE);

                visitedFestiveFalls += 1;
                getFestiveFalls();
                
            }
            
        }
        
        // if user chooses to go back to Flowering Forest
        else if (festiveFalls == JOptionPane.CANCEL_OPTION) {
            
            for (visitedFestiveFalls = 0; visitedFestiveFalls < 999;
                visitedFestiveFalls++) {
            
                visitedFestiveFalls += 1;
                getFloweringForest();
                
            }
            
        }
        
        // else (if user presses the 'x'
        else {
            endingIsFalse (true);
        }

    }
    
    /**
     * The getRoseGarden() method shows an initial dialog and allows the
     * user to explore Red Star Rose Bushes or Pink Lady Rose Bushes. Then, the 
     * user may go to the Bunny Bridge using getBunnyBridge() or go back to the
     * Garden Gate using getGardenGate().
     */
    public void getRoseGarden() {
        
        Object[] choiceBranchRoses = {"Explore the Red Star Roses",
            "Explore the Pink Lady Roses", "Go to the Bunny Bridge",
            "Go to the Garden Gate"};
        
        int roseGarden = JOptionPane.showOptionDialog (null, "You have chosen "
            + "the Rose Garden.\nUpon entering the Rose Garden, you see some "
            + "Red Star Rose Bushes and Pink Lady Rose Bushes.\nTo the west, "
            + "there is a bridge, aptly titled the Bunny Bridge.\nTo the north,"
            + "there is the Garden Gate.\n\nYou have visited here " +
            visitedRoseGarden + " time(s).", 
            "Rose Garden", JOptionPane.PLAIN_MESSAGE, 
            JOptionPane.YES_NO_CANCEL_OPTION, gardensMap, choiceBranchRoses,
            choiceBranchRoses[0]);

        // if exploring the Red Star Rose Bushes
        if (roseGarden == JOptionPane.YES_OPTION) {
            
            for (visitedRoseGarden = 0; visitedRoseGarden < 999;
                visitedRoseGarden++) {
            
                JOptionPane.showMessageDialog (null, "You examine the Red Star"
                    + "Rose Bushes.\nYou find a remote-controlled, Easter Bunny"
                    + "-themed airplane.", "Red Star Rose Bushes",
                    JOptionPane.INFORMATION_MESSAGE);
            
                visitedRoseGarden += 1;
                getRoseGarden();
                
            }
        
        }

        // if exploring the Pink Lady Rose Bushes
        else if (roseGarden == JOptionPane.NO_OPTION) {
            
            for (visitedRoseGarden = 0; visitedRoseGarden < 999;
                visitedRoseGarden++) {
            
                JOptionPane.showMessageDialog (null, "You examine the Pink Lady"
                    + " Rose Bushes.\nYou find an ornate Easter Basket chock-"
                    + "full of delicious, rare Easter treats.",
                    "Pink Lady Rose Bushes", JOptionPane.INFORMATION_MESSAGE);
                
                visitedRoseGarden += 1;
                getRoseGarden();
                
            }
        
        }

        // if choosing to go to Bunny Bridge
        else if (roseGarden == JOptionPane.CANCEL_OPTION) {
            
            for (visitedRoseGarden = 0; visitedRoseGarden < 999;
                visitedRoseGarden++) {
            
                visitedRoseGarden += 1;
                getBunnyBridge();
                
            }
        
        }
        
        // if pressing the 'x'
        else if (roseGarden == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }
        
        // else (if choosing to go back to Garden Gate)
        else {
            
            for (visitedRoseGarden = 0; visitedRoseGarden < 999;
                visitedRoseGarden++) {
            
                visitedRoseGarden += 1;
                getGardenGate();
                
            }
            
        }
    
    }
    
    /**
     * The getButterflyGarden() method shows an initial dialog and allows the
     * user to explore a Milkweed Plant or a Fairy Statue. Then, the user may
     * user may go to the Bunny Bridge using getBunnyBridge() or go back to the
     * Garden Gate using getGardenGate().
     */
    public void getButterflyGarden() {
    
        Object[] choiceBranchButterfly = {"Explore the Milkweed Plant", 
            "Explore the Fairy Statue", "Go to Bunny Bridge"};
        
        int butterflyGarden = JOptionPane.showOptionDialog (null, "You have "
            + "chosen the Butterfly Garden.\nUpon entering the Butterfly "
            + "Garden, you see a Milkweed Plant and a Fairy Statue.\nTo the "
            + "east, there is a bridge, aptly titled the Bunny Bridge.\nTo the"
            + "northwest, there is the Garden Gate.\n\nYou have visited here "
            + visitedButterflyGarden + " times.", "Butterfly Garden",
            JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
            gardensMap, choiceBranchButterfly, choiceBranchButterfly[0]);

        // if exploring the Milkweed Plant
        if (butterflyGarden == JOptionPane.YES_OPTION) {
            
            for (visitedButterflyGarden = 0; visitedButterflyGarden < 999;
                visitedButterflyGarden++) {
                
                JOptionPane.showMessageDialog (null, "You examine the Milkweed "
                    + "Plant.\nUpon approaching, five beautiful Monarch "
                    + "Butterflies emerge from the plant. You put your hand out"
                    + " in front of you and a Butterfly lands on it.",
                    "Milkweed Plant", JOptionPane.INFORMATION_MESSAGE);
                
                visitedButterflyGarden += 1;
                getButterflyGarden();
                
            }
        
        }

        // if exploring the Fairy Statue
        else if (butterflyGarden == JOptionPane.NO_OPTION) {
            
            for (visitedButterflyGarden = 0; visitedButterflyGarden < 999;
                visitedButterflyGarden++) {
            
                JOptionPane.showMessageDialog (null, "You examine the Fairy "
                    + "Statue.\nNext to it, you find four delicate, light blue "
                    + "eggs.", "Fairy Statue", JOptionPane.INFORMATION_MESSAGE);
                
                visitedButterflyGarden += 1;
                getButterflyGarden();
                
            }
                
        }

        // if choosing to go to Bunny Bridge
        else if (butterflyGarden == JOptionPane.CANCEL_OPTION) {
            
            for (visitedButterflyGarden = 0; visitedButterflyGarden < 999;
                visitedButterflyGarden++) {
            
                visitedButterflyGarden += 1;
                getBunnyBridge();
                
            }

        }
        
        // if pressing the 'x'
        else if (butterflyGarden == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }
        
        // else (if choosing to go back to the Garden Gate)
        else {
            
            for (visitedButterflyGarden = 0; visitedButterflyGarden < 999;
                visitedButterflyGarden++) {
            
                visitedButterflyGarden += 1;
                getGardenGate();
                
            }
            
        }
     
    }
    
    /**
     * The getBunnyBridge() method shows an initial dialog and allows the
     * user to explore a Camera. If the user chooses the Camera, the user wins 
     * and the game ends. Otherwise, the user may go to the Rose Garden using
     * getRoseGarden() or the Butterfly Garden using getButterflyGarden();
     */ 
    public void getBunnyBridge() {
    
        Object[] choiceBranchBridge = {"Explore the Camera",
            "Go to the Rose Garden", "Go to the Butterfly Garden"};
        
        int bunnyBridge = JOptionPane.showOptionDialog (null, "You  have chosen"
            + " the Bunny Bridge.\nAt the top of the bridge, you spot a Camera "
            + "on a tripod.\nTo the west, there is the Rose Garden.\n\nYou've "
            + "visited here " + visitedBunnyBridge + " times.",
            "Bunny Bridge", JOptionPane.PLAIN_MESSAGE,
            JOptionPane.YES_NO_CANCEL_OPTION, gardensMap, choiceBranchBridge,
            choiceBranchBridge[0]);

            // if exploring the camera
            if (bunnyBridge == JOptionPane.YES_OPTION) {
            
                JOptionPane.showMessageDialog (null, "You examine the Camera. "
                    + "You set the timer on it to take a picture.\nThe flash "
                    + "snaps, and the picture prints from the Camera to reveal "
                    + "you standing with a bunny...\nYou turn around to see the"
                    + " Easter Bunny standing behind you!", "Camera",
                    JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog (null, "Great job, " + 
                    explorerName + "!\nYou have found the Easter Bunny,\nwith a"
                    + " souvenir to boot.\nYou have completed your quest.",
                    "The End", JOptionPane.INFORMATION_MESSAGE);
                
                endingIsFalse (true);
            
            }

            // if choosing to go to the Rose Garden
            else if (bunnyBridge == JOptionPane.NO_OPTION) {
            
                for (visitedBunnyBridge = 0; visitedBunnyBridge < 999;
                    visitedBunnyBridge++) {
                
                    visitedBunnyBridge += 1;
                    getRoseGarden();
                    
                }
        
            }
        
            // if choosing to go to the Butterfly Garden
            else if (bunnyBridge == JOptionPane.CANCEL_OPTION) {
                
                for (visitedBunnyBridge = 0; visitedBunnyBridge < 999;
                    visitedBunnyBridge++) {
                    
                    visitedBunnyBridge += 1;
                    getButterflyGarden();
                    
                }
                
            }
            
            // else (if pressing the 'x')
            else {
                endingIsFalse (true);
            }
            
    }
    
    /**
     * The getMainPark2() method is almost a repeat of getMainPark1(), the first
     * area you enter. From this method, you may go to the Spring Meadow, the 
     * Garden Gate, or Aeryn's Overlook. The method also allows the user to exit
     * the park, officially ending the game.
     */
    public void getMainPark2() {
        
        // intialization of objects to have custom buttons (for choices)
        Object[] choiceBranchPark = {"Go to Spring Meadow",
            "Open the Garden Gate", "Go to Aeryn's Overlook", "Exit the Park"};
        
        int mainPark = JOptionPane.showOptionDialog (null, "To the west, "
            + "you have the Spring Meadow.\nTo the east, you have the Garden"
            + "Gate.\nTo the south, you have Aeryn's Overlook.\nYou may also"
            + " choose to leave the park.\n\nYou have visited here " +
            visitedMainPark + " times.", "Main Park", JOptionPane.PLAIN_MESSAGE,
            JOptionPane.YES_NO_CANCEL_OPTION, fullMap, choiceBranchPark,
            choiceBranchPark[0]);
        
        // if choosing to go to Spring Meadow
        if (mainPark == JOptionPane.YES_OPTION) {
        
            for (visitedMainPark = 1; visitedMainPark < 999;
                visitedMainPark++) {
                
                visitedMainPark += 1;
                getSpringMeadow();
                    
            }
            
        }
        
        // if choosing to go to Garden Gate
        else if (mainPark == JOptionPane.NO_OPTION) {
                
            for (visitedMainPark = 1; visitedMainPark < 999;
                visitedMainPark++) {
                
                visitedMainPark += 1;
                getGardenGate();
                    
            }
            
        }
        
        // if choosing to go to Aeryn's Overlook
        else if (mainPark == JOptionPane.CANCEL_OPTION) {
                
            for (visitedMainPark = 1; visitedMainPark < 999;
                visitedMainPark++) {
                
                visitedMainPark += 1;
                getAerynsOverlook();
                    
            }
        
        }
        
        // if pressing the 'x'
        else if (mainPark == JOptionPane.CLOSED_OPTION) {
            endingIsFalse (true);
        }
        
        // else (if choosing to exit the park)
        else {
            
            JOptionPane.showMessageDialog (null, "You have chose to exit the "
                + "park.\nYou take note of all your goodies as you walk through"
                + " the exit.", "The End", JOptionPane.INFORMATION_MESSAGE);
                
            endingIsFalse (true);
            
        }
    
    }

}