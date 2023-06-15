import java.util.*;
import java.io.*;
public class Paver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new File("paver.dat"));
        int cases = reader.nextInt();
        for (int i = 0; i < cases ; i++)
        {
            Graph roads = new Graph();
            int price = reader.nextInt();
            int numbuildings = reader.nextInt();
            int streets = reader.nextInt();
            for (int j = 0; j < streets ; j++)
            {
                int fst = reader.nextInt();
                int snd = reader.nextInt();
                int cost = reader.nextInt();
                roads.addEdge(fst,snd,cost);

            }
            int cost = 0;


            System.out.println(roads.minSpanningTreeWeight()*price);
        }

    }
}

class Graph
{
    HashMap<Integer, Node> nodeLookup = new HashMap<>();

    private Node getNode(int id)
    {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination, int weight)
    {
        if(getNode(source)==null)
            nodeLookup.put(source, new Node(source));
        if(getNode(destination)==null)
            nodeLookup.put(destination, new Node(destination));

        Node a = getNode(source);
        Node b = getNode(destination);

        Edge edge = new Edge(a, b, weight);

        a.edges.add(edge);
        b.edges.add(edge);
    }

    public int minSpanningTreeWeight()
    {
        int totalEdgeWeight = 0;
        HashSet<Node> visited = new HashSet<>();
        PriorityQueue<Edge> edgesToCheck = new PriorityQueue<>();


        Node current = nodeLookup.get(nodeLookup.keySet().toArray()[0]);
        while(visited.size() < nodeLookup.size())
        {
            visited.add(current);
            for(Edge edge : current.edges)
            {
                if(!(visited.contains(edge.a) && visited.contains(edge.b)))
                    edgesToCheck.add(edge);
            }

            Edge shortest = edgesToCheck.poll();
            while(shortest != null && (visited.contains(shortest.a) && visited.contains(shortest.b)))
            {
                shortest = edgesToCheck.poll();
            }

            if(shortest == null)
                break;
            if(!visited.contains(shortest.a))
                current = shortest.a;
            else
                current = shortest.b;
            totalEdgeWeight += shortest.weight;
        }
        return totalEdgeWeight;
    }

    static class Node
    {
        int id;
        LinkedList<Edge> edges = new LinkedList<>();
        private Node(int id)
        {
            this.id = id;
        }
    }

    static class Edge implements Comparable<Edge>
    {
        int weight;
        Node a, b;
        private Edge(Node a, Node b, int weight)
        {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        public int compareTo(Edge otherEdge)
        {
            return this.weight - otherEdge.weight;
        }
    }
}