package snowtaxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput<T> implements Input<T> {
    private final File fileOrigine;
    private final BufferedReader br;
    
    private final Transformer<String, T> transformer;
    
    public FileInput(String fileName, Transformer<String, T> transformer) throws FileNotFoundException {
        fileOrigine = new File(fileName);
        br = new BufferedReader(new FileReader(fileOrigine));
        
        this.transformer = transformer;
    }
    
    @Override
    public T read() throws IOException {
        String line = br.readLine();
        return line != null ? transformer.transform(line) : null;
    }
    
    @Override
    public void close() throws IOException {
        br.close();
    }
}
