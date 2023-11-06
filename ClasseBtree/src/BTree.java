import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTree {
    protected List<Integer> treeList;

    private int currentIndex;

    public BTree() {
        this.treeList = new ArrayList<>();
    }


    public int search(int val){

    }

    public int leftChild(int val){

        return
    }

    public int rightChild(int val){

        return
    }

    public boolean fatherExist(){
        if((currentIndex-1)/2 == ) {
            return true;
        }
        return false;
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
            result.add(treeList.get(currentIndex));

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