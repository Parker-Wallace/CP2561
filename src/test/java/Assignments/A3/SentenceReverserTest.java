package Assignments.A3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceReverserTest {

    @Test
    void reverseSentence() {
        String[] SCENTENCES = {
                "the quick brown fox",
                "many pretty women dancing",
                "ugly mosquitos go to the swamp",
                "theres a monster in the woods"
        };
        String[] REVERSEDSENTENCES = {
                "fox brown quick the",
                "dancing women pretty many",
                "swamp the to go mosquitos ugly",
                "woods the in monster a theres"
        };
        for (int i = 0; i < REVERSEDSENTENCES.length; i++) {
            assertEquals(SentenceReverser.reverseSentence(SCENTENCES[i]), REVERSEDSENTENCES[i]);
        }
    }
}