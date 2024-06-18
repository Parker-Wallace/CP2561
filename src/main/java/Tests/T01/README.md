# CP2561 Test Exercise Questions

The test is closed book, except you may use 
[W3 Schools](w3schools.com) and [the java API](https://docs.oracle.com/en/java/javase/20/docs/api/index.html)



# Question 1

Eric’s Bicycle shop is registering cyclists for an upcoming race. As part of the registration process, the user must enter their racing license id.

The racing license id has the following format:

3 Letter Country Code (must be capital letters) followed by 4 digit birth year(allow any 4 digit year) followed by a 2 Character Category which can be one of D1, D2, D3 or D4, followed by an underscore, followed by a 5 Digit Code(allow any 5 digits)

Here are a couple examples of valid license ids:

CAN1978D1_34523

USA1992D2_52114

Write a simple program which asks the user to enter their license id. If the user enters a valid license, output that the user is now registered for the race and the program should exit normally. If the license is invalid, output that the license is invalid and let the user try again.

Use a regular expression to validate the license id.



Sample output:
```
enter your racing license
# CAN2022D5_23
Invalid license, please try again
Enter your racing license
# MEX2021D2_53234
You are registered for the race

finished with exit code 0
```

# Question 2

Write an application that encodes English-language phrases into pig Latin. Pig latin is a form of coded language. For simplicity, use the following algorithm:

To form pig Latin phrase fro an English-language phrase, tokenize the phrase into words with String method split. To translate each English word into a pig Latin word, place the first letter of the English word at the end of the word and add the letters ‘ay’. Thus, the word ‘jump’ becomes ‘umpjay’, and the word ‘computer’ becomes ‘omputercay’. Blanks between words remain as blanks.

Assume the following: The English phrases consist of words separated by blanks, there are no punctuation marks and all words have two or more letters.

The file English.txt contains several English phrases. Your application will load this file, translate each of the phrases from English to Pig Latin and then write the Pig Latin phrases to a file PigLatin.txt.

An example of the final output is shown in the file SamplePigLatin.txt.

Use relative paths for all files.

Be sure to clean up any file resources.

For checked exceptions, print the stack trace and then exit the program with error code 1.



