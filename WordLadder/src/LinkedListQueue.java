public class LinkedListQueue {
    private Node head;
    private Node tail;
    private int count;

    public LinkedListQueue()
    {
        head=null;
        tail=null;
    }
    public void enqueue(Node data)
    {
        if(count==0)
        {
            head=data;
            tail=head;
        }
        else
        {
            Node temp=head;
            for(int x=0;x<count-1;x++)
            {
                head=head.getNextPtr();
                tail=head;
            }
            head=temp;
            tail.setNextPtr(data);
            tail=tail.getNextPtr();
        }
        count++;
    }

    public Object dequeue()
    {
        Node temp=head;
        head=head.getNextPtr();
        temp.setNextPtr(null);
        count--;
        return temp.get();
    }

    public Object get(int index)
    {
        if(head==null)
            return null;
        else
        {
            Node temp=head;
            for(int x=0;x<index;x++)
                temp=temp.getNextPtr();

            return temp.get();
        }
    }
    public int size()
    {
        return count;
    }
}

