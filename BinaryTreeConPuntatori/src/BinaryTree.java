public class BinaryTree<E> {
    static public class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        Node() {
            this.left = null;
            this.right = null;
            this.value = null;
        }

        /**
         * Vari getter
         *
         * @return
         */
        public E getValue() {
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
         *
         * @param
         */
        public void setValue(E value) {
            this.value = value;
        }

        public void setRight(E val) {
            this.right = new Node<>();
            this.right.setValue(val);
        }

        public void setLeft(E val) {
            this.left = new Node<>();
            this.left.setValue(val);
        }
    }

    private Node<E> root;

    /**
     * Costruttore dell’albero binario vuoto
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Costruttore dell’albero binario con un nodo radice
     *
     * @param root
     */
    public BinaryTree(Node<E> root) {this.root = root;}

    /**
     * Restituisce la radice dell'albero
     *
     * @return
     */
    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(E val) {
        this.root = new Node<>();
        this.root.setValue(val);
    }

    /**
     * Restituisce una rappresentazione testuale dell'albero binario
     *
     * @param r
     * @return stringa: ((( 30 ) 20 ) 10 (( 50 ) 40 ( 60 ( 70 ))))
     */
    public String printRec(Node r){
        if(r == null){
            return null;
        }

        return "( " + printRec(r.getLeft()) + r.getValue() + printRec(r.getRight()) + " )";
    }

    /**
     * Cerca se il valore val appartiene o meno all’albero binario usando una visita in ordine anticipato
     *
     * @param value
     * @return
     */
    public boolean search(E value, Node r) {
        if (r == null) {
            return false;
        }

        return value.equals(r.getValue()) || search(value, r.getLeft()) || search(value, r.getRight());
    }

    /**
     * Conta il numero di foglie dell’albero
     *
     * @param r
     * @return nFoglie;
     */
    public int contaFoglie(Node r) {
        if(r == null){
            return 0;
        }

        return 1 + contaFoglie(r.getLeft()) + contaFoglie(r.getRight());
    }

    /**
     * Crea l'intero albero binario
     * (opzionale per non farlo direttamente sul 'main')
     */
    public void createBTree() {

    }
}
