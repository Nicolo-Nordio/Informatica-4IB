import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Node> vocaboli = new ArrayList<>();

        TextFile file = new TextFile("./IngleseItaliano.csv");
        String s = file.readln();
        int numeroVocaboli = 0;
        while (s != null){
            String[] vocabolo = s.split(";");
            Node node = new Node();
            node.setVocaboloIng(vocabolo[0].toUpperCase());
            node.setVocaboloIta(vocabolo[1].toUpperCase());
            vocaboli.add(node);
            numeroVocaboli++;
            s = file.readln();
        }
        file.close();
        System.out.println("Numero vocaboli letti da file = " + numeroVocaboli);

        AlberoBinario albero = new AlberoBinario();
        albero.visitaArray(vocaboli);

        albero.carica(vocaboli);

        albero.stampaAlberoInOrdine();

        String vocaboloIng = "Home";
        String vocaboloIta = albero.traduciIta(vocaboloIng.toUpperCase());
        System.out.println(vocaboloIng + "(inglese) <---> " + vocaboloIta + "(italiano)");

        vocaboloIta = "casa";
        vocaboloIng = albero.traduciIng(vocaboloIta.toUpperCase());
        System.out.println(vocaboloIta + "(italiano) <---> " + vocaboloIng + "(inglese)");
    }
}