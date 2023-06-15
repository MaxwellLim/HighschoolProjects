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
    void add(Object data) // adds object to the beginning of the list
    {
        Node temp = head;
        head = new Node(data);
        head.setNextPtr(temp);
        count++;

    }

    Object get(int index) // get a reference to the object at the position given,
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

    Object getLast()
    {
        Node temp = head;
        for(int x = 0; x<count;x++)
        {
            temp=temp.getNextPtr();
        }
        return temp.get();
    }



    Object removeLast()
    {
        Node temp = head;
        for(int x = 0; x<count-1;x++)
        {
            temp=temp.getNextPtr();
        }
        count--;
        return temp.get();
    }

    Object getFirst()
    {
        return head;
    }

    Object removeFirst()
    {
        Node temp = head;
        head = head.getNextPtr();
        return temp.get();

    }


    int size() // returns number of objects on list
    {
        return count;
    }
}
