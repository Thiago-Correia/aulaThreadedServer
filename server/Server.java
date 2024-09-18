import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        final int PORT = 7820;
        Socket client = null;

        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Aguardando cliente");
                client = serverSocket.accept();

                Attendant attendant = new Attendant(client);
                attendant.start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
