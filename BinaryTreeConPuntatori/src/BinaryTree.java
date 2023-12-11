import java.util.ArrayList;

public class BinaryTree<E> {

    static public class Node<E>{
        private int value;
        private Node<E> left;
        private Node<E> right;

        Node(int value){
            this.left = null;
            this.right = null;
            value = 0;
        }

        /**
         * Vari getter
         * @return
         */
        public int getValue() {
            return value;
        }
        public Node<E> getLeft() {
            return left;
        }
        public Node<E> getRight() {
            return right;
        }

        /**
         * Vari setter
         * @param
         */
        public void setValue(int value) {
            this.value = value;
        }
        public void setRight(Node<E> right) {
            this.right = right;
        }
        public void setLeft(Node<E> left) {
            this.left = left;
        }
    }

    private Node<E> root;
    private ArrayList<Node> nodi = new ArrayList<>();

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root){
        this.root = root;
    }

    /**
     * Restituisce una rappresentazione testuale dell'albero binario
     * @param r
     * @return
     */
    public String print(Node r){
        return
    }

    /**
     * Cerca se il valore val appartiene o meno all’albero binario usando una visita in ordine anticipato
     * @param value
     * @param current
     * @return
     */
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

    /**
     * Conta il numero di foglie dell’albero
     * @param r
     * @return nFoglie;
     */
    public int contaFoglie(Node r){
        int nFoglie = 0;
        //Inserire codice
        return nFoglie;
    }

    public Node getRoot() {
        return root;
    }

    public void createBTree(ArrayList<Node> nodi){

    }
}
