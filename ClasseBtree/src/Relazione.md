### Introduzione
La classe `BTree` è stata progettata per rappresentare un albero binario utilizzando una struttura dati dinamica basata su un `ArrayList` di `Integer`. L'albero binario è implementato in modo che i nodi siano numerati da sinistra a destra a partire dalla radice, e ogni nodo può avere al massimo due figli.

### Struttura della Classe
La classe `BTree` è composta dai seguenti membri:

- `treeList`: Un oggetto `ArrayList` di tipo `Integer` che rappresenta l'albero binario. 

- `currentIndex`: Un indice che tiene traccia della posizione corrente durante l'attraversamento dell'albero.

### Costruttore
Il costruttore della classe inizializza l'elenco `treeList` come un nuovo oggetto `ArrayList`.

```java
public BTree() {
    this.treeList = new ArrayList<>();
}
```

### Metodi Principali

#### `int search(int val)`
Questo metodo restituisce l'indice della prima occorrenza del valore specificato all'interno dell'albero. Se il valore non è presente, il metodo restituisce `-1`.

#### `int leftChild(int val)` e `int rightChild(int val)`
Questi metodi restituiscono l'indice del figlio sinistro e destro di un nodo con il valore specificato. Se il nodo non è presente, restituiscono `-2`. Se il figlio non è presente, restituiscono `-1`.

#### `boolean fatherExist(int val)`
Questo metodo verifica se un nodo con il valore specificato ha un padre. Restituisce `true` se il nodo ha un padre, altrimenti restituisce `false`.

#### `List<Integer> preOrder()`
Questo metodo restituisce una lista di valori ottenuti attraversando l'albero in preordine. Durante l'attraversamento, i nodi null non vengono inclusi.

### Utilizzo della Classe
La classe `BTree` può essere utilizzata per creare un albero binario, aggiungere valori, eseguire ricerche, ottenere i figli di un nodo e verificare l'esistenza del padre di un nodo. Inoltre, è possibile ottenere una lista di valori attraversando l'albero in preordine.

```java
public class Main {
    public static void main(String[] args) {
        BTree binaryTree = new BTree();

        // ... (aggiunta di valori all'albero)

        // Esempio di utilizzo dei metodi
        System.out.println("PreOrder: " + binaryTree.preOrder());

        int searchValue = 3;
        int searchResult = binaryTree.search(searchValue);
        // ... (altre operazioni)

        int nodeValue = 2;
        int leftChild = binaryTree.leftChild(nodeValue);
        int rightChild = binaryTree.rightChild(nodeValue);
        // ... (altre operazioni)

        int parentNodeValue = 5;
        boolean fatherExists = binaryTree.fatherExist(parentNodeValue);
        // ... (altre operazioni)
    }
}
```

### Conclusioni
La classe `BTree` fornisce una rappresentazione base di un albero binario e offre funzionalità per la gestione dei nodi, la ricerca e l'attraversamento.