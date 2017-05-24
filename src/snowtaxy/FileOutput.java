package snowtaxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output {
    private final File fileDest;
    private final BufferedWriter bw;

    private final Transformer transformer;

    public FileOutput(String fileName, Transformer transformer) throws IOException {
        fileDest = new File(fileName);
        bw = new BufferedWriter(new FileWriter(fileDest));

        this.transformer = transformer;
    }

    @Override
    public void writeUtente(Utente utente) throws IOException {
        bw.write(transformer.transform(utente));
        bw.newLine();
    }

    @Override
    public void close() throws IOException {
        bw.close();
    }
}
