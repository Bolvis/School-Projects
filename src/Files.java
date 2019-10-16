import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Files {

    public static void main(String[] args)
    {
        Scanner text = new Scanner(System.in);
        DataOutputStream userText=null;
        DataInputStream fileText=null;

        try {
            userText = new DataOutputStream(new FileOutputStream("plik.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            System.exit(1);
        }

        try
        {
            userText.writeChars(text.nextLine());
        }catch(IOException e)
        {
            System.out.println("Blad wczytania tekstu");
            System.exit(1);
        }

        try {
            if (userText != null)
                userText.close();
        } catch (IOException e) {
            System.out.println("Błąd zamykania strumienia");
            System.exit(1);
        }

        try {
        fileText = new DataInputStream(new FileInputStream("plik.txt"));
    } catch (FileNotFoundException e) {
        System.out.println("Nie znaleziono pliku");
            System.exit(1);
    }

        try {
            char c;

            while (fileText.available()>0) {

                c = fileText.readChar();
                System.out.println(c);
            }

        } catch (IOException e) {

        }

        try {
            if (fileText != null)
                fileText.close();
        } catch (IOException e) {
            System.out.println("Błąd zamykania strumienia");
            System.exit(1);
        }

    }


}
