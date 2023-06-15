import java.io.*;
import java.util.*;
public class Compressor
{
    static HashMap<Character, String> paths = new HashMap<>();
    public static void main(String args[]) throws IOException
    {
        String file = "Tom Sawyer.txt";
        String[] splitFileName = file.split("\\.");
        BitInputStream inputStream = new BitInputStream(file);

        HashMap<Character, Integer> freq = new HashMap<>();

        int charInt = inputStream.read();
        while(charInt != -1)
        {
            if(freq.containsKey((char)charInt))
                freq.put((char)charInt, freq.get((char)charInt)+1);
            else
                freq.put((char)charInt, 1);

            charInt = inputStream.read();
        }

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> e : freq.entrySet())
        {
            Node n = new Node();
            n.data = e.getKey();
            n.freq = e.getValue();

            nodes.add(n);
        }

        while(nodes.size() > 1)
        {
            Node temp = new Node();
            temp.left = nodes.poll();
            temp.right = nodes.poll();
            temp.freq = temp.left.freq + temp.right.freq;

            nodes.add(temp);
        }

        Node current = nodes.peek();
        visit(current, "");

        for(Character c : paths.keySet())
        {
            String path = paths.get(c);
            if(Integer.parseInt(path, 2)==0)
            {
                current = nodes.peek();
                for(int i = 0; i < path.length(); i++)
                    current = current.left;

                Node temp = new Node();
                temp.data = current.data;
                temp.freq = current.freq;

                current.data = 0;
                current.right = temp;

                paths.put(c, path + "1");
            }
        }

        for(Character c : paths.keySet())
        {
            String output = paths.get(c);
        }

        inputStream.reset();
        BitOutputStream outputStream = new BitOutputStream(splitFileName[0] + ".comp.666");
        charInt = inputStream.read();
        while(charInt != -1)
        {
            String output = paths.get((char)charInt);
            outputStream.writeBits(output.length(), Integer.parseInt(output, 2));
            charInt = inputStream.read();
        }
        outputStream.close();



        BitInputStream inputStream1 = new BitInputStream(splitFileName[0] + ".comp.666");
        BitOutputStream outputStream1 = new BitOutputStream(splitFileName[0] + ".decomp." + splitFileName[1]);
        int bit = inputStream1.readBits(1);
        current = nodes.peek();
        while(current != null && bit != -1)
        {
            if(current.data != 0)
        {
            outputStream1.write(current.data);
            current = nodes.peek();
        }
            if(bit == 0)
                current = current.left;
            else if(bit == 1)
                current = current.right;
            bit = inputStream1.readBits(1);
        }
        outputStream1.close();


    }

    public static void visit(Node parent, String path)
    {
        if(parent.data != 0)
        {
            paths.put(parent.data, path);
            return;
        }
        visit(parent.left, path + "0");
        visit(parent.right, path + "1");
    }
}
class Node implements Comparable<Node>
{
    char data;
    int freq;
    Node left, right;

    public int compareTo(Node otherNode)
    {
        return this.freq - otherNode.freq;
    }
}