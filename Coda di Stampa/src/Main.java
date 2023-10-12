import java.io.*;
import java.util.Random;
public class Main {
    public static void main(String[] args) throws IOException {
        PrintQueue printQueue = new PrintQueue();
        Random random1 = new Random();
        Random random2 = new Random();
        int casual = random1.nextInt(2, 11);
        int nFile = 1;
        for (int i = 0; i < casual; i++) {
            String strcaratteri = "";
            for (int j = 0; j < 10; j++) {
                char charcasual = (char) random2.nextInt(256);
                strcaratteri += charcasual;
            }
            try {
                FileTesto fileTesto = new FileTesto("File" + nFile + ".txt");
                fileTesto.write(strcaratteri + "\n");
                printQueue.push(fileTesto);
                nFile++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileTesto printFile = new FileTesto("Print.txt");
        printFile.write("*****INIZIO*****" + "\n");
        while (!printQueue.isEmpty()) {
            FileTesto fileToPrint = printQueue.pop();
            String contenuto = fileToPrint.read();
            try {
                printFile.write(contenuto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        printFile.write("*****FINE*****");
        printFile.close();
    }
}