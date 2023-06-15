import java.util.*;
import java.io.*;

public class DP
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("truck.dat"));

        int cases =input.nextInt();
        input.nextLine();

        for (int i = 0; i <cases ; i++)
        {
            String line = input.nextLine();
            String[] stuff = line.split(" ");

            int cap = Integer.parseInt(stuff[0]);
            int num = Integer.parseInt(stuff[1]);
            DPTruck cost = new DPTruck(stuff);
            System.out.println(cost.getmc(cap,num));

        }
    }
}

class DPTruck
{
    Item[] items;
    int [][]mc;

    public DPTruck(String[] temp)
    {
        mc = new int[Integer.parseInt(temp[0])+1][Integer.parseInt(temp[1])+1];
        int x=0;
        items=new Item[Integer.parseInt(temp[1])];

        for (int i = 2; i <temp.length-1 ; i+=2)
        {
            items[x++]=new Item(Integer.parseInt(temp[i]),Integer.parseInt(temp[i+1]));
        }
        for (int i = 0; i <mc.length ; i++)
        {
            Arrays.fill(mc[i],-1);
        }
        Arrays.fill(mc[0],0);
        for (int i = 0; i <mc.length ; i++)
        {
            mc[i][0]=0;
        }
    }

    public int getmc(int weight, int item)
    {
        Item temp;

        for (int i = 1; i <= item; i++)
        {
            temp=items[i-1];
            for (int j = 0; j <=weight; j++)
            {
                if (j-temp.weight<0)
                {
                    mc[j][i]=mc[j][i-1];
                }
                else
                {
                    mc[j][i]=Math.max(temp.cost+mc[j-temp.weight][i],mc[j][i-1]);
                }

            }

        }
        return mc[weight][item];
    }

    class Item
    {
        int weight;
        int cost;

        public Item(int weight, int cost)
        {
            this.weight=weight;
            this.cost=cost;
        }

    }
}