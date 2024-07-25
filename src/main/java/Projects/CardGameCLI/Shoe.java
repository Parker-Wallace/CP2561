package Projects.CardGameCLI;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
    private List<PlayingCard> cards;

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

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public PlayingCard drawCard() {
        return cards.remove(cards.size() - 1);
    }
}
