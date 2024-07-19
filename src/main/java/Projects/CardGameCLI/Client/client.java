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
				String line = sc.nextLine();
				
				while (!"exit".equals((line = sc.nextLine() ))
				) {
									// sending the user input to server
									System.out.println(line); 
					out.println(line);
					out.flush();
					String serverMessage;
					while (!(serverMessage = in.readLine()).equals("waiting")) {
						System.out.println(serverMessage);
					}
			} 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
}
