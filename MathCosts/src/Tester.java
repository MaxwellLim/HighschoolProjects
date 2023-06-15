import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;

public class Tester
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("mathCosts.dat"));
        while(true)
        {
            PriorityQueue<Integer> cost= new PriorityQueue<Integer>();
            int rep = input.nextInt();
            if(rep==0)
                break;

            for (int i = 0; i < rep; i++)
            {
                cost.add(input.nextInt());
            }
            int totalcost=0;
            for (int i = 0; i <rep-1 ; i++)
            {
                int add=cost.poll()+cost.poll();
                totalcost+=add;
                cost.add(add);
            }
            System.out.println(totalcost);
        }


    }
}
