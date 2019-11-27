import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class server {
    public static List<String> messages=new ArrayList<>();

    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);
        //int portNumber = 3000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("Wyjatek podczas tworzenia obiektu ServerSocket");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        while (true) {
            try {
                if (serverSocket!=null) {
                    Socket clientSocket = serverSocket.accept();

                    NewConnection newConnection = new NewConnection(clientSocket);
                    Thread t = new Thread(newConnection);
                    t.start();
                }
            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port "
                        + portNumber + " or listening for a connection");
                System.out.println(e.getMessage());
            }
        }
    }

}
