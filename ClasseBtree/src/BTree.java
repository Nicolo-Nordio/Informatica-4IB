import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTree {
    protected List<Integer> treeList;

    private int currentIndex;

    public BTree() {
        this.treeList = new ArrayList<>();
    }

    public int search(int val) {
        return treeList.indexOf(val);
    }

    public int leftChild(int val) {
        int index = search(val);
        if (index == -1) {
            return -2; // Valore non presente
        }

        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex < treeList.size() && treeList.get(leftChildIndex) != null) {
            return leftChildIndex;
        } else {
            return -1; // Figlio sinistro non presente
        }
    }

    public int rightChild(int val) {
        int index = search(val);
        if (index == -1) {
            return -2; // Valore non presente
        }

        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex < treeList.size() && treeList.get(rightChildIndex) != null) {
            return rightChildIndex;
        } else {
            return -1; // Figlio destro non presente
        }
    }

    public boolean fatherExist(int val) {
        int index = search(val);
        if (index == -1) {
            return false; // Valore non presente
        }

        return (index - 1) / 2 >= 0; // Verifica che il padre esista
    }

    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        if (treeList.isEmpty()) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            currentIndex = stack.pop();

            // Aggiunge alla lista solo se il nodo corrente non è null
            if (treeList.get(currentIndex) != null) {
                result.add(treeList.get(currentIndex));
            }

            int rightChildIndex = 2 * currentIndex + 2;
            if (rightChildIndex < treeList.size() && treeList.get(rightChildIndex) != null) {
                stack.push(rightChildIndex);
            }

            int leftChildIndex = 2 * currentIndex + 1;
            if (leftChildIndex < treeList.size() && treeList.get(leftChildIndex) != null) {
                stack.push(leftChildIndex);
            }
        }
        return result;
    }
}