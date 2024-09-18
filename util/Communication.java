import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Communication {
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Communication(Socket socket){
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("Erro ao criar a comunicação");
            System.out.println(e.getMessage());
        }
    }

    public void send(Object object){
        try {
            output.writeObject(object);
        } catch (Exception e) {
            System.out.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }

    public Object recieve(){
        try {
            return input.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao receber mensagem: " + e.getMessage());
            return null;
        }
    }
}

