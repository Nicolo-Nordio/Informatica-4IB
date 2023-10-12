import java.io.IOException;

public class PrintQueue {
    private Node head;
    private Node back;

    public static class Node {
        private FileTesto value;
        private Node next;

        Node(FileTesto value) {
            this.value = value;
            next = null;
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

    PrintQueue() {
        this.head = null;
        this.back = null;
    }

    public void push(FileTesto carattere) {
        Node newNode = new Node(carattere);
        if (head == null) {
            head = newNode;
            back = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
    }

    public FileTesto pop() {
        if (isEmpty()) {
            System.out.println("La coda è vuota");
        }
        Node removedNode = head;
        head = head.next;
        return removedNode.value;
    }

    public boolean isEmpty() {return head == null;}
}