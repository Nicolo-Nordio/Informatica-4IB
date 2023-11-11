public class Main {
    public static void main(String[] args) {
        BTree binaryTree = new BTree();

        // Aggiunta di valori all'albero
        binaryTree.treeList.add(1);
        binaryTree.treeList.add(2);
        binaryTree.treeList.add(null);
        binaryTree.treeList.add(4);
        binaryTree.treeList.add(5);
        binaryTree.treeList.add(6);
        binaryTree.treeList.add(null);
        binaryTree.treeList.add(8);

        // Stampa dell'ordine di attraversamento dell'albero
        System.out.println("PreOrder: " + binaryTree.preOrder());

        // Ricerca di un valore nell'albero
        int searchValue = 5;
        int searchResult = binaryTree.search(searchValue);
        if (searchResult != -1) {
            System.out.println("Il valore " + searchValue + " è presente nella posizione " + searchResult);
        } else {
            System.out.println("Il valore " + searchValue + " non è presente nell'albero.");
        }

        // Ottenere il figlio sinistro e destro di un nodo
        int nodeValue = 2;
        int leftChild = binaryTree.leftChild(nodeValue);
        int rightChild = binaryTree.rightChild(nodeValue);

        if (leftChild != -2 && leftChild != -1) {
            System.out.println("Il figlio sinistro di " + nodeValue + " è nella posizione " + leftChild);
        } else if (leftChild == -1) {
            System.out.println("Il figlio sinistro di " + nodeValue + " non è presente.");
        } else {
            System.out.println("Il valore " + nodeValue + " non è presente nell'albero.");
        }

        if (rightChild != -2 && rightChild != -1) {
            System.out.println("Il figlio destro di " + nodeValue + " è nella posizione " + rightChild);
        } else if (rightChild == -1) {
            System.out.println("Il figlio destro di " + nodeValue + " non è presente.");
        } else {
            System.out.println("Il valore " + nodeValue + " non è presente nell'albero.");
        }

        // Verifica dell'esistenza del padre di un nodo
        int parentNodeValue = 5;
        if (binaryTree.fatherExist(parentNodeValue)) {
            System.out.println("Il nodo " + parentNodeValue + " ha un padre.");
        } else {
            System.out.println("Il nodo " + parentNodeValue + " non ha un padre o non è presente nell'albero.");
        }
    }
}