import java.io.*;

class FileTesto {
    private String nomeFile;
    private BufferedWriter writer;
    private BufferedReader reader;

    public FileTesto(String nomeFile) throws IOException {
        this.nomeFile = nomeFile;
        this.writer = new BufferedWriter(new FileWriter(nomeFile));
        this.reader = new BufferedReader(new FileReader(nomeFile));
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

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}