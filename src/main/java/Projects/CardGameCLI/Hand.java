package Projects.CardGameCLI;

import java.util.ArrayList;

/**
 * Represents a Hand in a game of Blackjack.
 * 
 * Contains methods for calculating score and printing the hands cards.
 */
public class Hand {
    public ArrayList<PlayingCard> cards;

    /**
     * Creates an instance of Hand.
     * 
     * @param cards an ArrayList containing the first 2 cards dealt in a game of blackjack.
     */
    public Hand(ArrayList<PlayingCard> cards) {
        this.cards = cards;

    }

    /**
     * Adds a PlayingCard to this Hand.
     * 
     * @param card the card being dealt to this Hand.
     */
    public void addCard(PlayingCard card){
        this.cards.add(card);
    }

    /**
     * Gets the score of this Hand according to blackjack rules.
     * 
     * @return The current score of this Hand according to blackjack rules.
     */
    public int getScore() {
        int score = 0;
        for (PlayingCard card: this.cards) {
            if (card.getValue() > 10) {
                score += 10;
            }
            else if (card.getValue() == 1 && score <= 10) {
                score += 11;
            }
            else {
                score += card.getValue();
            }

        }
        return score;
    }

    @Override
    public String toString() {
        StringBuilder cardsasString = new StringBuilder();
        for (PlayingCard card : this.cards) {
            cardsasString.append(card.toString());
        }
        return cardsasString.toString();
    }
}


