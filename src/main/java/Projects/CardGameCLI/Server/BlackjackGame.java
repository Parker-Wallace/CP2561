package Projects.CardGameCLI.Game;

import Projects.CardGameCLI.Util.Shoe;

public class BlackjackGame {
    private Shoe shoe;

    public BlackjackGame() {
        this.shoe = new Shoe(6); // 6 decks
    }

    public String drawCard() {
        return shoe.drawCard().toString();
    }

    

    // Add more game logic methods here
}
