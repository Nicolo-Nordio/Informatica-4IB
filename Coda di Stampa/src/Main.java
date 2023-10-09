import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int casual = random.nextInt(1,6);
        for (int i = 0; i < casual; i++) {
            System.out.print("Inserisci il nome del file: ");
            String nomeFile = scanner.nextLine();

            try {
                FileTesto fileTesto = new FileTesto(nomeFile);

                System.out.print("Inserisci il testo da scrivere nel file: ");
                String testoDaScrivere = scanner.nextLine();

                fileTesto.write(testoDaScrivere);

                String contenuto = fileTesto.read();

                System.out.println("Questo è il contenuto del file:");
                System.out.println(contenuto);

                fileTesto.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}