public class BST<E> extends BinaryTree {

    BST(){
        super();
    }

    /**
     * Aggiunge il dato val all’albero rispettando la struttura dell’albero di ricerca
     * @param val
     */
    public void insert(E val){
        if(getRoot()==null){
            setRoot(val);
        }
        Node current = getRoot();
        boolean inserito = false;
        while (!inserito) {
            if (compareTo(val, (E) current.getValue()) <= 1) {
                if(current.getLeft() == null){
                    current.setLeft(val);
                    inserito = true;
                }else{
                    current = current.getLeft();
                }
            }else {
                if(current.getRight() == null){
                    current.setRight(val);
                    inserito = true;
                }else{
                    current = current.getRight();
                }
            }
        }
    }

    public int compareTo(E val1, E val2){
        return 1;
    }

}
