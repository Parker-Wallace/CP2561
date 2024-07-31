package Projects.CardGameCLI;

import java.util.ArrayList;


public class Hand {
    public ArrayList<PlayingCard> cards;

    public Hand(ArrayList<PlayingCard> cards) {
        this.cards = cards;

    }

    public void addCard(PlayingCard card){
        this.cards.add(card);
    }

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


