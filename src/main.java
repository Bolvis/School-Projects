import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args)
    {
        DataOutput file=null;
        List<Osoba> list=new ArrayList();
        try {
            file = new DataOutputStream(new FileOutputStream("plik.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            System.exit(1);
        }
        for(int i=0;i<10;i++)
        {
            list.add(new Osoba("Imie"+i,"Nazwisko"+i,1995+i));
            list.get(i).saveToFile(file);
        }

    }


}
