/**
 * Created by 131225 on 9/24/2018.
 */
public class Node
{
    Object data;
    Node next;

    Node() // be sure to set the next field to null!
    {
        data = null;
        next=null;
    }

    Node(Object data) // be sure to set the next field to null!
    {
        this.data=data;
        next=null;
    }

    Object get() // get a reference to the data object
    {
        return data;
    }

    void set(Object data) // sets the data field to the input object
    {
        this.data=data;
    }

    Node getNextPtr() // get a reference to the next node
    {
        return next;
    }

    void setNextPtr(Node next) // sets the next field to the input value
    {
        this.next=next;

    }

    public String toString() // returns the toString value of the enclosed data’s toString
    {
        return data.toString();
    }
}
