/**
 * Created by 131225 on 9/4/2018.
 */
public class RingBuffer {

    private double[] queue;
    private int front;
    private int size;


    public RingBuffer() {
        queue = new double[10];
        front = 0;
        size = 0;
        ;

    }

    public RingBuffer(int capacity) // create an empty ring buffer, with given max capacity
    {
        queue = new double[capacity];
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

    void enqueue(double x) // add item x to the end
    {
            int back = (front + size) % queue.length;
            queue[back] = x;
            size++;

    }

    double dequeue() // delete and return item from the front
    {
        if (isEmpty())
            return -1;
        else {
            double temp = queue[front];
            if (front == queue.length - 1)
                front = 0;
            else
                front++;
            size--;
            return temp;
        }
    }

    double peek() {
        return queue[front];
    }


}
