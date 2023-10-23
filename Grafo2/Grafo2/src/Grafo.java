public class Grafo {

    private Arco[] archi;


    public Grafo() {
        archi = new Arco[25];
    }


    // arcoP = nodo di partenza.
    // arcoA = nodo di arrivo.
    public void insert(int arcoP, int arcoA, boolean presenza) {
        Arco A = new Arco(arcoP, arcoA, presenza);
        A.next = null;

        if (archi[0] == null) {
            archi[0] = A;
        } else {
            Arco last = archi[0];
            while (last.next != null) {
                last = last.next;
            }
            last.next = A;
        }
    }


    public String getArchi() {
        String s = "ARCHI:\n";
        if (archi[0] == null) {
            s += "NON CI SONO ARCHI.";
            return s;
        } else {
            Arco arco = archi[0];
            while (arco != null) {
                s += "(" + arco.data1 + ";" + arco.data2 + ") = ";

                if (arco.presenza) {
                    s += "1\n";
                } else {
                    s += "0\n";
                }
                arco = arco.next;
            }
            return s;
        }
    }


    static class Arco {
        int data1;
        int data2;
        boolean presenza;
        Arco next;

        public Arco (int d1, int d2, boolean p) {
            this.data1 = d1;
            this.data2 = d2;
            this.presenza = p;
        }
    }

}
