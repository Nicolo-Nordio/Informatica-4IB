import java.util.ArrayList;

public class BinaryTree<E> {
    static public class Node<E>{
        private int value;
        private Node<E> left;
        private Node<E> right;

        Node(){
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

    public BinaryTree(Node<E> root){
        this.root = root;
    }

    /**
     * Restituisce il 'root'
     * @return
     */
    public Node<E> getRoot() {
        return root;
    }

    /**
     * Restituisce una rappresentazione testuale dell'albero binario
     * @param r
     * @return
     */
    public String print(Node r){
        //
        return "";
    }

    /**
     * Aggiunge il dato 'val' all’albero rispettando la struttura dell’albero di ricerca
     * @param
     */
    public void insert(int inizio, int fine, Node current, ArrayList<Node> vocaboli) {
        if (inizio <= fine) {
            int medio = (inizio + fine) / 2;
            Node nodoMedio = vocaboli.get(medio);
            current.setValue(nodoMedio.getValue());

            if (inizio < medio) {
                current.setLeft(new Node());
                insert(inizio, medio - 1, current.getLeft(), vocaboli);
            }

            if (medio < fine) {
                current.setRight(new Node());
                insert(medio + 1, fine, current.getRight(), vocaboli);
            }
        }
    }

    /**
     * Elimina il dato val dall’albero
     * @param val
     */
    public void del(E val){

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

    /**
     * Crea l'intero albero binario
     * (opzionale per non farlo direttamente sul 'main')
     * @param nodi
     */
    public void createBTree(ArrayList<Node> nodi){

    }
}
