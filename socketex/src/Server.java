import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;


public class Server {
    private static final int PORT = 21119;
    public static void main(String[] args) throws Exception {
        System.out.println("Server is starting ...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            
                Socket clienSocket = serverSocket.accept();
                System.out.println("Client arrived at " + PORT + ": " + clienSocket.getInetAddress());
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clienSocket.getOutputStream(),true);

                BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

                String clientMessage = reader.readLine();
                System.out.println("Client Message : " + clientMessage);

                System.out.println("Input message : ");
                String serverMessage = serverInput.readLine();
                System.out.println("Server Message : " + serverMessage);

                writer.println(clientMessage);

                clienSocket.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
