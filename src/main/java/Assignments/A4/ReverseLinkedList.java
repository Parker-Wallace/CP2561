package Assignments.A4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * creates a linkedlist of 10 characters a-j, and a second linkedlist containing the contents of the first reversed
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        //create both linkedlists
        LinkedList<Character> tenCharacters = new LinkedList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j'));
        LinkedList<Character> tenCharactersCopy = new LinkedList<>();

        //create an iterator to go over each element in tencharacters starting with the last element
        Iterator<Character> iterator = tenCharacters.iterator();
        int index = tenCharacters.size() - 1;
        while (iterator.hasNext()) {
            Character character = tenCharacters.get(index);
            tenCharactersCopy.add(character);
            if (index > 0) {
                index --;
            }
            else {
                break;
            }
        }
        System.out.println(tenCharacters);
        System.out.println(tenCharactersCopy);
    }
    }