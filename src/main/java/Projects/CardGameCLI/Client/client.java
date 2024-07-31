package Projects.CardGameCLI.Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException; 
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Projects.CardGameCLI.Client.Client.gamestates;


class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		int chips = 100;
		
		try (
			Socket socket = new Socket("localhost", 1234);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
			) {
				gamestates action = gamestates.START;
				clearConsole();
				GUI.GAMEWelcome();
				TimeUnit.SECONDS.sleep(1);
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = new JSONObject();
				while (true) {
					clearConsole();
					System.out.println(action);
					System.out.println("**********************\nChips Available: " + chips + "$\n************************");
					String inboundMessage = in.readUTF();
				readCommand(inboundMessage, parser);
				if (chips == 0) {
					System.out.println("looks like youre out of money...\n come back when you have more");
					System.exit(1);
				}
				System.out.println("**************************");
				readOptions(inboundMessage, parser);
				System.out.print("Enter command: ");
                String command = scanner.nextLine().trim();
                if ("exit".equalsIgnoreCase(command)) {
                    break;
                }
				if ("bet".equalsIgnoreCase(command)) {
					action = gamestates.INPLAY;
						while (true) { 
							System.out.println("how much would you like to bet?");
							int betAmount = -1;
							if (scanner.hasNextInt()) {
								betAmount = scanner.nextInt();
								scanner.nextLine(); // Consume the newline character left after nextInt()
							} else {
								System.out.println("Please enter a valid number.");
								scanner.next(); // Clear invalid input
							}
							
							if (betAmount < 0 || betAmount > chips) {
								System.out.println("You don't have enough chips to make that kind of bet.");
							} else {
								chips -= betAmount;
								jsonObject.put("pot", betAmount);
								break;
							}
					}
				}

                jsonObject.put("command", command);

                // Send the JSON object to the server
                out.writeUTF(jsonObject.toString());
				
                // Receive and print the response from the server
                
                //System.out.println(jsonResponse.get("message"));

			} 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}


	private static void readCommand(String inboundString, JSONParser parser) throws IOException, ParseException {
		JSONObject responseAsJSONObject = (JSONObject) parser.parse(inboundString);
		System.out.println(responseAsJSONObject.get("message"));
	}

	private static void readOptions(String inboundString, JSONParser parser) throws IOException, ParseException {
		JSONObject responseAsJSONObject = (JSONObject) parser.parse(inboundString);
		JSONArray optionsArray = (JSONArray) responseAsJSONObject.get("options");
        for (Object option : optionsArray) {
            System.out.println(option);
        }

        // Print the ArrayList to verify the contents
        
    }

	private static void getWinnings(String inboundString, JSONParser parser) throws IOException, ParseException {
		JSONObject responseAsJSONObject = (JSONObject) parser.parse(inboundString);
		JSONArray optionsArray = (JSONArray) responseAsJSONObject.get("options");
     
        }

    
    

	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public enum gamestates {
        START,
        INPLAY,
        DEALER,
        END
    }
}


// flow of play
//hello
//loop
//place bet
//get card
//hit, stand
// bust , dealer turn 
// determine winner