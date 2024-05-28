# Assignment #2 Instructions:

## Part 1 teleophone number word generator

Standard telephone keypads contain the digits zero through nine. 

The numbers two through nine each have three letters associated with them (see below). Many people find it
difficult to memorize phone numbers, so they use the correspondence
between digits and letters to develop seven-letter words that correspond to
their phone numbers.

>For example, a person whose telephone number is 686-2377 might use the correspondence to develop
the seven-letter word “NUMBERS.” Every seven-letter word corresponds
to exactly one seven-digit telephone number. A restaurant wishing to
increase its takeout business could surely do so with the number 825-3688
(i.e., “TAKEOUT”).

Every seven-letter phone number corresponds to many different seven-
letter words, but most of these words represent unrecognizable
juxtapositions of letters. It’s possible, however, that the owner of a
barbershop would be pleased to know that the shop’s telephone number,
424-7288, corresponds to “HAIRCUT.” A veterinarian with the phone
number 738-2273 would be pleased to know that the number corresponds
to the letters “PETCARE.” An automotive dealership would be pleased to
know that the dealership number, 639-2277, corresponds to
“NEWCARS.”

|Digit|Letters|Digit|Letters|Digit|Letters|
|---|---|---|---|---|---|
|2|A B C|5|J K L|8|T U V|
|3|D E F|6|M N O|9|W X Y|
|4|G H I|7|P R S|||

Write a program that, given a seven-digit number, uses a Formatter
object to write to a file every possible seven-letter word combination
corresponding to that number. There are 2,187(3<sup>7</sup>) such combinations.
Avoid phone numbers with the digits 0 and 1.

## Part 2 Phishing Scanner

Phishing is a form of identity theft in which, in
an e-mail, a sender posing as a trustworthy source attempts to acquire
private information, such as your user names, passwords, credit-card
numbers and social security number. Phishing e-mails claiming to be from
popular banks, credit-card companies, auction sites, social networks and
online payment services may look quite legitimate. These fraudulent
messages often provide links to spoofed (fake) websites where you’re
asked to enter sensitive information.

Search online for phishing scams. Also check out the Anti-Phishing
Working Group

<http://www.antiphishing.org>

and the FBI’s Cyber Investigations website

<http://www.fbi.gov/about-us/investigate/cyber/cyber>

where you’ll find information about the latest scams and how to protect
yourself.

Create a list of 30 words, phrases and company names commonly found in
phishing messages. Assign a point value to each based on your estimate of
its likelihood to be in a phishing message (e.g., one point if it’s somewhat
likely, two points if moderately likely, or three points if highly likely).
Write an application that scans a file of text for these terms and phrases.
For each occurrence of a keyword or phrase within the text file, add the
assigned point value to the total points for that word or phrase. For each
keyword or phrase found, output one line with the word or phrase, the
number of occurrences and the point total. Then show the point total for
the entire message. Does your program assign a high point total to some
actual phishing e-mails you’ve received? Does it assign a high point total
to some legitimate e-mails you’ve received?

## Part 3 Eric's Fitness Program

Eric has been training hard for bicycle racing. He would like to write a program which keeps track of his workouts. Part of the program includes storing “settings” information.
Included in the settings information are the following:

```json
{
    "settings": ["Name",
                "Height",
                "Weight",
                "Birthday",
                "Functional Threshold Power"]
}
```

Write a simple program which demonstrates using Java Serialization to store the settings information in a file named “Settings.xml”. When the program first opens it checks if the “Settings.xml” file exists. If :it does it opens the file and de-serializes the data. The program then gives the option to

1. View the settings
2. Update the settings. 

When viewing the settings, if the Settings.xml has not been saved yet, a message to the user indicating they first need to save their settings should be displayed.


