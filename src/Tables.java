import java.util.Random;

public class Tables {

    protected static int[][] arrayOfInts;
    protected static int sizeX,sizeY;
    protected static long[] arrayOfSums;

    public static void main(String[] args) {

        try{
        sizeX=Integer.valueOf(args[0]);
        sizeY=Integer.valueOf(args[1]);
        }
        catch(Exception ex){System.out.println("It doesn't work"); System.exit(1);}
        arrayOfInts= new int[sizeX][sizeY];
        arrayOfSums = new long [sizeX];
        for(int x=0;x<arrayOfInts.length;x++)
        {
            for(int y=0;y<arrayOfInts[x].length;y++)
            {
                Random r = new Random();
                arrayOfInts[x][y]=r.nextInt();
                arrayOfSums[x]+=arrayOfInts[x][y];
                System.out.print(arrayOfInts[x][y]+",");
            }
            System.out.print("\n");
            System.out.print("Sum is:"+arrayOfSums[x]+"\n");
        }
    }
}
