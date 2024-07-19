package Projects.CardGameCLI.Server;

import Projects.CardGameCLI.Game.BlackjackGame;
import java.io.*;
import java.net.Socket;

public class Dealer implements Runnable {
    private Socket clientSocket;
    private BlackjackGame game;
    private int playerChips;

    public Dealer(Socket socket) {
        this.clientSocket = socket;
        this.game = new BlackjackGame();
        this.playerChips = 100;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            
            out.println("Dealer says: Welcome to the table...");
            out.println("Dealer says: Here are some chips...");
            out.println("*you've been given 100 chips!");
            out.println("waiting");
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
                out.println(game.drawCard());
                break;
            // Add more cases for different requests
            default:
                out.println("sorry i didnt quit understand " + request);
        }
        out.println("waiting");
    }

    private void giveChips() {

    }
}
