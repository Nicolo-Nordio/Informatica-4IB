public class Grafo {
    Node head;
    public Grafo () {
        head = null;
    }
    public Grafo (int data, String carO, String carV) {
        head = new Node (data, carO, carV);
    }
    public void insert (int data, String carO, String carV) {
        Node node = new Node (data, carO, carV);
        node.next = null;

        // the empty list
        if (head == null) {
            head = node ;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            // the last position
            last.next = node;
        }
    }

    public void pulizia () {
        head = null;
    }



    public String toString () {
        String s = " head -> ";
        if (head == null) {
            s += " null ";
            return s;
        }


        Node node = head;
        while (node.next != null) {
            s += node.data + " (" + node.carV + ";" + node.carO + ") -> ";
            node = node.next;
        }
        s += node.data + " (" + node.carV + ";" + node.carO + ") -> null (Elemento: " + node.carV + ").";
        return s;


        /*
        Node node = head;
        while (node != null) {
            s += node.data + "(" + node.carV + ";" + node.carO + ") -> ";
            node = node.next ;

            if (node == null) {
                s += "Elemento: " + node.carV + ")";
            }
        }
        s +=  " -> null";
        return s;

         */
    }


    static class Node {
        int data;

        // Carattere orrizontale.
        String carO;

        // Carattere verticale.
        String carV;
        Node next;

        Node (int d, String cO, String cV) {
            data = d;

            carO = cO;
            carV = cV;
        }
    }
}
