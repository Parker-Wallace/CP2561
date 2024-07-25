package Projects.CardGameCLI;

public class Dealer {
    private Shoe shoe;

    public Dealer() {
        this.shoe = new Shoe(6);
    }

    public PlayingCard deal() {
        return shoe.drawCard();
    }

    public boolean willHit(Hand hand) {
        if (hand.getScore() < 17) {
            return true;
        }
        else return false;
    }
}
