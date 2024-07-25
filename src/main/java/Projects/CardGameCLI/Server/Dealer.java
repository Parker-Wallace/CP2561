package Projects.CardGameCLI.Server;


import java.io.*;
import java.net.Socket;

public class Dealer implements Runnable {
    private Socket clientSocket;

    private int playerChips;

    public Dealer(Socket socket) {
        this.clientSocket = socket;

        this.playerChips = 100;
    }

    @Override
    public void run() {
        
    }

    
}
