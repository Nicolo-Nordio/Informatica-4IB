public class Main {
    public static void main(String[] args) {

        Grafo G = new Grafo();

        int[][] matriceDelleAdiacenze =
                {       {0, 1, 2, 3, 4},
                        {5, 0, 0, 0, 0},
                        {0, 0, 0, 6, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 7, 8}};

        /*
              A  B  C  D  E
        A   {{0, 1, 2, 3, 4},
        B    {5, 0, 0, 0, 0},
        C    {0, 0, 0, 6, 0},
        D    {0, 0, 0, 0, 0},
        E    {0, 0, 0, 7, 8}};
        */


        // 65 = A
        int carattereOrrizontale = 65;
        int carattereVerticale = 65;

        int carAttuale = 0;


        for (int i = 0; i < matriceDelleAdiacenze.length; i++) {
            for (int j = 0; j < matriceDelleAdiacenze[0].length; j++) {
                if (i == carAttuale && matriceDelleAdiacenze[i][j] != 0) {
                    G.insert(matriceDelleAdiacenze[i][j], Character.toString(carattereOrrizontale), Character.toString(carattereVerticale));
                }
                carattereOrrizontale++;
            }
            System.out.println(G.toString());
            G.pulizia();

            carattereOrrizontale = 65;
            carattereVerticale++;
            carAttuale++;
        }

        // System.out.println(G.toString());

        /*
        for (int i = 0; i < matriceDelleAdiacenze.length; i++) {
            for (int j = 0; j < matriceDelleAdiacenze[0].length; j++) {
                if (matriceDelleAdiacenze[i][j] != 0) {
                    G.insert(matriceDelleAdiacenze[i][j], Character.toString(carattereOrrizontale), Character.toString(carattereVerticale));
                }

                carattereOrrizontale++;
            }
            carattereOrrizontale = 65;
            carattereVerticale++;
        }

        System.out.println(G.toString());
        */


    }
}