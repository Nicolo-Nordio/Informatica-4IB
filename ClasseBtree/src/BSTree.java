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