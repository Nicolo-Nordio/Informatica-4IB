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
            newNode.next = head;
            head = newNode;
        }
        newNode.next = back;
        back = newNode;
    }

    public void pop(FileTesto file) {
        if (isEmpty()) {
            throw new IllegalStateException("la pila è vuota");
        }
        head = head.next;
    }

    public boolean isEmpty() {return head == null;}
}