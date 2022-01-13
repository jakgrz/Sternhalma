import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ArrayList<ServerEcho> echoes = new ArrayList<>();
        Socket socket = null;
        ServerEcho echo = null;
        testowa test = new testowa();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter player count: ");
            int count = scanner.nextInt();
            ServerSocket server = new ServerSocket(5000);
            for(int i = 0; i < count; i++) {
                socket = server.accept();
                echo = new ServerEcho(socket, i, echoes, count, test);
                echoes.add(echo);
                echo.start();
            }
        } catch (Exception ex) {
            System.out.println("Error occurred...");
        }
    }
}
