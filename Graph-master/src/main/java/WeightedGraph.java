
import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    //note that we have created an adjacency list (i.e. List of List)      

    List<List<Node>> adjlist = new ArrayList<>();

    //creating a constructor of the class Graph that creates graph  
    public WeightedGraph(List<WeightedEdge> edges) {
        //find the maximum numbered vertex  
        int n = 0;

        //iterates over the edges of the graph  
        for (WeightedEdge e : edges) {
            //determines the maximum numbered vertex           
            n = Integer.max(n, Integer.max(e.s, e.d));
        }

        //reserve the space for the adjacency list  
        for (int i = 0; i <= n; i++) {
            adjlist.add(i, new ArrayList<>());
        }

        //adds the edges to the undirected graph  
        for (WeightedEdge e : edges) {
            //creating a new node (from source to destination) in the adjacency list   
            adjlist.get(e.s).add(new Node(e.d, e.w));

            //uncomment the following statement for undirected graph  
            //adj.get(e.dest).add(new Node(e.src, e.weight));  
        }
    }
//method that prints adjacency list of a graph  

    public static void printGraph(WeightedGraph graph) {
        int src = 0;
        int n = graph.adjlist.size();
        System.out.printf("Adjacency List for the Graph is: ");
        while (src < n) {
            //for-each loop prints the neighboring vertices with current vertex     
            for (Node edge : graph.adjlist.get(src)) {
                System.out.printf("%d -- > %s\t", src, edge);
            }
            System.out.println();
            //increments the source by 1  
            src++;
        }
    }
}
