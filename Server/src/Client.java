import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try (Connector connector = new Connector("127.0.0.1",4000)){
            System.out.println("Connected to server");

            System.out.println("Response: " + connector.readLine());
            connector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
