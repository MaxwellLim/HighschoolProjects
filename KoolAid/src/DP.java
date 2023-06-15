import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DP
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
            DPKoolAid max = new DPKoolAid(bottles);
            System.out.println(max.getMaxVolume());
        }
    }
}

class DPKoolAid
{
    static int []mcv;
    int []bottles;
    public DPKoolAid(int[] bottles)
    {
        this.bottles=bottles;
        mcv= new int[bottles.length];
    }

    public int getMaxVolume()
    {
        mcv[0]=bottles[0];
        if(bottles[0]<bottles[1])
        {
            mcv[1]=bottles[0]+bottles[1];
        } else
            mcv[1]=Math.max(bottles[0],bottles[1]);
        for (int i = 2; i <bottles.length; i++)
        {
            if (bottles[i-1]<bottles[i])
            {
                mcv[i]=Math.max(mcv[i-2]+bottles[i],mcv[i-1]+bottles[i]);
            }
            else
                mcv[i]=Math.max(mcv[i-1],mcv[i-2]+bottles[i]);

        }
        return mcv[mcv.length-1];
    }
}