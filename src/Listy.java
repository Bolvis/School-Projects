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
            /*for(int index=0;index<list.size();index++) {
                System.out.println((index+1)+list.get(index).toString()+"\n");
            }*/
            System.out.println("1.Add person\n2.Remove person\n" +
                    "3.Sort list\n4.Exit\n");
            try{chose=Integer.valueOf(scanner.next());}
            catch(Exception ex){System.exit(1);}

            switch(chose)
            {
                case 1:
                    System.out.print("getName():");
                    name=scanner.next();
                    System.out.print("getSurname():");
                    surname=scanner.next();
                    System.out.print("getAge():");
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

                        System.out.println("\nSortuję po nazwisku");
                        list.sort(
                                new Comparator<Person>() {
                                    @Override
                                    public int compare(Person m1, Person m2) {

                                        String s1 = m1.getSurname();
                                        String s2 = m2.getSurname();
                                        return s1.compareTo(s2);
                                    }
                                }
                        );

                        list.forEach(System.out::println);

                        System.out.println("\nSortuję po imieniu");
                        list.sort(
                                new Comparator<Person>() {
                                    @Override
                                    public int compare(Person m1, Person m2) {

                                        String s1 = m1.getName();
                                        String s2 = m2.getName();
                                        return s1.compareTo(s2);
                                    }
                                }
                        );

                        list.forEach(System.out::println);

                        System.out.println("\nSortuję po wieku");
                        list.sort((Person m1, Person m2) -> {
                            //Jeśli są równe zwracamy 0;
                            if (m1.getAge().equals(m2.getAge()))
                                return 0;
                            //Jeśli obiekt m1 (czyli pierwszy z porównywanych)
                            //jest większy zwracamy 1
                            //w przeciwnym razie zwracamy -1
                            if (Integer.valueOf(m1.getAge())>Integer.valueOf(m2.getAge()))
                                return 1;
                            else
                                return -1;
                        });

                        list.forEach(System.out::println);

                        System.out.println("\nSortuję po wszystkim");
                        list.sort(
                                new Comparator<Person>() {
                                    @Override
                                    public int compare(Person m1, Person m2) {

                                        String s1 = m1.getSurname();
                                        String s2 = m2.getSurname();
                                        if(s1.equals(s2))
                                        {
                                            s1 = m1.getName();
                                            s2 = m2.getName();
                                        }
                                        if(s1.equals(s2))
                                        {
                                            s1 = m1.getAge();
                                            s2= m2.getAge();
                                        }
                                        return s1.compareTo(s2);
                                    }
                                }
                        );

                        list.forEach(System.out::println);
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
