import java.util.ArrayList;
import java.util.List;

public class BTree {
    private List<Integer> treeList;

    public BTree() {
        this.treeList = new ArrayList<>();
    }

    public int search(int val) {
        if (treeList.contains(val)) {
            return treeList.indexOf(val);
        } else {
            return -1;
        }
    }

    public int leftChild(int val) {
        int pos = search(val);
        if (pos == -1) {
            return -2;
        }
        int leftPos = 2 * pos + 1;
        if (leftPos < treeList.size() && treeList.get(leftPos) != null) {
            return leftPos;
        } else {
            return -1;
        }
    }

    public int rightChild(int val) {
        int pos = search(val);
        if (pos == -1) {
            return -2;
        }
        int rightPos = 2 * pos + 2;
        if (rightPos < treeList.size() && treeList.get(rightPos) != null) {
            return rightPos;
        } else {
            return -1;
        }
    }

    public int[] preOrder(){
        PriorityQueue pq = new PriorityQueue();
        int i = 0;
        if(i==treeList.size()) {
            for (i = 0; i < treeList.size(); i++) {
                pq.push(treeList.get(i));
            }
        }else{

        }
    }

    public static void main(String[] args) {
        BTree bTree = new BTree();
        bTree.treeList.add(1);
        bTree.treeList.add(2);
        bTree.treeList.add(3);
        bTree.treeList.add(4);
        bTree.treeList.add(5);

        System.out.println(bTree.search(3)); // Output: 2
        System.out.println(bTree.leftChild(3));
        System.out.println(bTree.rightChild(3));
        bTree.preOrder();
    }
}