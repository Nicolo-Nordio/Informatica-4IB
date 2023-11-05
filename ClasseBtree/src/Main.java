public class Main {
    public static void main(String[] args) {
        BTree bTree = new BTree();
        bTree.treeList.add(5);
        bTree.treeList.add(2);
        bTree.treeList.add(4);
        bTree.treeList.add(3);
        bTree.treeList.add(5);
        bTree.treeList.add(6);
        bTree.treeList.add(9);
        bTree.treeList.add(8);
        bTree.treeList.add(10);
        bTree.treeList.add(1);
        System.out.println(bTree.preOrder());
    }
}
