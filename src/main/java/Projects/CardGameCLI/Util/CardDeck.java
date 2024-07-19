package Projects.CardGameCLI.Util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * a class to represent a collection of playing cards
 * 
 * @author parker.wallace
 */
public class CardDeck {

    private ArrayList<PlayingCard> deckOfCards;

    /**
     * constructor for CardDeck. generates an array of 52 playing card objects in package order
     */
    public CardDeck() {
        this.deckOfCards = new ArrayList<>();
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (int i = 1; i < 14; i++) {
                PlayingCard card = new PlayingCard(i, suit);
                this.deckOfCards.add(card);
            };
        }
    }

    /**
     * gets the number of cards in this deckOfCards
     * @return the number of elements in this deckOfCards
     */
    public int length() {
        return this.deckOfCards.size();
    }

    /**
     * shuffles the order of Playing Card objects in this array of type CardDeck
     */
    public void Shuffle() {
        Collections.shuffle(this.deckOfCards);
    }

    /**
     * selects a random playing card from this CardDeck array.
     * @return a randomly selected playing card from the CardDeck array
     */
    public PlayingCard drawRandomCard() {
        int length = this.deckOfCards.size();
        int n = new Random().nextInt(length);
        PlayingCard card = this.deckOfCards.get(n);
        return this.deckOfCards.get(n);
    }

    /**
     * selects a specified card from this CardDeck array based on position.
     * @param index the int representing the position to pull a card from this CardDeck array
     * @return the card selected from this CardDeck array
     */
    public PlayingCard drawACard(int index){
        PlayingCard card = this.deckOfCards.get(index);
        discard(index);
        return card;
    }

    /**
     * removes a specified card from this CardDeck array based on position.
     * @param index the int representing the position of the card to remove from this CardDeck array
     */
    public void discard(int index) {
    this.deckOfCards.remove(index);
    }

    /**
     * adds a card to this CardDeck array
     * @param card the PlayingCard representing the card to be added to this CardDeck array
     */
    public void addCard(PlayingCard card) {
        this.deckOfCards.add(card);
    }

    /**
     * prints the deck of cards using the is order of appearance in this deck
     * @param stream the stream which to print the deck
     */
    public void printTheDeck(PrintStream stream) {
        for (PlayingCard card: this.deckOfCards
             ) {
            stream.println(card.toString());
        }
    }
}