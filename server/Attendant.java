import java.net.Socket;
import java.util.HashMap;

public class Attendant extends Thread{
    
    private Communication communication;
    public Attendant(Socket client){
        communication = new Communication(client);
    }

    @Override
    public void run() {
        while(true){
            Translation request = (Translation) communication.recieve();

            String response = translate(request.getWord());

            if(response != null){
                communication.send(new Translation(response, Status.SUCCESS)); 
            } else {
             communication.send(new Translation(response, Status.NOT_FOUND));
            }
        }
    }

    private String translate(String word){
        HashMap<String, String> dictionaryIngPort = new HashMap<>();

        dictionaryIngPort.put("Red", "Vermelho");
        dictionaryIngPort.put("Blue", "Azul");
        dictionaryIngPort.put("Green", "Verde");
        dictionaryIngPort.put("White", "Branco");

        return dictionaryIngPort.get(word);
    }
}
