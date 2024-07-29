package Projects.CardGameCLI.Client;
import java.io.*; 
import java.net.*; 
import java.util.*; 

import org.json.simple.JSONObject;


class Client { 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		try (
			Socket socket = new Socket("localhost", 1234);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
			) {
				System.out.println(in.readUTF());
				while (true) {
				System.out.print("Enter command (or 'exit' to quit): ");
                String command = scanner.nextLine();

                if ("exit".equalsIgnoreCase(command)) {
                    break;
                }
				JSONObject jsonObject = new JSONObject();
                jsonObject.put("message", command);

                // Send the JSON object to the server
                out.writeUTF(jsonObject.toString());

                // Receive and print the response from the server
                String response = in.readUTF();
                System.out.println(response);
		
			} 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
}
