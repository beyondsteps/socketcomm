import java.net.Socket;
import java.net.ServerSocket;

public class Server{

    public static void main(String[] args) {
        try {
            //Create Server
            ServerSocket serverSocket = new ServerSocket(9000);
            //client accept
            Socket socket = serverSocket.accept();

            
        }
        catch (Exception e) {
        e.printStackTrace();
        }
}