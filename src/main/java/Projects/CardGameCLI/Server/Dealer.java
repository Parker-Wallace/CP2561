package Projects.CardGameCLI.Server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Projects.CardGameCLI.Hand;
import Projects.CardGameCLI.Server.Dealer.gamestates;
import Projects.CardGameCLI.Shoe;


public class Dealer implements Runnable {
    private Socket clientSocket;
    private Shoe shoe;


    public Dealer(Socket socket) {
        this.clientSocket = socket;
        this.shoe = new Shoe(6);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
         try (
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            ) {
                JSONObject outputObject = new JSONObject();
                JSONParser parser = new JSONParser();
                List<String> options = new ArrayList<String>();
                gamestates currentState = gamestates.START;

                outputObject.put("message", "Place your bet");

                while (true) {
                    outputObject.put("options", CommandList(currentState, options));
                    out.writeUTF(outputObject.toJSONString());
                    String clientCommand = in.readUTF();
                    handleRequest(clientCommand, parser, outputObject);
                    }
        } catch (Exception e) {
        }
        
    }

    private JSONObject handleRequest(String command, JSONParser parser, JSONObject outputObject) throws ParseException {
        JSONObject commandAsJsonObject = (JSONObject) parser.parse(command);
        outputObject.clear();
        String request = (String) commandAsJsonObject.get("command");
        switch (request) {
            case "bet":
            outputObject.put("message", "you made a bet!");
            // process the bet and deal cards
                break;
            case "hit":
                // deal an extra card and check gamestate
                break;
            case "stay":
                // swict gamestate to dealer and play, then check winner
                break;
            default:
                outputObject.put("message", "sorry i didnt quit understand " + "\"" + request + "\"");
        }
        return outputObject;
    }

    enum gamestates {
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
        if (currentState == gamestates.START) {
            optionsArray.add("Bet");
        }
        else if (currentState == gamestates.INPLAY) {
            optionsArray.add("Hit");
            optionsArray.add("Stand");
        }
        optionsArray.add("Exit");
        return optionsArray;
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