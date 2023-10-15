import java.io.*;

class FileTesto {
    private String nomeFile;
    private BufferedWriter writer;
    private BufferedReader reader;
    private int peso;

    public FileTesto(String nomeFile, int peso) throws IOException {
        this.nomeFile = nomeFile;
        this.writer = new BufferedWriter(new FileWriter(nomeFile));
        this.reader = new BufferedReader(new FileReader(nomeFile));
        this.peso = peso;
    }

    public int getPeso() {
        return this.peso;
    }

    public String read() throws IOException {
        String contenuto = "";
        String linea;

        while ((linea = reader.readLine()) != null) {
            contenuto += linea + "\n";
        }
        return contenuto;
    }

    public void write(String testo) throws IOException {
        writer.write(testo);
        writer.newLine();
        writer.flush();
    }

    public void close() throws IOException{
        writer.close();
        reader.close();
    }
}