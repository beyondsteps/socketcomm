import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            System.out.println("Server IP : ");
            String serverIP = reader.readLine();

            System.out.println("Port Number : ");
            int serverPort = Integer.parseInt(reader.readLine());

            System.out.println("Client initializing..."); //
            
            try (Socket socket = new Socket(serverIP, serverPort)){
                
                System.out.println("Connected to server " + serverIP + ":" + serverPort);

                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                
                System.out.println("Enter your message:");
                String message =reader.readLine();
                out.println(message);

                String response = reader.readLine();
                System.out.println("Server Message : " + response);




            }
            catch(SocketException e)
            {e.printStackTrace();}
        }

        catch (Exception e) {
            System.out.println("Can not connect to the server " + e.getMessage());
            e.printStackTrace();



        }
    }
}
