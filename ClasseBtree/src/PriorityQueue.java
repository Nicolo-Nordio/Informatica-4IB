import java.io.IOException;

public class PriorityQueue {
    private Node head;

    public static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

    }

    PriorityQueue() {
        this.head = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else if(value>head.value) {
            newNode.next=head;
            head = newNode;
        }else{
            Node temp = head;
            while (temp.next!=null&&temp.next.value>value){
                temp=temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("La coda è vuota");
        }else{
            Node removedNode = head;
            head = head.next;
            return removedNode.value;
        }
        return -1;
    }

    public boolean isEmpty() {return head == null;}
}