import java.io.*;

public class Osoba
        {
            public String name;
            public String surname;
            public int year;
            Osoba(String name,String surname,int year){
                this.name=name;
                this.surname=surname;
                this.year=year;
            }

            public void saveToFile(DataOutput file)
            {
                String sum=this.name+this.surname+this.year;
                try
                {
                    file.writeChars(sum+"\n");
                }catch(IOException e)
                {
                    System.out.println("Blad wczytania tekstu");
                    System.exit(1);
                }
            }
        }