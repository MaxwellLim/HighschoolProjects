/**
 * Created by 131225 on 8/22/2018.
 */
public class MyStack implements IStack
{
    public double[] calc;
    public int top;

    public MyStack()
    {
        calc=new double[10];
        top=0;
    }


    /**
     * The push method should verify there is space on the stack before
     *      taking action. If stack is full, push does nothing.
     *
     *   y    the double value to be pushed on the stack
     */
    public void push(double value)
    {
        if(isFull())
           return;
        else
        {
            calc[top] = value;
            top++;
        }
    }

    /**
     * The pop method should verify there is a valid value on the stack
     *      before taking action.
     * Removes and returns the value on the top of the stack.
     * If stack is empty, pop returns zero.
     *
     * @return  the value from the top of the stack
     */
    public double pop()
    {

        if(this.isEmpty())
            return 0;
            top--;
            return calc[top];


    }

    /**
     * The peek method should verify there is a valid value on the stack
     *      before taking action.
     * Returns the value on the top of the stack.
     * If the stack is empty, peek returns zero.
     *
     * @return  the value from the top of the stack
     */
    public double peek()
    {
        if (isEmpty())
            return 0;
        else
            return calc[top-1];
    }

    /**
     * Returns the number of values on the stack.
     *
     * @return    number of values on the stack
     */
    public int size()
    {
        return top;
    }

    /**
     * Returns true if the stack is empty & false otherwise
     *
     * @return     true if no values are stored on the stack,
     *             false otherwise
     */
    public boolean isEmpty()
    {
        if (this.size()>0 )
            return false;
        else
            return true;

    }

    /**
     * Returns true if the stack is full & false otherwise
     *
     * @return     true if no more values will fit on the stack,
     *             false otherwise
     */
    public boolean isFull()
    {
        if (this.size()==calc.length )
            return true;
        else
            return false;

    }
    /**
     * Places the stack in an empty condition
     */
    public void clear()
    {
        for (int x = 0; x<calc.length;x++)
        {
            calc[x]=0;
            top--;
        }
        top=0;
    }

    public boolean resize()
    {
        if(isFull())
            return true;
        else
            return false;

    }

    public String toString()
    {
        String print="";
        for (int x = 1; x<=calc.length;x++)
        {

            print=print+calc[x-1]+"\n";
        }
        return print;

    }
}
