package Projects.CardGameCLI;

import java.util.ArrayList;


public class BlackJack {
    public Boolean gameState;
    public Hand dealerHand;
    public Hand playerhand;
    public Integer bet;

    public BlackJack(ArrayList<PlayingCard> playerCards , ArrayList<PlayingCard> dealerCards, Integer bet) {
        this.gameState = true;
        this.dealerHand = new Hand(dealerCards);
        this.playerhand = new Hand(playerCards);
        this.bet = bet;
    }

    public void hit(PlayingCard card, Hand hand) {
        hand.addCard(card);
        if (hand.getScore() > 21) {
            gameState = false;
        }
    }

    public Hand checkWinner() {
        if (this.playerhand.getScore() > this.dealerHand.getScore() && this.playerhand.getScore() < 22) {
            return this.playerhand;
        }
        else return this.dealerHand;
    }

    public void stay(){
    }
    public void doubleDown(){}
}
