import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Grafo G = new Grafo();

        // Generazione di archi casuali:
        Random rnd = new Random();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = rnd.nextInt(1 + 100);

                // Per diminuire la probabilità.
                if (num <= 25) {
                    G.insert(i, j, true);
                }
            }
        }

        System.out.println(G.getArchi());
    }
}