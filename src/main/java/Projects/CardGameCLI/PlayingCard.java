package Projects.CardGameCLI;


/**
 * represents a common playing card.
 * each card has a specified value and belongs to one of the four suits
 * 
 * @author parker.wallace
 */
public class PlayingCard {

    public int value;
    public Suit suit;

    /**
     * Creates an instance of a playing card with the specified face value and suit.
     *
     * @param value The integer representing the card's face value (1 to 13).
     * @param suit  The suit of the playing card (e.g., Hearts, Diamonds, etc.).
     * @throws IllegalArgumentException If the provided value is not between 1 and 13,
     *                                  or if the suit is null.
     */
    public PlayingCard(int value, Suit suit) {
        if (value < 1 || value > 13) {
            throw new IllegalArgumentException("card value must be between 1 and 13");
        }

        if (suit == null) {
            throw new IllegalArgumentException("suit must be specified");
        }
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * gets the value of the playing card.
     * 
     * @return the value of the playing card (1 to 13).
     */
    public int getValue() {
        return value;
    }

    /**
     * gets the suit of the playing card.
     * 
     * @return the suit of the playing card (e.g., hearts, diamonds, etc.).
     */
    public Suit getSuit() {
        return suit;
    }

    public enum Suit {DIAMONDS, HEARTS, SPADES, CLUBS}

    /**
     * Returns a string representation of the playing card.
     * The string includes the face value and the suit of the card.
     *
     * The face value is represented as follows:
     * - "A" for Ace
     * - "2" to "10" for numeric values
     * - "J" for Jack
     * - "Q" for Queen
     * - "K" for King
     *
     * The suit is represented using Unicode symbols:
     * - "♦" for Diamonds
     * - "♥" for Hearts
     * - "♣" for Clubs
     * - "♠" for Spades
     *
     * @return A string representation of the playing card.
     */
    public String toString() {
        String value;
        String face = "";
        if (this.value == 1) {
            value = "A";
        } else if (this.value == 11) {
            value = "J";
        } else if (this.value == 12) {
            value = "Q";
        } else if (this.value == 13) {
            value = "K";
        } else {
            value = String.valueOf(this.value);
        }
        if (this.suit == Suit.DIAMONDS) {
            face = "♦";
        } else if (this.suit == Suit.HEARTS) {
            face = "♥";
        } else if (this.suit == Suit.CLUBS) {
            face = "♣";
        } else if (this.suit == Suit.SPADES) {
            face = "♠";
        }
        return String.format("%s%s", value, face);
    }

}