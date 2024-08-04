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
				GUI.GAMEWelcome();
				TimeUnit.SECONDS.sleep(1);
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = new JSONObject();
				while (true) {

					String inboundMessage = in.readUTF();
					JSONObject inboundObject = (JSONObject) parser.parse(inboundMessage);

					if (inboundObject.containsKey("winnings")) {
						chips += ((Number) inboundObject.get("winnings")).intValue();
					}
					
					GUI.clearConsole();
	
					System.out.println("**********************\nChips Available: " + chips + "$\n************************");
				readCommand(inboundMessage, parser);
		
				System.out.println("**************************");
				readOptions(inboundMessage, parser);
				System.out.print("Enter command: ");
                String command = scanner.nextLine().trim();
                if ("exit".equalsIgnoreCase(command)) {
                    break;
                }
				if ("bet".equalsIgnoreCase(command)) {		
					if (chips == 0) {
					System.out.println("looks like youre out of money...\n come back when you have more");
					System.exit(1);
				}
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

}


// flow of play
//hello
//loop
//place bet
//get card
//hit, stand
// bust , dealer turn 
// determine winner