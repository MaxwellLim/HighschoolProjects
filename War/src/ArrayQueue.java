/**
 * Created by 131225 on 9/4/2018.
 */
public class ArrayQueue {

    private String[] queue;
    private int front;
    private int size;


    public ArrayQueue() {
        queue = new String[10];
        front = 0;
        size = 0;


    }

    public ArrayQueue(int capacity) // create an empty ring buffer, with given max capacity
    {
        queue = new String[capacity];
        front = 0;
        size = 0;
    }

    int size() // return number of items currently in the buffer
    {
        return size;
    }

    boolean isEmpty() // is the buffer empty (size equals zero)?
    {
        if (size == 0)
            return true;
        else
            return false;
    }

    boolean isFull() // is the buffer full (size equals capacity)?
    {
        if (size == queue.length)
            return true;
        else
            return false;
    }

    void enqueue(String x) // add item x to the end
    {
        if(isFull())
        return;
        else
        {
            int back = (front + size) % queue.length;
            queue[back] = x;
            size++;
        }

    }

    String  dequeue() // delete and return item from the front
    {


            String  temp = queue[front];
            if (front == queue.length - 1)
                front = 0;
            else
                front++;
            size--;
            return temp;

    }

    String peek() {
        return queue[front];
    }


}
