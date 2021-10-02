import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try (Connector connector = new Connector("127.0.0.1",4000)){
            System.out.println("Connected to server");

            String command = connector.readLine();

            if(command.equals("Close")){
                System.out.println("Client is closing...");
                connector.close();
                System.exit(0);
            }
            else if(command.equals("Chrome")){
                Process p = Runtime.getRuntime().exec("<program path>");
            }
            else {
                System.out.println("Invalid command");
            }

            connector.close();
            System.out.println("Connection was closed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
