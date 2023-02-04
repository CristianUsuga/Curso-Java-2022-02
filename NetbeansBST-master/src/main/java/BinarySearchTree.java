
import java.util.LinkedList;
import java.util.Stack;

class BinarySearchTree {

    // Class containing left and right child of current node and key value 
    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    static Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int value) {
        root = new Node(value);
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST 
    Node insertRec(Node root, int key) {

        // If the tree is empty, return a new node 
        if (root == null) {
            root = new Node(key);
            return root;
        } /* Otherwise, recur down the tree */ else if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // A utility function to search a given key in BST
    public static Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }

        // Key is greater than root's key
        if (root.key < key) {
            return search(root.right, key);
        }

        // Key is smaller than root's key
        return search(root.left, key);
    }

    public void insertIterative(int key) {
        // A new key is inserted as a leave
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node prev = null;
        Node temp = root;
        while (temp != null) {
            if (temp.key > key) {
                prev = temp;
                temp = temp.left;
            } else if (temp.key < key) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.key > key) {
            prev.left = node;
        } else {
            prev.right = node;
        }
    }

    public void inorderWithStack() {
        Node temp = root;
        Stack<Node> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.key + " ");
                temp = temp.right;
            }
        }
    }

    void TraverseByLevel(Node root) {
        LinkedList<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.print(n.key + " ");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    void TraverseByLevelShowingLevels(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> queueLevel = new LinkedList<>();

        int actualLevel = 0;

        if (root != null) {
            queue.add(root);
            queueLevel.add(1);
        }
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            int level = queueLevel.remove();

            if (level > actualLevel) {
                actualLevel = level;
                System.out.print("\nLevel " + actualLevel + ":");
            }
            System.out.print(n.key + " ");
            if (n.left != null) {
                queue.add(n.left);
                queueLevel.add(level + 1);
            }
            if (n.right != null) {
                queue.add(n.right);
                queueLevel.add(level + 1);
            }
        }
    }

    //***********Examen****************
    static int greatestElement(Node root) {
        //Vacio
        if (root == null) {
            return 0;
        }
        //
        Node a = root;
        int greatest = a.key;
        if (a.right == null) {
            //System.out.println(greatest);
            return greatest;

        } else {
//             System.out.print("actual:"+a.key+" | ");
            return greatestElement(a.right);
        }
    }

    static int leastElement(Node root) {
        if (root == null) {
            return 0;
        }
        Node a = root;
        int least = a.key;
        if (a.left == null) {
            return least;
        } else {
            return leastElement(a.left);
        }

    }

    static int countNodosInLevel(Node root, int targetLevel) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> queueLevel = new LinkedList<>();
        int actualLevel = 0;
        int contador =0;
        
        if (root != null) {
            queue.add(root);
            queueLevel.add(1);
        }
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            int level = queueLevel.remove();

            if ( targetLevel == actualLevel) {
                actualLevel = level;
                System.out.print("\nLevel " + actualLevel + ":");
            }
            System.out.print(n.key + " ");
            if (n.left != null) {
                queue.add(n.left);
                queueLevel.add(level + 1);
                contador++;
            }
            if (n.right != null) {
                queue.add(n.right);
                queueLevel.add(level + 1);
                contador++;
            }
        }
        return contador;
    }

    // Driver Code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);
// 8, 3,  1, 6, 4, 7, 10, 14, 13
        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(13);
        // print inorder traversal of the BST
        System.out.println("The inorder traversal of BST is...");
        tree.inorderWithStack();

        Node placeInTree = BinarySearchTree.search(root, 70);

        if (placeInTree == null) {
            System.out.println("\n" + 70 + " is not found in BST");
        } else {
            System.out.println(placeInTree.key + " is found in BST");
        }

        placeInTree = BinarySearchTree.search(root, 25);
        if (placeInTree == null) {
            System.out.println(25 + " is not found in BST");
        } else {
            System.out.println(placeInTree.key + " is found in BST");
        }

        System.out.println("The preorder traversal of BST is...");
        tree.preorderRec(root);

        System.out.println("\nThe postorder traversal of BST is...");
        tree.postorderRec(root);

        System.out.println("\nThe by level traverse of BST is...");
        tree.TraverseByLevel(root);

        System.out.println("\nThe by level traverse showing levels of BST is...");
        tree.TraverseByLevelShowingLevels(root);
        //
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("******Examen******");
        System.out.println("\nThe least element of BST is " + leastElement(root));

        System.out.println("The greatest element of BST is " + greatestElement(root));
        
            System.out.println("The number of nodes in level 2 is " + countNodosInLevel(root, 2));
            System.out.println("The number of nodes in level 4 is " + countNodosInLevel(root, 4));


    }
}
