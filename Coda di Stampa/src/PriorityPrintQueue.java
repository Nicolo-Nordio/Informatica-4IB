import java.io.IOException;

public class PriorityPrintQueue {
    private Node head;

    public static class Node {
        private FileTesto value;
        private Node next;

        Node(FileTesto value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            try {
                return value.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    PriorityPrintQueue() {
        this.head = null;
    }

    public void push(FileTesto file) {
        Node newNode = new Node(file);
        if (head == null) {
            head = newNode;
        } else if(file.getPeso()>head.value.getPeso()) {
                newNode.next=head;
                head = newNode;
        }else{
            Node temp = head;
            while (temp.next!=null&&temp.next.value.getPeso()>file.getPeso()){
                temp=temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public FileTesto pop() {
        if (isEmpty()) {
            System.out.println("La coda è vuota");
        }else{
            Node removedNode = head;
            head = head.next;
            return removedNode.value;
        }
        return null;
    }

    public boolean isEmpty() {return head == null;}
}