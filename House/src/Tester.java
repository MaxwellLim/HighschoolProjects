import java.io.*;
import java.util.*;

public class Tester
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
            House game = new House(arr,rows);
            System.out.println(game.maxValue(0,1));
        }

    }
}

class House
{
    int setup[];
    int rows;

    public House(int setup[],int rows)
    {
        this.setup=setup;
        this.rows=rows;
    }

    public int maxValue(int x,int row)
    {
        if(row==rows)
        {
            return setup[x];
        }
        else
            return setup[x]+Math.max(maxValue(x+row,row+1),maxValue(x+1+row,row+1));


    }
}