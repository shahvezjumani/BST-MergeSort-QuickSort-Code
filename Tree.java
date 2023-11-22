// tree class
public class Tree {
    // Node class
    public class Node {
        int value;
        Node left,right;
    // Node class constructor
        public Node(int value){
            this.value = value;
        }
    }
    Node root;
    public void insert(int value){
        root = insert(value,root);
    }
    // insert method of BST
    public Node insert(int value,Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(node.value > value){
            node.left = insert(value,node.left);
        }else if (node.value < value){
            node.right = insert(value,node.right);
        }

        return node;
    }
    // method for pre-order traversal
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    // method for post-order traversal
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }
    // method for in-order traversal
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }
    // method for finding max
    public int findMax(){
        Node max = findMax(root);
        return max.value;
    }
    public Node findMax(Node node){
        if(node.right == null){
            return node;
        }
        return findMax(node.right);
    }
    // method for finding min
    public int findMin(){
        Node min = findMin(root);
        return min.value;
    }
    public Node findMin(Node node){
        if(node.left == null){
            return node;
        }
        return findMin(node.left);
    }
    // method for searching in the BST
    public boolean search(int key){
        return search(key,root);
    }
    public boolean search(int key,Node node){
        if(node == null){
            return false;
        }
        if(node.value > key){
            return search(key,node.left);
        } else if (node.value == key) {
            return true;
        } else {
            return search(key,node.right);
        }
    }
    public void deleteNode(int key){
        root = deleteNode(key,root);
    }
    public Node deleteNode(int key,Node node){
        if(node.value > key){
            node.left = deleteNode(key,node.left);
        } else if(node.value < key){
            node.right = deleteNode(key,node.right);
        }else {
            if(node.left == null && node.right == null){
                return null;
            }
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node IS = inOrderSuccessor(node.right);
            node.value = IS.value;
            node.right = deleteNode(IS.value,node);
        }
        return node;
    }
    public Node inOrderSuccessor(Node node){
        if(node.left == null){
            return node;
        }
        return inOrderSuccessor(node.left);
    }
    // main class
    public static void main(String[] args) {
        Tree tree = new Tree();
        int [] values = {15,23,1000,78,0,1,6};
        for (int i=0;i<values.length;i++){
            tree.insert(values[i]);
        }
        tree.preOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        System.out.println("Max is : "+tree.findMax());
        System.out.println("Min is : "+tree.findMin());
        System.out.println(tree.search(20));
        tree.deleteNode(23);
        tree.deleteNode(78);
        tree.inOrder();
    }
}
