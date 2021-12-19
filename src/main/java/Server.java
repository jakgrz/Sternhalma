import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<ServerEcho> echoes = new ArrayList<>();
        Socket socket = null;
        ServerEcho echo = null;
        try {
            ServerSocket server = new ServerSocket(5000);
            for(int i = 0; true; i++) {
                socket = server.accept();
                echo = new ServerEcho(socket, i, echoes);
                echoes.add(echo);
                echo.start();
            }
        } catch (Exception ex) {
            System.out.println("Error occurred...");
        }
    }
}
