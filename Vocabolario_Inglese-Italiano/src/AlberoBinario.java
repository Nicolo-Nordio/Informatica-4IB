import java.util.ArrayList;

public class AlberoBinario {
    private Node head;

    private ArrayList<Node> vocaboli = new ArrayList<>();
    private int conta;

    public AlberoBinario(){
        head=null;
    }

    public Node getHead(){
        return head;
    }

    public void carica(ArrayList<Node> vocaboli) {
        if (!vocaboli.isEmpty()) {
            head = new Node();
            insert(0, vocaboli.size() - 1, head, vocaboli);
        }
    }

    public void insert(int inizio, int fine, Node current, ArrayList<Node> vocaboli) {
        if (inizio <= fine) {
            int medio = (inizio + fine) / 2;
            Node nodoMedio = vocaboli.get(medio);
            current.setVocaboloIng(nodoMedio.getVocaboloIng());
            current.setVocaboloIta(nodoMedio.getVocaboloIta());

            if (inizio < medio) {
                current.setLeft(new Node());
                insert(inizio, medio - 1, current.getLeft(), vocaboli);
            }

            if (medio < fine) {
                current.setRight(new Node());
                insert(medio + 1, fine, current.getRight(), vocaboli);
            }
        }
    }

    public void visitaArray(ArrayList<Node> vocaboli) {
        this.vocaboli = vocaboli;
        conta = 0;
        visitaArray2(0, vocaboli.size() - 1);
        System.out.println("Numero vocaboli in arrayList = " + conta);
    }

    public void visitaArray2(int inizio, int fine) {
        if (inizio <= fine) {
            int medio = (fine + inizio) / 2;
            Node nodoMedio = vocaboli.get(medio);
            System.out.println("posizione = " + medio + " vocabolo = " + nodoMedio.getVocaboloIng());
            conta++;
            visitaArray2(inizio, medio - 1);
            visitaArray2(medio + 1, fine);
        }
    }


    public String search(String parola, Node current) {
        if (current == null) {
            return null;
        }

        String parolaCorrente = current.getVocaboloIng();

        if (parola.compareTo(parolaCorrente) == 0) {
            return current.getVocaboloIta();
        } else if (parola.compareTo(parolaCorrente) < 0) {
            return search(parola, current.getLeft());
        } else {
            return search(parola, current.getRight());
        }
    }

    public String traduciIng(String parolaIng) {
        return search(parolaIng.toUpperCase(), head);
    }

    public String traduciIta(String parolaIta) {
        return search(parolaIta.toUpperCase(), head);
    }

    public void stampaInOrdine(Node current) {
        if (current != null) {
            stampaInOrdine(current.getLeft());
            System.out.println(current.getVocaboloIng() + ": " + current.getVocaboloIta());
            stampaInOrdine(current.getRight());
        }
    }

    public void stampaAlberoInOrdine() {
        stampaInOrdine(head);
    }

}