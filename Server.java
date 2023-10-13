import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

                    String clientMessage = (String) in.readObject();
                    String response = processClientMessage(clientMessage);

                    out.writeObject(response);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processClientMessage(String message) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }

        StringBuilder response = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            response.append(entry.getKey()).append(":").append(entry.getValue()).append(" , ");
        }

        if (response.length() > 0) {
            response.delete(response.length() - 2, response.length()); // Remove the trailing " , "
        }

        return response.toString();
    }
}