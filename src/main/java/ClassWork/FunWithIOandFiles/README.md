# Exercise

1. Create a program which picks a number between 1 and 100 and asks the user to guess the number.  If the number is incorrect, the program should either indicate if the guess is too high or too low.

2. The program will store information about the guesses the user makes in a file named gamelog.txt

3. Each time a guess is made the program will record the user's guess on a new line.
4. When the correct guess is made, the program should exit.
   - write all files to a folder named "logs".
   - concatenate the current timestamp to the "gamelog" file.  This way each time you play the game you get a unique file.
5. Create a new program which loops through and opens every file in the logs folder.  The program should calculate the average number of guesses when playing the game.