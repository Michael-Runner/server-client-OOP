import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(4000)){
            System.out.println("Server Started");

            int counter = 0;
            Scanner reader = new Scanner(System.in);

            while(true){
                try (Connector connector = new Connector(server)){
                    System.out.println("Client ID: " + counter);

                    counter++;

                    System.out.println("Menu: ");
                    System.out.println("[1] Close");
                    System.out.println("[2] Open Chrome");

                    int command = reader.nextInt();

                    if (command == 1){
                        connector.writeLine("Close");
                    }
                    else if(command == 2){
                        connector.writeLine("Chrome");
                    }
                    else {
                        System.out.println("Error!");
                    }

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
