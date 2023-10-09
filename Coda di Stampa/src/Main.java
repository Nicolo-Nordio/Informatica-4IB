import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int casual = random.nextInt(1,6);
        int nFile = 1;
        for (int i = 0; i < casual; i++) {
            try {
                FileTesto fileTesto = new FileTesto("Print"+nFile);

                fileTesto.write("*****INIZIO*****"+"\n");
                fileTesto.write("Random Character"+"\n");
                fileTesto.write("*****FINE*****");

                String contenuto = fileTesto.read();

                System.out.println("Questo è il contenuto del file:");
                System.out.println(contenuto);

                fileTesto.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            nFile++;
        }
    }
}