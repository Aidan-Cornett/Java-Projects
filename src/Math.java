import java.util.Scanner;
public class Math {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);

            //What type of math do you want to learn, select from list.
            System.out.print("What type of math would you like to learn?\n" + 
                            "1) Integer Math\n" + 
                            "2) Floating-point Math\n" + 
                            "3) String comparison\n" + 
                            "Literally any other button) Back\n\n");
            int input = scnr.nextInt();

            if (input == 1) {
                System.out.print(
                    "\n-Integer Math in java-" + 
                    "\n======================\n" + 
                    "Intgers in Java are called \"primitives\" which means they are the smallest possible unit and cannot be broken further.\n" +
                    "Integer math in Java works a little differently than integer math on paper, below are important edge cases you can test on!\n" + 
                    "Pick One!\n\n" +
                    "1) Intger Division\n" +
                    "2) Intger Overflow (and underflow)\n" +
                    "Literally any other button) Back\n\n");
                
                input = scnr.nextInt();
                if (input == 1) {
                    System.out.print(
                        "\nInteger Division\n" + "================\n" +
                        "Intgers will always cut numbers after the decimal point when doing division.\n" + 
                        "Ex: (ordinarily) 15 / 4 = 3.75\n" +
                        "Ex: (integer math) 15 / 4 == 3\n\n" +
                        "Try it!\nType two numbers like this \"11 17\" and look at the result of the division and what was missed!\n" + 
                        "Or just type anything (not in that format) to quit\n\n");
                    //The integer division simulator shows the regular integer result and the omitted floating point to a ten-thousandth.
                    int num1 = scnr.nextInt();
                    int num2 = scnr.nextInt();
                    System.out.println(num1 + " / " + num2 + " == " + (num1 / num2));
                    System.out.println("You lost " + ((((double)num1 / (double)num2)) - (num1 / num2)) + "\n");
                }
            
            

                //Overflow! game, I'm fond of this little pain. Lost an hour due to having semicolons after my if statements
                else if (input == 2) {
                    System.out.print(
                        "\nOverflow!\n" +
                        "=========\n" +
                        "Sometimes numbers get just a little too big and Java doesn't know what to do and you get fun errors!\n" +
                        "To demonstrate, you will set a number and do calculations on it until it overflows!\n\n" + 
                        "What size number do you want?\n" +
                        "1) byte (8-bit) (smallest)\n" +
                        "2) short (16-bit)\n" + 
                        "3) int (32-bit)\n" +
                        "4) long (64-bit) (largest)\n" +
                        "any button) Back\n\n");
                        input = scnr.nextInt();

                        if(input == 1) {
                            System.out.println("What number do you want?");
                            byte modb = scnr.nextByte();
                            System.out.println("input 0 to quit\ninput a number to multiply your number by");
                            input = scnr.nextInt();
                            while (input != 0) {
                                modb *= input;
                                System.out.println("your number is " + modb);
                                System.out.println("input a number to multiple your number by");
                                input = scnr.nextInt();
                            }
                        }
                        else if (input == 2) {
                            System.out.println("What number do you want?");
                            short mods = scnr.nextShort();
                            System.out.println("input 0 to quit\ninput a number to multiply your number by");
                            input = scnr.nextInt();
                            while (input != 0) {
                                mods *= input;
                                System.out.println("your number is " + mods);
                                System.out.println("input a number to multiply your number by");
                                input = scnr.nextInt();
                            }
                        }
                        else if (input == 3) {
                            System.out.println("What number do you want?");
                            int modi = scnr.nextInt();
                            System.out.println("input 0 to quit\ninput a number to multiply your number by");
                            input = scnr.nextInt();
                            while (input != 0) {
                                modi *= input;
                                System.out.println("your number is " + modi);
                                System.out.println("input a number to multiple your number by");
                                input = scnr.nextInt();
                            }
                        }
                        else if (input == 4) {
                            System.out.println("What number do you want?");
                            double modd = scnr.nextDouble();
                            System.out.println("input 0 to quit\ninput a number to multiply your number by");
                            input = scnr.nextInt();
                            while (input != 0) {
                                modd *= input;
                                System.out.println("your number is " + modd);
                                System.out.println("input a number to multiple your number by");
                                input = scnr.nextInt();
                            }
                        }
                    }
                }
        

            else if (input == 2) {
                System.out.print(
                    "\n-Floating-point Math in java-" + 
                    "\n=============================\n" + 
                    "Floating-point numbers in Java are based off binary scientific notation which results in gross divisons.\n" + 
                    "Similar to decimal divisions like 1 / 3 resulting in 0.3333333... This kind of issue happens even more often in binary.\n" +
                    "This causes \"floating-point rounding error\" which should ALWAYS be accounted for.\n" +
                    "To learn more about floating-point rounding error and test on it type 1 and hit ENTER:\n\n" + 
                    "1) Rounding error demo\n" + 
                    "Literally any other button) Back\n\n");
                input = scnr.nextInt();
                if (input == 1) {
                    System.out.print(
                        "\nFloating-point rounding error!! YAY!\n" +
                         "====================================\n" +
                        "Because binary sacrifices a bit of precision when doing floating-point calculations we get rounding error at the smallest parts of floating point numbers\n" + 
                        "Since all math is done with binary and then switched to decimal, sometimes the switch loses a little bit of precision\n\n" + 
                        "To show this, input two numbers like so \"0.1 0.2\"\n\n" + 
                        "We will add these numbers and then show the actual raw unrounded result\n\n");
                    double num1 = scnr.nextDouble();
                    double num2 = scnr.nextDouble();
                    System.out.print(
                        "number 1: " + num1 + 
                        "\n+" + 
                        "\nnumber 2: " + num2 +
                        "\n==" +
                        "\nresult: " + (num1 + num2) + "\n");
                }
            }

            else if (input == 3) {
                System.out.print(
                    "\n-String Comparison in java-" + 
                    "\n===========================\n" + 
                    "While not math, Strings don't work like integers and floating point. Because unlike those two, Strings are not primitive.\n" +
                    "Instead of binary operators like ==, +, -, /, %, etc, Strings use methods such as equals(), and compareTo().\n" + 
                    "These operations effectively convert the comparison of the Strings into a number so we can work with them!\n\n" +
                    "There's not really a way to gamify this one that I know of  :'(\n\n" + 
                    "Literally any other button) Back\n\n");
                input = scnr.nextInt();
            }
            
            else {
                scnr.close();
                System.exit(0);
            }
    }
}