import java.util.*;
import java.io.*;

public class WordLadder {

    public static void main(String[] args) throws Exception {

        Scanner dict = new Scanner(new File("dictionary.txt"));
        Scanner in = new Scanner(new File("input.txt"));

        HashSet<String> dictionary = new HashSet<>();
        ArrayList<String> tempList = new ArrayList<>();
        String edit;

        while(dict.hasNext())
        {
            dictionary.add(dict.next());
        }

        while((in.hasNext()))
        {
            HashSet<String> used = new HashSet<>();
            LinkedListQueue queueStack = new LinkedListQueue();
            String start =in.next();
            String end=in.next();

            if(start.equals(end))
            {
                System.out.println("[" + start + "]");
            }
            else
            {
                edit=start;
                for(int x=0;x<start.length();x++)
                {
                    for(int y=0;y<26;y++)
                    {
                        LinkedListStack temp = new LinkedListStack();
                        temp.push(start);

                        char ch[] = edit.toCharArray();
                        ch[x]=(char) (97+y);
                        edit=String.valueOf(ch);

                        if(dictionary.contains(edit)&&!edit.equals(start))
                        {
                            temp.push(edit);
                            queueStack.enqueue(new Node(temp));
                            used.add(edit);

                        }
                    }
                    edit=start;
                }

                LinkedListStack temp =(LinkedListStack) queueStack.dequeue();
                String temp1 = temp.peek()+"";
                String temp2 = temp1;

                while(!temp1.equals(end) && queueStack.size()>0)
                {
                    for(int x=0;x<start.length();x++)
                    {
                        for(int y=0;y<26;y++)
                        {
                            char ch[] = temp1.toCharArray();
                            ch[x]=(char) (97+y);
                            temp1=String.valueOf(ch);
                            if(dictionary.contains(temp1))
                            {
                                if(!temp1.equals(start)&&!used.contains(temp1))
                                {
                                    LinkedListStack cop = temp;
                                    LinkedListStack tempStack = new LinkedListStack();
                                    //System.out.println(cop + "kol");
                                    int num1 = cop.size();
                                    for(int z=0;z<num1;z++)
                                    {
                                        tempList.add(cop.pop() + "");
                                    }
                                    for(int z=tempList.size()-1;z>=0;z--)
                                    {
                                        tempStack.push(tempList.get(z));
                                        temp.push(tempList.get(z));
                                    }
                                    tempList.clear();
                                    tempStack.push(temp1);
                                    used.add(temp1);
                                    queueStack.enqueue(new Node(tempStack));
                                }
                            }
                        }
                        temp1=temp2;
                    }
                    temp = (LinkedListStack) queueStack.dequeue();
                    temp1 = temp.peek()+"";
                    temp2=temp1;
                }

                if(temp1.equals(end))
                {
                    String output="[";
                    while(temp.size()>0)
                        tempList.add(temp.pop()+"");
                    for(int x=tempList.size()-1;x>0;x--)
                        output+=tempList.get(x)+ ", ";
                    output+=tempList.get(0)+"]";
                    tempList.clear();
                    System.out.println(output);
                }
                else
                    System.out.println("There is no word ladder between " + start + " and " + end);

            }
        }

    }

}

