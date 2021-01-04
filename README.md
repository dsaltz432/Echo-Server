# Echo Server

<hr>

## Project Summary

This project creates a basic echo server. The Client class sends a request to the Server class in order to establish a TCP connection using the port number specified as a command line argument. The server creates a ServerSocket connection, and is continuously waiting for new Socket connections from clients. Once the connection from the client to the server is established, the user is asked to specify a line of text. The text is sent to the server, converted to all upper case characters, and the sent back to the client through the Socket's output stream. The client the prints out the returned text to the console, and closes the Socket connection. The server's ServerSocket connection remains open, and continues to wait for requests. 

<hr>

## Running the Project Locally

1. Compile the two Java classes
	* `javac Server.java`<br>
	* `javac Client.java`<br>
2. Start the server to listen for connections
	* `java Server 3000`<br>
3. Start the client to create a connection with the server
	* `java Client 3000`<br>


Please Note: The port specified when starting the client and server must match in order to create a successful connection. 


## Running the Project Through Docker

1. Start the containers using `docker-compose up`
2. Inside another terminal session, go into the "client" container:
    * See available container: `docker ps`
    * Enter the client container: `docker exec -it <client-pod-name> /bin/bash`
3. Once inside a bash shell inside the client container, run the Client.java program as usual.
