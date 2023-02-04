
public class Node {

    int value, weight;
    //creating a constructor of the class Vertex  

    Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
    
    //overrides the toString() method  

    @Override
    public String toString() {
        return this.value + " (" + this.weight + ")";
    }
}
