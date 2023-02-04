
public class BreadthFirstSearch {

    public static void main(String args[]) {
        //creates a graph having 10 vertices  
        ArrayOfListGraph graph = new ArrayOfListGraph(10);
        
        //add edges to the graph    
        graph.addNewEdge(2, 5);
        graph.addNewEdge(3, 5);
        graph.addNewEdge(1, 2);
        graph.addNewEdge(2, 4);
        graph.addNewEdge(4, 1);
        graph.addNewEdge(6, 2);
        graph.addNewEdge(5, 6);
        graph.addNewEdge(1, 6);
        graph.addNewEdge(6, 3);
        graph.addNewEdge(3, 1);
        graph.addNewEdge(7, 3);
        graph.addNewEdge(3, 7);
        graph.addNewEdge(7, 5);
        
        //print sequence in which BFS traversal execute  
        System.out.println("Breadth-first traversal sequence is: ");
        
        //root node  
//        graph.traversalBFS(2);
    }

}
