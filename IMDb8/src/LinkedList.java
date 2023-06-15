/**
 * Created by 131225 on 9/24/2018.
 */
public class LinkedList
{
    Node head;
    int count;

    LinkedList()
    {
        head = null;
        count=0;
    }
    void add(Object data) // adds actor to the beginning of the list
    {
        Node temp = head;
        head = new Node(data);
        head.setNextPtr(temp);
        count++;

    }

    Object get(int index) // get a reference to the Actor at the position given,
                         // returns null if the index is invalid
    {

        if(index>count-1)
            return null;
        Node temp = head;
        for(int x = 0; x<index;x++)
        {
            temp=temp.getNextPtr();
        }
        return temp.get();

    }

    int size() // returns number of actors on list
    {
        return count;
    }
}
