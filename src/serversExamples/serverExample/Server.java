package serversExamples.serverExample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        int portNumber = 8080;
        try (ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("datetime")) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    String response = dateFormat.format(date);
                    printWriter.println(response);
                    printWriter.flush();
                } else {
                    printWriter.println("invalid");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
