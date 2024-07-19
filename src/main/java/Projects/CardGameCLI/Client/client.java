package Projects.CardGameCLI.Client;
import java.io.*; 
import java.net.*; 
import java.util.*; 


class Client { 
	public static void main(String[] args) 
	{
		try (Socket socket = new Socket("localhost", 1234);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			Scanner sc = new Scanner(System.in); 
			) { 
				String line;
				
				while (!"exit".equals((line = sc.nextLine() ))
				) {
					String serverMessage;
					while ((serverMessage = in.readLine()) != null) {
						System.out.println(serverMessage);
					}
					// reading from user
					line = sc.nextLine(); 

					// sending the user input to server 
					out.println(line); 
			} 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
}
