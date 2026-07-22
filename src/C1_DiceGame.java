/* 
 * Aidan Corentt DiceGame ver: 4
 * ----------------------------
 * I will put my original pseudocode notes above most of my main functions for readability!
 * I am enjoying this SO much! Basically spent the whole day (7 / 20 /2026) adding small things and fixing bugs!
 * 
 * Version 4: added a bunch of methods and fixed irrelevant errors when getting n from input
 * 
 * I want to put a loading bar, but my first attempt 100x'd my time so research is needed.
 */


import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.lang.Math;
import java.text.DecimalFormat;

public class C1_DiceGame {
    public static long[] roll2Dice(long rolls, Random die, long[] count) {
        long i;
        for (i = 1; i <= rolls; ++i) {
            int value = die.nextInt(6) + die.nextInt(6);
            count[value] += 1;
        }
        return count;
    }

    public static long[] roll1Die(long rolls, Random die, long[] count) {
        long i;
        for (i = 1; i <= rolls; ++i) {
            int value = die.nextInt(11);
            count[value] += 1;
        }
        return count;
    }
    
    //validates the users input of N
    public static long validateN (long n, Scanner scnr) {
        boolean validLong = false;
        System.out.println("\nHow many times would you like to roll your die / dice?");
        //check if valid integer
        try {
            n = scnr.nextLong();
            validLong = true;
        }
        catch (InputMismatchException e) {
            System.out.println("> Input is not a valid integer.\n");
            scnr.next();
        }
        
        //check if 0 or negative
        if (n <= 0 && validLong == true) {
            System.out.println("> Negatives or zero values are not valid.\n");
            return 0;
        }
        else if (n > 1_000_000_000_000_000_000L && validLong == true) {
            System.out.println("> value too large: i.e. larger than 1,000,000,000,000,000,000. (1 quintillion)\n");
            return 0;
        }
        else {
            return n;
        }
    }
    
    //prints the total times a certain value is rolled
    public static void printFrequency (long[] count) {
        int i;
        System.out.print("\n----------------------\n" +
                           "  Frequency of rolls  \n" +
                           "----------------------\n");

                for (i = 0; i < 11; ++i) {
                    
                    //Resulting value formatting
                    if ((i + 2) < 10) {
                        System.out.println((i + 2) + ":  " + count[(int)i]);
                    }
                    if ((i + 2) >= 10) {
                        System.out.println((i + 2) + ": " + count[(int)i]);
                    }
                }
    }
    
    public static void printTime (long start, long end) {
        long duration = (end - start) / 1_000_000;
        if (duration != 0.0) {
            System.out.println("\n      " + (double)duration / 1000 + " seconds");
        }
        else {
            System.out.println("\n      < 0.000 seconds");
        }
        System.out.print("--------- End ----------\n\n");
        duration = 0;
    }    


    //loading bar method (WIP)
    public static void loadingBar (String placeholder) {
        //currently does nothing!
    }


    //set array with all 0's
    public static void zeroArray (long[] array) {
        int i;
        
        for (i = 0; i < array.length; ++i) {
            array[i] = 0;
        }
    }


    //find array index of max value for histogram creation, this value will == 25 asterisks.
    public static int findMax (long[] array) {
        int maxLoc = 0;
        long maxVal = array[(int)0];
        int i;

        for (i = 1; i < 11; ++i) {
            if (array[i] > maxVal) {
                maxLoc = i;
                maxVal = array[(int)i];
            }
        }
        return maxLoc;
    }


    //print the height of bar (using asterisks), this method, calculates the reltionship (using divison) between the max value and each die value. and prints a histogram of asterisks.
    public static void printDistribution (long[] array, int indexOfMax) {
        int i;
        int j;
        double max = array[indexOfMax];
        
        System.out.print("-------------------------\n" +
                         "  Distribution of rolls  \n" +
                         "-------------------------");

        for (i = 0; i < 11; ++i) {
            System.out.println("");
            if ((i + 2) < 10) {
                System.out.print((i + 2) + ":  ");
            }
            if ((i + 2) >= 10) {
                System.out.print((i + 2) + ": ");
            }

            for (j = 0; j < 25; ++j) {
                double relationToMax = (Math.round(((array[i] * 25L) / max)));
                if (j == relationToMax) {
                    break;
            }
            System.out.print("*");
            }
        }
        return;
    }


    //main!!
    public static void main (String[] args) {

        // all main variables ### check before submission ###
        Scanner scnr = new Scanner(System.in);
        Random die = new Random();
        DecimalFormat Formater = new DecimalFormat();
        // i is a long to prevent overflow for very large dice roll amounts
        long i;
        long n = 1;
        long strtTime = 0;
        long endTime = 0;
        int response = 0;
        int value = 0;
        long[] count = new long[11];
        boolean isValidN = false;
        boolean isValidR = false;


        // set every item inside arrray "count" to 0
        zeroArray(count);

        
        // menu, '1' for set roll count || '2' for 1 die || '3' for 2 die || '4' for exit 
        while (isValidR == false) {
            System.out.println("\n ----------------- Menu ----------------"                  + "\n" +
                                  "1) Set number of rolls (Current: "+Formater.format(n)+")"   + "\n" +
                                  "2) 1 die (2-12)"                                          + "\n" +
                                  "3) 2 die (1-6) + (1-6)"                                   + "\n" +
                                  "4) Quit program"                                          + "\n");
            
            
            // R input validation
            try {
                response = scnr.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("> Input is not a number.");
                scnr.next();
            }
            if (response != 1 && response != 2 && response != 3 && response != 4) {
                System.out.println("\nInvalid input\n" +
                                   "> Valid inputs: 1, 2, 3, or 4");
            }
            


            // set number of rolls block
            if (response == 1) {
                n = 0;
                isValidN = false;
                
                // ask user how many times they want to roll their die / dice, then validate their input and save to n.
                while (isValidN == false) {
                    n = validateN(n, scnr);
                    if (n != 0) {
                        isValidN = true;
                    }
                    //returns user to main menu
                    isValidR = false;
                }
            }
            


            // (2 - 12) block
            if (response == 2) {
                
                strtTime = System.nanoTime();
                isValidR = true;
                
                //value selection (2 - 12)
                count = roll1Die(n, die, count);
                
                // value and curve printing
                printFrequency(count);
                printDistribution(count, findMax(count));
                // time printing
                endTime = System.nanoTime();
                printTime(strtTime, endTime);
                // reset
                zeroArray(count);
                isValidR = false;
            }



            // (1-6) + (1-6) block, 2 rolls = 1 value
            if (response == 3) {
                strtTime = System.nanoTime();
                isValidR = true;
                
                //value selection (1 - 6) + (1 - 6)
                count = roll2Dice(n, die, count);

                printFrequency(count);
                printDistribution(count, findMax(count));
                
                //time printing
                endTime = System.nanoTime();
                printTime(strtTime, endTime);
                
                //reset
                zeroArray(count);
                isValidR = false;
            }



            // quit block
            if (response == 4) {
                isValidR = true;
                scnr.close();
                zeroArray(count);
                return;
            }
        }
    scnr.close();
    }
}