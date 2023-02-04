
import java.util.Arrays;
import java.util.List;


public class WeightedGraphDriver {

    public static void main(String args[]) {
    //creating a list of edges with their associated weight   
        List<WeightedEdge> edges = Arrays.asList(new WeightedEdge(1, 4, 3), new WeightedEdge(4, 2, 5),
                new WeightedEdge(2, 5, 10), new WeightedEdge(5, 1, 6), new WeightedEdge(3, 2, 9), 
                new WeightedEdge(1, 5, 1), new WeightedEdge(3, 5, 2));
        
        //creates a graph with the edges declared above  
        WeightedGraph graph = new WeightedGraph(edges);
        
        //prints the corresponding adjacency list for the graph  
        WeightedGraph.printGraph(graph);
    }

}
