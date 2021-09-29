import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(4000)){
            System.out.println("Server Started");

            while(true){
                try (Connector connector = new Connector(server)){
                    connector.writeLine("Hello!!!");
                    connector.close();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
