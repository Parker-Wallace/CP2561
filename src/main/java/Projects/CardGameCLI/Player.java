package Projects.CardGameCLI;

public class Player {
    public int chips;

    public Player(int chips) {
        this.chips = chips;
    }

    public int bet(int bet) {
        if (bet < this.chips) {
            this.chips =- bet;
            return bet;
            
        }
        else return 0;
    }
}
