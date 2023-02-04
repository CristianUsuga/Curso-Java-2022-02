
public class Traversal {

    public static void main(String args[]) {
        //creates a g1 having 10 vertices  
        ArrayOfListGraph g1 = new ArrayOfListGraph(10);

        //add edges to the g1    
        g1.addNewEdge(2, 5);
        g1.addNewEdge(3, 5);
        g1.addNewEdge(1, 2);
        g1.addNewEdge(2, 4);
        g1.addNewEdge(4, 1);
        g1.addNewEdge(6, 2);
        g1.addNewEdge(5, 6);
        g1.addNewEdge(1, 6);
        g1.addNewEdge(6, 3);
        g1.addNewEdge(3, 1);
        g1.addNewEdge(7, 3);
        g1.addNewEdge(3, 7);
        g1.addNewEdge(7, 5);

        System.out.print("\nDepth-first traversal of g1 starting at node 2 is: ");  
        g1.BFS(2);
        
        System.out.print("\nBreadth-first traversal of g1 starting at node 2 is: ");  
        g1.DFS(2);

        ArrayOfListGraph g2 = new ArrayOfListGraph(10);

        //add edges to the g1    
        g2.addNewEdge(1, 2);
        g2.addNewEdge(2, 3);
        g2.addNewEdge(3, 4);
        g2.addNewEdge(4, 5);
        g2.addNewEdge(5, 7);
        g2.addNewEdge(1, 3);
        g2.addNewEdge(1, 5);
        g2.addNewEdge(5, 5);
        g2.addNewEdge(2, 6);
        g2.addNewEdge(3, 7);
        //print sequencnce in which BFS traversal done   

        System.out.print("\nDepth-first traversal of graph g2 starting at node 1 is: ");
        //traversal starts from the node 3 (as root node)  
        g2.DFS(1);

        System.out.print("\nBreadth-first traversal of graph g2 starting at node 1 is: ");
        g2.BFS(1);
    }

}
