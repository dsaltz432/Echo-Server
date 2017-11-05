/*
Daniel Saltz
1/18/17

This is the Client class of a basic TCP echo server. This program creates TCP connection by using java's 
Socket class. A TCP connection is established to "localhost" using the port number given as a command line
argument (the server will also be run on this machine, though you could change "localhost" to any hostname).
The port number must be the same for both the Client and Server to make a successful socket connection.
Once the connection is established, the user is asked to enter a line of text. The text is sent to the server,
where it is capitalized and returned back to the client. The client prints out the returned text, and closes
it's TCP connection to the server. You can run the Client class again while the server is still running, since
the server is still listening for new connections.

*/


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
	
		// receive port number as argument
		if (args.length != 1){
			System.out.println("Run this program by typing 'java Client <port>'");
			System.exit(0);
		}

		try {
			int port = Integer.parseInt(args[0]);

			// read input from user
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter line of text: ");
			String text = scanner.nextLine();
			scanner.close();
			
			// send input to server
			Socket socket = new Socket("localhost",port);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeBytes(text+"\r\n");
			
			// get response from server
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = in.readLine();
			System.out.println("Response from server: " + response);
			
			// close resources
			socket.close();
			in.close();
			out.close();
		} 
		catch (NumberFormatException e){
			System.out.println("You did not enter a valid port number");
		}
	}
}
