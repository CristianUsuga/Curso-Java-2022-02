
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayOfListGraph {
    //stores the number of vertices   

    private int vertices;
    //creates a linked list for the adjacency list of the graph   

    private LinkedList<Integer>[] adjList;
    //creating a constructor of the Graph class   

    ArrayOfListGraph(int count_v) {
        //assigning the number of vertices to the passed parameter  
        vertices = count_v;
        adjList = new LinkedList[count_v];

        //loop for creating the adjacency lists  
        for (int i = 0; i < count_v; ++i) {
            adjList[i] = new LinkedList();
        }
    }
//method that adds a new edge to the graph  

    void addNewEdge(int v, int w) {
        adjList[v].add(w);
    }

    void traversalDFS(int v, boolean[] visitedNode) {
        //if current node (root node) is visited, add it to the visitedNode   
        visitedNode[v] = true;
        System.out.print(v + " ");
        //determines the negihboring nodes of the current node  
        //iterates over the list    
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext()) {
            //returns the next element in the iteration and store that element in the variable n      
            int n = i.next();
            if (!visitedNode[n]) //calling the function that performs depth first traversal    
            {
                traversalDFS(n, visitedNode);
            }
        }
    }

    void DFS(int v) {
        //creates an array of boolean type for visited node   
        //initially all nodes are unvisited  
        boolean visited[] = new boolean[vertices];

        //call recursive traversalDFS() function for DFS   
        traversalDFS(v, visited);
    }
    //traversal starts from the root node   

    void BFS(int rnode) {
        //creates an array of boolean type for visited node   
        //initially all nodes are unvisited  
        boolean[] visitedNode = new boolean[vertices];

        //creating another list for storing the visited node  
        LinkedList<Integer> vNodeList = new LinkedList<Integer>();

        //if current node (root node) is visited, add it to the vNodeList   
        visitedNode[rnode] = true;

        //inserts the visited node into vNodeList  
        vNodeList.add(rnode);

        //the while loop executes until we have visited all the nodes  
        while (vNodeList.size() != 0) {
            //deque an entry from queue and process it    
            //the poll() method retrieves and removes the head (first element) of this list  
            rnode = vNodeList.poll();
            System.out.print(rnode + " ");

            //detrmines the negihboring nodes of the current node  
            //iterates over the list   
            Iterator<Integer> i = adjList[rnode].listIterator();
            while (i.hasNext()) {
                //returns the next element in the iteration and store that element in the variable n      
                int n = i.next();

                //checks the next node is visited or not  
                if (!visitedNode[n]) {
                    //if the above if-statement returns true, visits the node   
                    visitedNode[n] = true;
                    //adds the visited node in the vNodeList  
                    vNodeList.add(n);
                }
            }
        }
    }
}
