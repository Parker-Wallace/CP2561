package Projects.CardGameCLI;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * represents a 'shoe' of cards.
 * a shoe is typically 3 or more decks of cards shuffled to prevent card counting
 * 
 */
public class Shoe {
    private List<PlayingCard> cards;

    /**
     * Creates an instance of a Deck Shoe with a number of specified decks
     * 
     * @param numDecks the number of decks to shuffle into the deck.
     * Number of cards in the shoe will equal 52 * numDecks
     */
    public Shoe(int numDecks) {
        cards = new ArrayList<PlayingCard>();
        for (int i = 0; i < numDecks; i++) {
            for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
                for (int j = 1; j < 14; j++) {
                    PlayingCard card = new PlayingCard(j, suit);
            cards.add(card);
        }
        this.shuffle();
    }}}

    /**
     * Shuffles this Shoe of cards
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws the top card from this shoe and removes it from this shoe.
     * 
     * @return the playing card at the 'top' of this shoe
     */
    public PlayingCard drawCard() {
        return cards.remove(cards.size() - 1);
    }
}
