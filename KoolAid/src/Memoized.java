import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Memoized
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("koolaid.dat"));
        int cases = input.nextInt();
        for (int i = 0; i <cases ; i++)
        {
            int numbottles = input.nextInt();
            int []bottles = new int[numbottles];

            for (int j = 0; j < numbottles; j++)
            {
                bottles[j]=input.nextInt();
            }
            MemoBottles max = new MemoBottles(bottles);
            System.out.println(max.getMaxVolume(numbottles-1));
        }
    }
}

class MemoBottles
{
    static int []mem;
    int []bottles;
    public MemoBottles(int[] bottles)
    {
        this.bottles=bottles;
        mem= new int[bottles.length];
        Arrays.fill(mem,-1);
    }

    public int getMaxVolume(int index)
    {
        if(mem[index]==-1)
        {
            if (index==0)
                mem[0]= bottles[0];
            else
            if (index==1)
            {
                if(bottles[0]<bottles[1])
                    mem[1]=bottles[0]+bottles[1];
                else
                    mem[1]=Math.max(bottles[0],bottles[1]);
            }
            else
                {
                    if (bottles[index-1]<bottles[index])
                    {
                        mem[index]=Math.max(getMaxVolume(index-2)+bottles[index],getMaxVolume(index-1)+bottles[index]);
                    }
                    else
                        mem[index]=Math.max(getMaxVolume(index-1),getMaxVolume(index-2)+bottles[index]);
                }
        }
        return mem[index];
    }
}