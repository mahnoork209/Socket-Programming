import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)) // Read user input
        ) {
            System.out.print("Enter a string: ");
            String clientMessage = userInput.readLine();

            // Send a message to the server
            out.writeObject(clientMessage);

            // Receive and display the server's response
            String serverResponse = (String) in.readObject();
            System.out.println("Server: " + serverResponse);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
