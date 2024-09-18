import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final int PORT = 7820;
        final String serverName = "localhost";
        Socket socket = null;
        Communication communication = null;
        Translation request, response;

        try {
            socket = new Socket(serverName, PORT);
            communication = new Communication(socket);

            request = new Translation("Red", Language.ING_PORT);
            communication.send(request);

            response = (Translation) communication.recieve();
            
            if(response.getStatus() == Status.SUCCESS){
                System.out.println("Mensagem traduzida: " + response.getWord());
            }else{
                System.out.println("Palavra não encontrada");
            }

        } catch (Exception e) {
            System.out.println("Erro no cliente:");
            System.out.println(e.getMessage());
        }
    }
}
