import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Random random1 = new Random();
        Random random2 = new Random();
        int casual = random1.nextInt(1, 6);
        char charcasual = (char) random2.nextInt(0, 255);
        String strcaratteri = "";
        int nFile = 1;
        for (int i = 0; i < casual; i++) {
            try {
                for (int j = 0; j < 10; j++) {
                    strcaratteri += charcasual;
                }

                FileTesto fileTesto = new FileTesto("Print" + nFile + ".txt");
                fileTesto.write("*****INIZIO*****" + "\n");
                fileTesto.write(strcaratteri + "\n");
                fileTesto.write("*****FINE*****");
                printQueue.push(fileTesto);
                fileTesto.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            nFile++;
        }
        /*
        while (!printQueue.isEmpty()){
            String contenuto = printQueue.pop();
            System.out.println("Questo è il contenuto del file:");
            System.out.println(contenuto);
        }
        */
    }
}