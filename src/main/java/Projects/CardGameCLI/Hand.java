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
            else if (card.getValue() == 1 && score + 11 <= 21) {
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

    public void printCards() {


        // Iterate over each card and build the lines
        String[] cardLines = new String[7];
        for (int i = 0; i < 7; i++) {
            StringBuilder lineBuilder = new StringBuilder();
            for (PlayingCard card : this.cards) {
            String value;
            String face = "";
            value = switch (card.value) {
                case 1 -> "A";
                case 11 -> "J";
                case 12 -> "Q";
                case 13 -> "K";
                default -> String.valueOf(card.value);
            };
            if (null != card.suit) switch (card.suit) {
                case DIAMONDS -> face = "^";
                case HEARTS -> face = "&";
                case CLUBS -> face = "v";
                case SPADES -> face = "o";
                default -> {
                }
            }
                String[] lines = new String[7];
                lines[0] = "┌─────────┐";
                lines[1] = String.format("│ %-2s      │", value);
                lines[2] = "│         │";
                lines[3] = String.format("│    %s    │", face);
                lines[4] = "│         │";
                lines[5] = String.format("│      %-2s │", value);
                lines[6] = "└─────────┘";

                lineBuilder.append(lines[i]).append(" ");
                cardLines[i] = lineBuilder.toString();
            }
        }

        // Print each line
        for (String line : cardLines) {
            System.out.println(line);
        }
    }
}


