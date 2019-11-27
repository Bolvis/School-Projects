import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;
import java.util.logging.*;


public class NewConnection implements Runnable {

    private final Socket clientSocket;
    private Boolean runThread = true;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private static final Logger LOGGER = Logger.getLogger(NewConnection.class.getName());

    NewConnection(Socket client) {
        this.clientSocket = client;
        LOGGER.log(Level.FINE, "Połączenie nawiązane");
    }

    @Override
    public void run() {

        String line;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Wyjątek podczas tworzenia in/out");
            System.exit(-1);
        }
        System.out.println("clienctSocket="+clientSocket.toString());

        while (runThread) {
            try {
                line = in.readLine();
                server.messages.add(line);
                if (line != null) {
                    System.out.println("Odczytano:" + line);
                    for(String message:server.messages){
                    out.println(message);
                    }
                    server.messages.clear();
                } else {
                    this.runThread = false;
                }
            } catch (IOException e) {
                System.out.println("Wyjatek");
                this.runThread = false;
            }

        }
        System.out.println("Koniec Watku");
        try {
            System.out.println("Zamykam połączenie");
            this.clientSocket.close();
        } catch (IOException ee) {

        }

    }

}
