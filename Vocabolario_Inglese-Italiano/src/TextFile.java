import java.io.*;

class TextFile {
    private String nomeFile;
    private BufferedWriter writer;
    private BufferedReader reader;

    public TextFile(String nomeFile) throws IOException {
        this.nomeFile = nomeFile;
        this.writer = new BufferedWriter(new FileWriter(nomeFile));
        this.reader = new BufferedReader(new FileReader(nomeFile));
    }

    public String readln() throws IOException {
        return reader.readLine();
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