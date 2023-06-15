import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Railroad
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("railroad.txt"));
        MyStack inbound = new MyStack();
        MyStack station = new MyStack();
        MyStack outbound = new MyStack();
        double[] outgoing;


        do
        {
            boolean possible = true;
            int numTrains = file.nextInt();


            if (numTrains == 0)
            {
                System.out.println(" ");
                continue;
            }

            outgoing = new double[numTrains];


            train:
            while (true)
            {
                for (int x = numTrains; x > 0; x--)
                    inbound.push(x);

                for (int x = 0; x < numTrains; x++)
                {
                    outgoing[x] = file.nextDouble();
                    if (outgoing[x] == 0)
                    {
                        System.out.println(" ");
                        break train;
                    }
                }


                int x = 0;
                while (x<numTrains)
                {
                    double out = outgoing[x];


                    if (out == inbound.peek())
                    {
                        outbound.push(inbound.pop());
                    } else
                        if (out == station.peek())
                    {
                        outbound.push(station.pop());
                    } else
                        {
                        station.push(inbound.pop());

                        while (true)
                        {
                            if (inbound.isEmpty())
                                break;

                            if (out == inbound.peek())
                            {
                                outbound.push(inbound.pop());
                                break;
                            }
                            station.push(inbound.pop());
                        }
                    }
                    x++;
                }

                for (int y = numTrains - 1; y >= 0; y--)
                {
                    if (outgoing[y] != outbound.pop())
                    {
                        possible = false;
                        break;
                    }

                }

                if (possible)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
        while (file.hasNext());
    }
}
