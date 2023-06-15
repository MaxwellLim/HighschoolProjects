import java.util.*;
import java.io.*;
public class Rats
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("input.txt"));
        int c = in.nextInt();
        for(int ci = 0; ci < c; ci++)
        {
            int n = in.nextInt();
            int e = in.nextInt();
            int t = in.nextInt();
            int m = in.nextInt();
            Graph maze = new Graph(n);

            for(int mi = 0; mi < m; mi++)
            {
                int a = in.nextInt();
                int b = in.nextInt();
                int weight = in.nextInt();

                maze.addEdge(a, b, weight);
            }

            int escapers = 0;
            for(int ni = 1; ni <= n; ni++)
            {
                int time = maze.pathWeight(ni, e);
                if(time <= t && time != -1)
                    escapers++;
            }

            System.out.println(escapers + "\n");
        }
        }
    }

class Graph
{
    HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public Graph(int size)
    {
        for(int i = 1; i <= size; i++)
        {
            nodeLookup.put(i, new Node(i));
        }
    }

    private Node getNode(int id)
    {
        return nodeLookup.get(id);
    }

    public void addEdge(int start, int end, int weight)
    {
        Node a = getNode(start);
        Node b = getNode(end);

        a.adjacent.put(b, weight);
    }

    public int pathWeight(int start, int end)
    {
        Node source = getNode(start);
        Node exit = getNode(end);

        for(Map.Entry<Integer, Node> entry : nodeLookup.entrySet())
        {
            entry.getValue().traveled = Integer.MAX_VALUE;
        }
        source.traveled = 0;

        HashSet<Node> visited = new HashSet<>();
        PriorityQueue<Node> toCheck = new PriorityQueue<>();
        toCheck.add(source);
        while(toCheck.size() > 0)
        {
            Node current = toCheck.poll();
            visited.add(current);
            for(Node node : current.adjacent.keySet())
            {
                if(!visited.contains(node) && node.traveled > current.traveled + current.adjacent.get(node))
                {
                    node.traveled = current.traveled + current.adjacent.get(node);
                    toCheck.add(node);
                }
            }
        }
        if(exit.traveled == Integer.MAX_VALUE)
            return -1;
        return exit.traveled;
    }

    static class Node implements Comparable<Node>
    {
        int id;
        HashMap<Node, Integer> adjacent = new HashMap<>();

        int traveled = Integer.MAX_VALUE;

        private Node(int id)
        {
            this.id = id;
        }

        public int compareTo(Node otherNode)
        {
            return this.traveled - otherNode.traveled;
        }
    }
}