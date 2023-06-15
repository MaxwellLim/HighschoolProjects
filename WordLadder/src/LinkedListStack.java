public class LinkedListStack {

    private Node head;
    private int count;

    public LinkedListStack()
    {
        head=null;
    }

    public void push(Object data)
    {
        Node temp=new Node(data);
        temp.setNextPtr(head);
        head=temp;
        count++;
    }

    public Object pop()
    {
        if(count==1)
        {
            Node tem=head;
            head=null;
            count--;
            return tem;
        }
        else
        {
            Node temp=head;
            head=head.getNextPtr();
            temp.setNextPtr(null);
            count--;
            return temp.get();
        }
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

    public Object peek()
    {
        return head;
    }

    public int size()
    {
        return count;
    }

    public String toString()
    {
        String output="[\t" + peek() + "\t";
        Node act=head;
        for(int x=0;x<count-1;x++)
        {
            act=act.getNextPtr();
            output+=act.get() + "\t";
        }
        return output + "]";
    }
}

