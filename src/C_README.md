# DiceGame
## Download Source Code
* [DOWNLOAD](https://github.com/Aidan-Cornett/Java-Projects/blob/main/src/C1_DiceGame.java)
## TLDR
This is my final for my Java class at Grayson College, it's fairly simple but my first draft is frought with many fun mistakes. It was made to help me learn User-defined methods (mainly), input validation and exception handling and the basics of Java.

I also wanted to write this README for students who want to reference why I did things and I hope that's helpful. Though I think they should use this as a "I got hung up on x part" not a guide on how to make the program.
## What does it do?
* The user is prompted with a menu of 4 options.
 1. Set number of rolls (Current: 1)
 2. 1 die (2-12)
 3. 2 die (1-6) + (1-6)
 4. Quit program
 
 ## The menu
 The menu is asking for a response (1, 2, 3, or 4). This is checked based on the following:
 * Is it a number? 
	 * This must be checked first because exceptions do not like being checked with an *if()* statement.
 * Is it 1, 2, 3, or 4?

If these things are true then response validity (*isValidR*) is set to true. **Validity is true ONLY for the time of the block execution.** Meaning, while the program is doing math and rolling dice, what you put is valid. It becomes invalid once the  program has finished rolling dice and printing counts and the histogram. Because **while** your response is invalid the menu will be asking you what it should do.
 ## Set number of rolls (Current: X)
 This is just a while loop that checks for "Is the number of rolls (*n*) a valid number? This is based on the checks:
 * Is it a positive non-zero number?
	 * You can't roll a die 0 times, you **definitiely** can't roll a die negative times 
 * Is it too large? 
	 * I set this as a Long type of 5 trillion, good luck computing that.

If all of these things are true, then n is valid (i.e. *isValidN = true*). The loop iterates and checks again, then sets response validity to false. Which sends you back to the main menu.
## 1 die (1-6) + (1-6) and 2 dice (2-12)
These are nested for loops that set a variable called *value* to a random number (0 - 10) || (0 - 5) + (0 - 5). Then, an array of all possible results (which remember can only be 2 - 12 in both cases) is incremented by 1 AT the value that was just rolled.

like so: say on iteration 1 we roll a 9 the array then looks like this
Array (inside Java)
count[0 = 0
count[1] = 0
count[2] = 0
count[3] = 0
count[4] = 0
count[5] = 0
count[6] = 0
count[7] = 1
count[8] = 0
count[9] = 0
count[10] = 0
count[11] = 0

It is worth mention, random values are generated starting at 0 so no math is needed to place them where they go.
