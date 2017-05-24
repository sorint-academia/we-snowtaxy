package snowtaxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput<T> implements Output<T> {
    private final File fileDest;
    private final BufferedWriter bw;

    private final Transformer<T, String> transformer;

    public FileOutput(String fileName, Transformer<T, String> transformer) throws IOException {
        fileDest = new File(fileName);
        bw = new BufferedWriter(new FileWriter(fileDest));

        this.transformer = transformer;
    }

    @Override
    public void write(T t) throws IOException {
        bw.write(transformer.transform(t));
        bw.newLine();
    }

    @Override
    public void close() throws IOException {
        bw.close();
    }
}
