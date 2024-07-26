package Projects.CardGameCLI;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        System.out.println("welcome to the table");
        Player user = new Player(1000);
        Dealer dealer = new Dealer();
        for (int i = 0; i < 3; i++) {
            int userBet = user.bet(20);
            BlackJack game = new BlackJack(
                new ArrayList<>(Arrays.asList(dealer.deal(), dealer.deal())),
                new ArrayList<>(Arrays.asList(dealer.deal(), dealer.deal())),
                userBet);
                System.out.println(game.playerhand.getScore());
                while (game.gameState != false) {
                    System.out.println("starting game " + i);  // Continue while the game is ongoing
                    // Player's turn
                    game.hit(dealer.deal(), game.playerhand);
                    System.out.println("Player hand score: " + game.playerhand.getScore());
                    
                    if (game.gameState == false) {
                        System.out.println("Player busted. House wins.");
                        break; // Exit the loop if the game state indicates a loss
                    }
                                
                    // End of player's turn
                    game.stay();
                
                    // Dealer's turn
                    while (dealer.willHit(game.dealerHand)) {
                        game.hit(dealer.deal(), game.dealerHand);
                    }
                
                    // Determine the winner
                    if (game.checkWinner() == game.playerhand) {
                        user.chips += userBet * 2;
                        System.out.println("Player wins");
                    } else {
                        System.out.println("House wins");
                    }
                
                    // Break or restart the game based on user input or other logic
                    break; // or you can use `continue` if you want to restart the game loop
                }
            
            
            }

        
    }
}
