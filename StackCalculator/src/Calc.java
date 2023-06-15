import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by 131225 on 8/24/2018.
 */
public class Calc extends MyStack
{
    public static void main(String[] args) throws FileNotFoundException
    {
        MyStack stack = new MyStack();

        Scanner reader = new Scanner(new File("Numbers.txt"));

        double answer;
        double temp;
        double temp2;
        while(reader.hasNext())

            if (reader.hasNextDouble())
                stack.push(reader.nextDouble());
                else
                {
                    switch (reader.next())
                    {
                        case "*": answer= stack.pop()*stack.pop();
                                  stack.push(answer);
                                  break;
                        case "+": answer= stack.pop()+stack.pop();
                                  stack.push(answer);
                                  break;
                        case "-": temp=stack.pop();
                                  temp2=stack.pop();
                                  answer=temp2-temp;
                                  stack.push(answer);
                                  break;
                        case "/": temp=stack.pop();
                                  temp2=stack.pop();
                                  answer=temp2/temp;
                                  stack.push(answer);
                                  break;
                    }
                }

        System.out.print("The answer is "+stack.peek());





    }
}
