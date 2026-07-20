/* 
 * Aidan Corentt DiceGame ver: 2 
 * ----------------------------
 * I will put my original pseudocode notes above most of my main functions for readability!
 */


import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.lang.Math;

public class C1_DiceGame {
    //set array with all 0's
    public static void zeroArray (long[] array) {
        int i;
        
        for (i = 0; i < array.length; ++i) {
            array[i] = 0;
        }
    }
    
    //find array index of max value for histogram creation, this value will == 10 asterisks.
    public static int findMax(long[] array) {
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
    public static void printDistribution(long[] array, int indexOfMax) {
        int i;
        int j;
        double max = array[indexOfMax];
        
        System.out.print("-------------------------\n" +
                           "  Distribution of rolls\n" +
                           "-------------------------");

        for (i = 0; i < 11; ++i) {
            System.out.println("");
            if ((i + 2) < 10) {
                System.out.print((i + 2) + ":  ");
            }
            if ((i + 2) >= 10) {
                System.out.print((i + 2) + ": ");
            }

            for (j = 0; j < 10; ++j) {
                double relationToMax = (Math.round(((array[i] * 10L) / max)));
                if (j == relationToMax) {
                    break;
            }
            System.out.print("*");
            }
        }
        System.out.print("\n--------- End ----------");
        return;
    }

    public static void main(String[] args) {

        // all main variables ### check before submission ###
        Scanner scnr = new Scanner(System.in);
        Random die = new Random();
        // i is a long to prevent overflow
        long i;
        long n = 1;
        int response = 0;
        int value = 0;
        long[] count = new long[11];
        boolean isValidN = false;
        boolean isValidR = false;

        // set every list item inside "count" to 0
        zeroArray(count);

        
        // ask user which dice set they want: '1' for 1 die (2-12) OR '2' for 2 dice (1-6) OR '3' to exit
        // edit: Wanted a repeat menu so now, '1' for set roll count || '2' for 1 die || '3' for 2 die || '4' for exit 
        while (isValidR == false) {
            System.out.println("\n----------------Menu---------------\n" + 
                                "1) Set number of rolls (Current: "+n+")\n" +
                                "2) 1 die (2-12)\n" +
                                "3) 2 die (1-6) + (1-6)\n" +
                                "4) Quit program\n");
            // input validation
            try {
                response = scnr.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("* Input is not a number.");
                scnr.next();
            }
            if (response != 1 && response != 2 && response != 3 && response != 4) {
                System.out.println("\nInvalid input\n" +
                                   "Valid inputs: 1, 2, 3, or 4");
            }
            
            // set number of rolls block --- I REALLY didn't want to reporgram so this was my solution :)
            if (response == 1) {
                n = 0;
                isValidN = false;
                // ask user how many times they want to roll their die / dice, then validate their input and save to n.
                // I don't think try {} blocks are covered in the ZyBooks so this may be out of scope lol.
                while (isValidN == false) {
                    System.out.println("\nHow many times would you like to roll your die / dice?");
                    // input validation (condense to method if possible)
                    try {
                        n = scnr.nextLong();
                    }
                    catch (InputMismatchException e) {
                        System.out.println("* Input is not a valid integer.\n");
                        scnr.next();
                    }
                    
                    if (n <= 0) {
                        System.out.println("* Negatives or zero values are not valid.\n");
                    }
                    else if (n > 5_000_000_000_000L) {
                        System.out.println("value too large: i.e. larger than 5,000,000,000,000.\n");
                    }
                    else {
                        isValidN = true;
                    }
                    isValidR = false;
                }
            }
            
            // (2 - 12) block
            if (response == 2) {
                isValidR = true;
                for (i = 0; i < n; ++i) {
                    value = die.nextInt(11);
                    count[value] += 1;
                }
                System.out.print("\n----------------------\n" +
                                   "  Frequency of rolls\n" +
                                   "----------------------\n");

                for (i = 0; i < 11; ++i) {
                    //This is set like this to make the numbers straight
                    if ((i + 2) < 10) {
                        System.out.println((i + 2) + ":  " + count[(int)i]);
                    }
                    if ((i + 2) >= 10) {
                        System.out.println((i + 2) + ": " + count[(int)i]);
                    }
                }
                printDistribution(count, findMax(count));
                System.out.println("\n");
                zeroArray(count);
                isValidR = false;
            }

            // (1-6) + (1-6) block, 2 rolls = 1 value
            if (response == 3) {
                isValidR = true;
                for (i = 0; i < n; ++i) {
                    value = die.nextInt(6) + die.nextInt(6);
                    count[value] += 1;
                }

                System.out.print("\n----------------------\n" +
                                   "  Frequency of rolls\n" +
                                   "----------------------\n");
                for (i = 0; i < 11; ++i) {
                    if ((i + 2) < 10) {
                        System.out.println((i + 2) + ":  " + count[(int)i]);
                    }
                    if ((i + 2) >= 10) {
                        System.out.println((i + 2) + ": " + count[(int)i]);
                    }
                }
                printDistribution(count, findMax(count));
                System.out.println("\n");
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