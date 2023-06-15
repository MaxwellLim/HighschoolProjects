import java.io.*;
import java.util.*;

public class Memo
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
            MemoHouse game = new MemoHouse(arr,rows);
            System.out.println(game.maxValue(0,1));
        }

    }
}

class MemoHouse
{
    int setup[];
    int mem[];
    int rows;

    public MemoHouse(int setup[],int rows)
    {
        this.setup=setup;
        mem=new int[setup.length];
        Arrays.fill(mem,-1);
        this.rows=rows;
    }

    public int maxValue(int x,int row)
    {
        if (mem[x]==-1)
        {
            if(row==rows)
            {
                mem[x]= setup[x];
            }
            else
                mem[x]= setup[x]+Math.max(maxValue(x+row,row+1),maxValue(x+1+row,row+1));
        }
        return mem[x];


    }
}