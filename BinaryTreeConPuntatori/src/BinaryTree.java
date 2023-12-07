public class BinaryTree {

    static public class Node{
        private int value;
        private Node left;
        private Node right;

        Node(int value){
            left = null;
            right = null;
            value = 0;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }
 // Da capire
    public BinaryTree(Node root){
        this.root = root;
    }

    public String print(Node r){
        return
    }

    public boolean search(int value, Node current) {
        if (current == null) {
            return false;
        }

        int currentValue = current.getValue();

        if (value == currentValue) {
            return true;
        } else if (value < currentValue) {
            return search(value, current.getLeft());
        } else {
            return search(value, current.getRight());
        }
    }

    public int contaFoglie(Node r){

    }

}
