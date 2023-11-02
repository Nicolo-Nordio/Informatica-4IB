import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTree {
    private List<Integer> treeList;

    public BTree() {
        this.treeList = new ArrayList<>();
    }

    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        if (treeList.isEmpty()) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();
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

    public static void main(String[] args) {
        BTree bTree = new BTree();
        bTree.treeList.add(1);
        bTree.treeList.add(2);
        bTree.treeList.add(3);
        bTree.treeList.add(4);
        bTree.treeList.add(5);
        bTree.treeList.add(6);
        bTree.treeList.add(7);
        bTree.treeList.add(8);
        bTree.treeList.add(9);
        bTree.treeList.add(10);
        System.out.println(bTree.preOrder());
    }
}