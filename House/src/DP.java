import java.io.*;
import java.util.*;

public class DP
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("house.dat"));
        int cases = input.nextInt();
        for (int i = 0; i <cases ; i++)
        {
            int rows= input.nextInt();
            int[] arr = new int[rows*(rows+1)/2];

            for (int j = 0; j < arr.length; j++)
            {
                arr[j]=input.nextInt();
            }
            DPHouse game = new DPHouse(arr,rows);
            System.out.println(game.maxValue());
        }

    }
}

class DPHouse
{
    int setup[];
    Integer mem[];
    int rows;

    public DPHouse(int setup[],int rows)
    {
        this.setup=setup;
        mem=new Integer[setup.length];
        Arrays.fill(mem,-1);
        this.rows=rows;
    }

    public int maxValue()
    {
        mem[0]=setup[0];
        mem[1]=mem[0]+setup[1];
        mem[2]=setup[2]+mem[0];
        int n=3;
        for (int i = 2; i <=rows; i++)
        {
            for (int j = 0; j <=i; j++)
            {
                if (j==0)
                {
                    mem[n]=setup[n]+mem[n-i];
                    n++;
                }
                else
                    if (j==i)
                    {
                        mem[n]=setup[n]+mem[n-i-1];
                        n++;
                    }
                    else
                    {
                        int temp = setup[n];
                        mem[n]=Math.max(temp+mem[n-i],temp+mem[n-i-1]);
                        n++;
                    }

            }
        }

        return Collections.max(Arrays.asList(mem));


    }
}