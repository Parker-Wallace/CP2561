# Assignment 03 String Manipulation and RegEx

> Working with String Manipulation and Regular Expressions

## String Manipulation Exercises:

### Random Sentences

Write an application that uses random-number generation to create sentences.

Use four arrays of strings called article, noun, verb and preposition.

Create a sentence by selecting a word
at random from each array in the following order:

- article
- noun
- verb
- preposition
- article
- noun

As each word is picked, concatenate it to the previous words in the sentence. The words should be
separated by spaces.

When the final sentence is output, it should start with
a capital letter and end with a period.

The application should generate and display 20 sentences.

```json
{
    "article":{"the","a","one","some","any"},
    "noun":{"boy","girl","dog","town","car"},
    "verb":{"drove","jumped","ran","walked","skipped"},
    "preposition":{"to", "from","over","under","on"}
}
```
---

### Displaying a Sentence with Its Words Reversed

Write an application that inputs a line of text, tokenizes the line with String method `split` and outputs the tokens in reverse order. Use space characters as delimiters.

## Regular Expression Exercises

The files ValidateInput.java and Validate.java contain code which use regular expressions. The regular expressions could use some improvement. For example the validateLastName function allows last names to start with a lower case letter.

Perform the following improvements to the regular expression functions:

- Ensure all first names are at least 3 characters long

- Ensure all last names begin with a capital letter

- Allow addresses to contain up to 3 words. (right now up to two are allowed)

- Allow the state to allow up to 3 words( right now up to two are allowed)

- The validateZip function validates 5 digit American zip codes. Modify the regular expression so it also will validate Canadian Postal codes. (Ex// validates 54362 and A3C5K2)

- Modify the validatePhone regular expression so it requires a 2 digit country code at the start of the sequence (Ex 01-433-722-5324)

---

Often times, documents contain personal information which should not be shared. A process called redaction removes this personal information and replaces each character containing personal information with a filler character. For example the date 05-12-75 could be replaced with ##-##-##.

Given the file “sampleInfo.txt”, write a program which will replace the following:

- Dates in the format MM-DD-YY, MM-DD-YYYY EX// 08-23-89, 08-23-1989 becomes ##-##-####

- Credit card numbers. Ex// 4624-3452-2311-7344 becomes ####-####-####-####

- Currency amounts. EX// \$45, \$45.45 becomes “$##.##

- Security codes are alpha numeric codes which are 20 characters long. They begin with the Prefix: “CODE”. EX// CODE4532859341492636, becomes CODE################

Your program should open the sampleInfo.txt file, replace using a regular expression, all personal info, and then save the file as “sampleInfoRedacted.txt”.



