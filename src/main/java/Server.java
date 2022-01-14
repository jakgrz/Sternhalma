import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The server part of the game.
 * Has to be launched first.
 * Upon starting it'll ask for player count.
 * Each client connection is delegated to it's own server thread.
 * Automatically closes itself on game completion.
 */
public class Server {
    public static void main(String[] args) {
        ArrayList<ServerEcho> echoes = new ArrayList<>();
        Socket socket = null;
        ServerEcho echo = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter player count: ");
            int count = scanner.nextInt();
            ServerSocket server = new ServerSocket(5000);
            for(int i = 0; i < count; i++) {
                socket = server.accept();
                echo = new ServerEcho(socket, i, echoes, count);
                echoes.add(echo);
                echo.start();
            }
        } catch (Exception ex) {
            System.out.println("Error occurred...");
        }
    }
}
