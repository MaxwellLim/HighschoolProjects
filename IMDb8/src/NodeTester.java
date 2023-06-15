/**
 * Created by 131225 on 9/20/2018.
 */
public class NodeTester
{
    public static void main(String[] args)
    {

        Actor num1 = new Actor("Vivien Leigh");
        Node node1 = new Node(num1);

        Actor num2 = new Actor("Humphrey Bogart");
        Node node2 = new Node(num2);
        node2.setNextPtr(node1);

        Actor num3 = new Actor("Eva Marie Saint");
        Node node3 = new Node(num3);
        node3.setNextPtr(node2);

        Actor num4 = new Actor("James Stewart");
        Node node4 = new Node(num4);
        node4.setNextPtr(node3);

        Actor num5 = new Actor("Tony Curtis");
        Node node5 = new Node(num5);
        node5.setNextPtr(node4);

        Node current = node5;

        while (current!=null)
        {
            System.out.println(current);
            current=current.getNextPtr();
        }
        System.out.println(node5.get());
        System.out.println(((Actor)node5.get()).getName());



    }
}
