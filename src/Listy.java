import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Listy {

    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String name;
        String surname;
        String age;
        int chose=0;

        while(true)
        {
            for(int index=0;index<list.size();index++) {
                System.out.println((index+1)+list.get(index).toString()+"\n");
            }
            System.out.println("1.Add person\n2.Remove person\n" +
                    "3.Sort list\n4.Exit\n");
            try{chose=Integer.valueOf(scanner.next());}
            catch(Exception ex){System.exit(1);}

            switch(chose)
            {
                case 1:
                    System.out.print("name:");
                    name=scanner.next();
                    System.out.print("surname:");
                    surname=scanner.next();
                    System.out.print("age:");
                    age=scanner.next();
                    list.add(new Person(name,surname,age));
                    break;

                case 2:
                    int index;
                    System.out.print("index:");
                    index=Integer.valueOf(scanner.next());
                    try{list.remove(index-1);}catch(Exception ex){System.out.println("There's not such index");}
                    break;
                    case 3:
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.print("Choose wisely");
                    System.exit(1);
                    break;

            }

        }
    }


}
