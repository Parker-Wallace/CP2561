package Projects.CardGameCLI.Server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Projects.CardGameCLI.BlackJack;
import Projects.CardGameCLI.Hand;
import Projects.CardGameCLI.PlayingCard;
import Projects.CardGameCLI.Server.Dealer.gamestates;
import Projects.CardGameCLI.Shoe;


public class Dealer implements Runnable {
    private Socket clientSocket;
    private Shoe shoe;
    private gamestates action;
    private BlackJack game;
   


    public Dealer(Socket socket) {
        this.clientSocket = socket;
        this.shoe = new Shoe(6);
        this.action = gamestates.START;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
         try (
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            ) {
                JSONObject outputObject = creategamePackage();
                JSONParser parser = new JSONParser();
                List<String> options = new ArrayList<String>();

                outputObject.put("message", "Place your bet");

                while (true) {
                    outputObject.put("options", CommandList(this.action, (List<String>) outputObject.get("options")));
                    out.writeUTF(outputObject.toJSONString());
                    String clientCommand = in.readUTF();
                    handleRequest(clientCommand, parser, outputObject);
    
                    }
        } catch (Exception e) {
        }
        
    }

    @SuppressWarnings("unchecked")
    private void handleRequest(String command, JSONParser parser, JSONObject outputObject) throws ParseException {
        JSONObject commandAsJsonObject = (JSONObject) parser.parse(command);
        // outputObject.clear();
        String request = (String) commandAsJsonObject.get("command");
        int userbet = ((Number) commandAsJsonObject.get("pot")).intValue();
        switch (request) {
            case "bet" -> {
                this.game = new BlackJack(new ArrayList<>(Arrays.asList(deal(), deal())), new ArrayList<>(Arrays.asList(deal(), deal())), userbet );
                outputObject.put("message", game.dealerHand.cards.get(0).toString() + '\n' + game.playerhand.toString());
                this.action = gamestates.INPLAY;
                // process the bet and deal cards
            }
            case "hit" -> {
                game.hit(deal(), game.playerhand);
                if (game.gameState == false) {
                    outputObject.put("message","that there is a bust");
                    this.action = gamestates.END;
                } else {
                    outputObject.put("message", game.dealerHand.cards.get(0).toString() + "\n" + game.playerhand.toString());
                }
                // deal an extra card and check gamestate
            }
            case "stay" -> {
                while (willHit(game.dealerHand)) {
                    game.hit(deal(), game.dealerHand);      
                }
                if (game.checkWinner() == game.playerhand) {
                    outputObject.put("message", game.dealerHand.toString() + '\n' + game.playerhand.toString() + '\n' + "player wins");
                    outputObject.put("pot", userbet * 2);
                } else {
                    outputObject.put("message", game.dealerHand.toString() + '\n' + game.playerhand.toString() + '\n' + "house wins");
                    outputObject.put("pot", 0);
                }
                this.action = gamestates.END;
                // swict gamestate to dealer and play, then check winner
            }
            default -> outputObject.put("message", "sorry i didnt quit understand " + "\"" + request + "\"" + '\n' + outputObject.get("message"));
        }
    }

    public enum gamestates {
        START,
        INPLAY,
        DEALER,
        END
    }

    public boolean willHit(Hand hand) {
        return hand.getScore() < 17;
    }

    public List<String> CommandList(gamestates currentState, List<String> optionsArray) {
        optionsArray.clear();
        if (currentState == gamestates.START || currentState == gamestates.END) {
            optionsArray.add("Bet");
        }
        else if (currentState == gamestates.INPLAY) {
            optionsArray.add("Hit");
            optionsArray.add("stay");
        }
        optionsArray.add("Exit");
        return optionsArray;
    }

    
    public PlayingCard deal() {
        return shoe.drawCard();
    }

    public JSONObject creategamePackage() {
        JSONObject gamepackageoJSONObject = new JSONObject();
        gamepackageoJSONObject.put("message", null);
        gamepackageoJSONObject.put("cards", null);
        gamepackageoJSONObject.put("status", null);
        gamepackageoJSONObject.put("pot", null);
        gamepackageoJSONObject.put("options", new ArrayList<String>());
        return gamepackageoJSONObject;
    }
}


// flow
// send hello
// give options
// recieve bet
// deal cards
// give options
// handle options
// skip if bust, play if stand
// issue c"winnings"
// play agaian