/*
Daniel Saltz
1/18/17

This is the Server class of a basic TCP echo server. This class opens a ServerSocket running on the 
port number given as a command line argument. The port number must be the same for both the Client 
and Server to make a successful socket connection. The server waits continuously for new Socket connections
with new clients. After creating a connection, this program accepts a line of text,
capitalizes it, and sends it back to the client through the Socket's output stream. This program then
closes its connection to the client, but keeps its ServerSocket open for new connections.

*/

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// receives a port number as argument
		if (args.length != 1){
			System.out.println("Run this program by typing 'java Server <port>'");
			System.exit(0);
		}

		ServerSocket serverSocket = null;
		try {
			int port = Integer.parseInt(args[0]);
			System.out.println("Server running on port " + port + "...");

			serverSocket = new ServerSocket(port);
			while (true) { // listen for client connections
				
				// accept connection
				Socket connectionSocket = serverSocket.accept();
				
				// get input text
				BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				String text = in.readLine();
							
				// send echo as output
				DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
				out.writeBytes(text.toUpperCase()+"\r\n");
				
				// close resources
				in.close();
				out.close();
				connectionSocket.close();
				
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("You did not enter a valid port number");
		} finally {
			if (serverSocket != null){
				try {  
		    		serverSocket.close();
			    } catch(Exception e) {
			    	e.printStackTrace();
			    }
			}
		}
		
	}
}
