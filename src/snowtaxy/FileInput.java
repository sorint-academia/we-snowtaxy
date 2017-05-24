package snowtaxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput<Utente> implements Input<Utente> {
    private final File fileOrigine;
    private final BufferedReader br;
    
    private final Transformer<String, Utente> transformer;
    
    public FileInput(String fileName, Transformer<String, Utente> transformer) throws FileNotFoundException {
        fileOrigine = new File(fileName);
        br = new BufferedReader(new FileReader(fileOrigine));
        
        this.transformer = transformer;
    }
    
    @Override
    public Utente read() throws IOException {
        String line = br.readLine();
        return line != null ? transformer.transform(line) : null;
    }
    
    @Override
    public void close() throws IOException {
        br.close();
    }
}
