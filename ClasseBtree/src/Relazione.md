### Introduzione
La classe `BTree` rappresenta un albero binario utilizzando una struttura dati dinamica basata su un `ArrayList` di `Integer`. L'albero è implementato in modo che i nodi siano numerati da sinistra a destra a partire dalla radice, e ogni nodo può avere al massimo due figli. Inoltre, la classe fornisce funzionalità di ricerca, ottenimento dei figli di un nodo, verifica dell'esistenza del padre, e attraversamento in preordine.

La classe `BSTree` estende la classe `BTree` per implementare un albero binario di ricerca (BST), aggiungendo metodi per l'inserimento e la rimozione di valori mantenendo l'ordinamento del BST.

### Struttura della Classe `BTree`
La classe `BTree` è composta dai seguenti membri:

- `treeList`: Un oggetto `ArrayList` di tipo `Integer` che rappresenta l'albero binario.

- `currentIndex`: Un indice che tiene traccia della posizione corrente durante l'attraversamento dell'albero.

Il costruttore della classe inizializza l'elenco `treeList` come un nuovo oggetto `ArrayList`.

```java
public BTree() {
    this.treeList = new ArrayList<>();
}
```

#### Metodi Principali:

- `int search(int val)`: Restituisce l'indice della prima occorrenza del valore specificato nell'albero. Se il valore non è presente, restituisce `-1`.

- `int leftChild(int val)` e `int rightChild(int val)`: Restituiscono l'indice del figlio sinistro e destro di un nodo con il valore specificato. Se il nodo non è presente, restituiscono `-2`. Se il figlio non è presente, restituiscono `-1`.

- `boolean fatherExist(int val)`: Verifica se un nodo con il valore specificato ha un padre. Restituisce `true` se il nodo ha un padre, altrimenti restituisce `false`.

- `List<Integer> preOrder()`: Restituisce una lista di valori ottenuti attraversando l'albero in preordine. Durante l'attraversamento, i nodi null non vengono inclusi.

### Estensione della Classe `BSTree`
La classe `BSTree` estende la classe `BTree` per implementare un albero binario di ricerca (BST).

#### Nuovi Metodi:

- `public BSTree()`: Costruttore che richiama il costruttore della classe madre (`BTree`) utilizzando `super()`.

- `public void insert(int val)`: Aggiunge un nuovo valore al BST mantenendo l'ordinamento.

- `public void del(int val)`: Rimuove un valore specificato dal BST mantenendo l'ordinamento.

```java
public class BSTree extends BTree {
    public BSTree() {
        super();
    }

    public void insert(int val) {
        if (search(val) != -1) {
            return; // Valore già presente
        }

        int currentIndex = treeList.size();
        treeList.add(val);

        while (fatherExist(val) && treeList.get(leftChild(val)) > val) {
            int parentIndex = (currentIndex - 1) / 2;
            treeList.set(currentIndex, treeList.get(parentIndex));
            treeList.set(parentIndex, val);
            currentIndex = parentIndex;
        }
    }

    public void del(int val) {
        if (search(val) == -1) {
            return; // Valore non presente
        }

        int index = search(val);
        treeList.set(index, null);

        int currentIndex = 2 * index + 1;
        while (currentIndex < treeList.size()) {
            int nextIndex = 2 * currentIndex + 1;
            if (nextIndex < treeList.size() && treeList.get(nextIndex) != null) {
                currentIndex = nextIndex;
            } else {
                nextIndex = 2 * currentIndex + 2;
                if (nextIndex < treeList.size() && treeList.get(nextIndex) != null) {
                    currentIndex = nextIndex;
                } else {
                    break;
                }
            }

            treeList.set(currentIndex / 2, treeList.get(currentIndex));
            treeList.set(currentIndex, null);
        }
    }
}
```

### Utilizzo della Classe
Le classi `BTree` e `BSTree` possono essere utilizzate per creare, manipolare e attraversare alberi binari, con la classe `BSTree` che fornisce funzionalità aggiuntive di inserimento e rimozione mantenendo l'ordinamento del BST.

```java
public class Main {
    public static void main(String[] args) {
        BSTree binarySearchTree = new BSTree();

        // ... (aggiunta e rimozione di valori mantenendo l'ordinamento)

        // Esempio di utilizzo dei metodi
        System.out.println("PreOrder: " + binarySearchTree.preOrder());

        int searchValue = 2;
        int searchResult = binarySearchTree.search(searchValue);
        // ... (altre operazioni)

        int nodeValue = 5;
        int leftChild = binarySearchTree.leftChild(nodeValue);
        int rightChild = binarySearchTree.rightChild(nodeValue);
        // ... (altre operazioni)

        int parentNodeValue = 1;
        boolean fatherExists = binarySearchTree.fatherExist(parentNodeValue);
        // ... (altre operazioni)
    }
}
```

### Conclusioni
Le classi `BTree` e `BSTree` forniscono una rappresentazione base di alberi binari, con la classe `BSTree` che estende le funzionalità della classe `BTree` per implementare un albero binario di ricerca (BST) con inserimento e rimozione mantenendo l'ordinamento.