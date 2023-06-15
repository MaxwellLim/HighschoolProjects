import java.util.*;
import java.io.*;

public class Memo
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
            MemoTruck cost = new MemoTruck(stuff);
            System.out.println(cost.getmc(cap,num));
            for (int j = 0; j <=num ; j++)
            {
                for (int k = 0; k <=cap ; k++)
                {
                    System.out.print(cost.mc[k][j]+"\t");

                }
                System.out.println();

            }
        }
    }
}

class MemoTruck
{
    Item[] items;
    int [][]mc;

    public MemoTruck(String[] temp)
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
        if(weight<=0||item<=0)
        {
            return 0;
        }
        if(mc[weight][item]==-1)
        {
            Item temp = items[item-1];
            if(weight-temp.weight<0)
            {
                mc[weight][item]=getmc(weight,item-1);
            }
            else
                mc[weight][item]=Math.max(((temp.cost)+getmc(weight-temp.weight,item)),(getmc(weight,item-1)));
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