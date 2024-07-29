package Projects.CardGameCLI.Server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.simple.*;

import Projects.CardGameCLI.Hand;
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
                outputObject.put("message", "Welcome to blackjack...\nPlace ypu bets...");
                out.writeUTF(outputObject.toJSONString());
                while (true) {
                    String userInputJsonString = in.readUTF();
                    JSONObject inpuObject = new JSONObject();
                    out.writeUTF(userInputJsonString);
                }
        } catch (IOException e) {
        }
        
    }

    private void handleRequest(String request, PrintWriter out) {
        switch (request) {
            case "DRAW_CARD":
                break;
            default:
                out.println("sorry i didnt quit understand " + request);
        }
        out.println("waiting");
    }

    private void giveChips() {

    }

    public boolean willHit(Hand hand) {
        return hand.getScore() < 17;
    }
}
