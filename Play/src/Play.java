import java.util.*;
import java.io.*;
public class Play
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new File("play.dat"));
        int cases = reader.nextInt();
        for (int i = 0; i <cases ; i++)
        {
            HashMap<String,Node> domino = new HashMap();
            int dominos = reader.nextInt();
            int paths = reader.nextInt();
            int knocked = reader.nextInt();
            for (int j = 1; j <=dominos ; j++)
            {
                domino.put(j+"",new Node(j));
            }
            for (int j = 0; j <paths ; j++)
            {
                String connected = reader.next()+reader.nextLine();
                String[] temp = connected.split(" ");
                domino.get(temp[0]).connected.add(domino.get(temp[1]));
            }
            int totKnocked=0;
            Knocker temp = new Knocker();
            for (int j = 0; j < knocked ; j++)
            {
                String start = reader.next();
                totKnocked+=temp.knock(domino.get(start));
            }
            System.out.println(totKnocked);
        }
    }
}
class Node
{
    int number;
    HashSet<Node> connected;

    public Node(int number)
    {
        this.number =number;
        connected=new HashSet<>();
    }
}
class Knocker
{
    static HashSet<Node> knocked;

    public Knocker()
    {
        knocked=new HashSet<>();
    }

    public int knock(Node start)
    {
        int total=0;
        if(knocked.contains(start))
            return 0;
        knocked.add(start);
        for (Node e:start.connected)
        {
            total+=knock(e);
        }
        return 1+total;
    }
}