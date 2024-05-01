import java.io.*;
import java.util.Random;
public class Main {
    public static void main(String[] args) throws IOException {
        PriorityPrintQueue printQueue = new PriorityPrintQueue();
        Random random = new Random();
        int casual = random.nextInt(2, 11);
        int nFile = 1;
        for (int i = 0; i < casual; i++) {
            String strcaratteri = "";
            int peso = random.nextInt(1,11);
            for (int j = 0; j < peso; j++) {
                char charcasual = (char) random.nextInt(256);
                strcaratteri += charcasual;
            }
            try {
                FileTesto fileTesto = new FileTesto("File" + nFile + ".txt",peso);
                fileTesto.write(strcaratteri);
                printQueue.push(fileTesto);
                nFile++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileTesto printFile = new FileTesto("PriorityPrint.txt",0);
        while (!printQueue.isEmpty()) {

            FileTesto fileToPrint = printQueue.pop();
            printFile.write("***** ["+fileToPrint.getPeso()+"] *****" + "\n");
            String contenuto = fileToPrint.read();
            fileToPrint.close();
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