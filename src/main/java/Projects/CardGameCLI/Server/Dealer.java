package Projects.CardGameCLI.Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Projects.CardGameCLI.Hand;
import Projects.CardGameCLI.Shoe;


public class Dealer implements Runnable {
    private Socket clientSocket;
    private Shoe shoe;


    public Dealer(Socket socket) {
        this.clientSocket = socket;
        this.shoe = new Shoe(6);
    }

    @Override
    public void run() {
         try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                System.out.println("Connected");
            String request = in.readLine();
            while (request != null) {
                handleRequest(request, out);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
