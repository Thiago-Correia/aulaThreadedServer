import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final int PORT = 7820;
        final String serverName = "localhost";
        Socket socket = null;
        Communication communication = null;
        Translation request, response;
        Scanner sc;
        Boolean ouvindo = true;
        
        try {
            socket = new Socket(serverName, PORT);
            communication = new Communication(socket);
            sc = new Scanner(System.in);

            while(ouvindo){
                String word = sc.nextLine();

                if(!word.equalsIgnoreCase("exit")){
                    request = new Translation(word, Language.ING_PORT);
                    communication.send(request);
                    response = (Translation) communication.recieve();
 
                    if(response.getStatus() == Status.SUCCESS){
                        System.out.println("Mensagem traduzida: " + response.getWord());
                    }else{
                        System.out.println("Palavra não encontrada");
                    }

                }else{
                    ouvindo = false;
                }
            }


        } catch (Exception e) {
            System.out.println("Erro no cliente:");
            System.out.println(e.getMessage());
        }
    }
}
