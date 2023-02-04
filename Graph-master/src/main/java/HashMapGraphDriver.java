//creating a class in which we have implemented the driver code  

public class HashMapGraphDriver {

    public static void main(String args[]) {
        //creating an object of the HashMapGraph class  
        HashMapGraph<Integer> graph = new HashMapGraph<Integer>();

        //adding edges to the graph  
        graph.addNewEdge(0, 1, true);
        graph.addNewEdge(0, 4, true);
        graph.addNewEdge(1, 2, true);
        graph.addNewEdge(1, 3, false);
        graph.addNewEdge(1, 4, true);
        graph.addNewEdge(2, 3, true);
        graph.addNewEdge(2, 4, true);
        graph.addNewEdge(3, 0, true);
        graph.addNewEdge(2, 0, true);

        //prints the adjacency matrix that represents the graph  
        System.out.println("Adjacency List for the graph:\n" + graph.toString());

        //counts the number of vertices in the graph   
        graph.countVertices();

        //counts the number of edges in the graph   
        graph.countEdges(true);

        //checks whether an edge is present or not between the two specified vertices  
        graph.containsEdge(3, 4);
        graph.containsEdge(2, 4);

        //checks whether vertex is present or not   
        graph.containsVertex(3);
        graph.containsVertex(5);

        System.out.println("Graph with String vertices...");
        
        HashMapGraph<String> graphTwo = new HashMapGraph<String>();
        graphTwo.addNewEdge("Bill", "Elon", true);
        graphTwo.addNewEdge("Bill", "Mark", true);
        graphTwo.addNewEdge("Bill", "Larry", false);
        graphTwo.addNewEdge("Larry", "Paul", false);

        graphTwo.containsEdge("Bill", "Mark");
        graphTwo.containsEdge("Paul", "Larry");

        graphTwo.addNewVertex("Gaga");

        System.out.println("Adjacency List for the graph:\n" + graphTwo.toString());
    }
}
