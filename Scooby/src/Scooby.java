import java.io.*;
import java.util.*;

public class Scooby
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new File("scooby.dat"));

        int rep = reader.nextInt();

        for (int i = 0; i <rep ; i++)
        {
            String in =reader.next()+ reader.nextLine();
            String[] paths =in.split(" ");
            Hashtable<String,Node> holder = new Hashtable<>();
            HashSet<String> letters= new HashSet<>();
            for (String e:paths)
            {
                String onelett=e.substring(0,1);
                String twolett=e.substring(1);
                letters.add(twolett);
                letters.add(onelett);
            }
            for (String e:letters)
            {
                holder.put(e,new Node(e));
            }
            for (String e:paths)
            {
                String onelett=e.substring(0,1);
                String twolett=e.substring(1);
                (holder.get(onelett)).connected.add(holder.get(twolett));
                (holder.get(twolett)).connected.add(holder.get(onelett));
            }

            String dest=reader.next();
            String[] destarr = dest.split("");
            if(!holder.containsKey(destarr[0])||!holder.containsKey(destarr[1]))
            {
                System.out.println("no");
                break;
            }

            Pathfinder temp=new Pathfinder();
            boolean possible=temp.findPath(destarr[1],holder.get(destarr[0]));
            if(possible)
            System.out.println("yes");
            else
                System.out.println("no");

        }
    }
}
class Node
{
    String letter;
    HashSet<Node> connected;

    public Node(String letter)
    {
        this.letter=letter;
        connected=new HashSet<>();
    }



}

class Pathfinder
{
    HashSet<Node> visited;

    public Pathfinder()
    {
        visited =new HashSet<>();
    }

    public boolean findPath(String end,Node begin)
    {
        boolean isPath=false;

        if(begin.letter.equals(end))
            return true;
        if(visited.contains(begin))
            return false;
        visited.add(begin);
        for (Node e:begin.connected)
        {
            isPath=findPath(end,e);
            if(isPath)
                break;
        }
        return isPath;
    }

    public void clear()
    {
        visited.clear();
    }
}
