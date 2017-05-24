package snowtaxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput implements Input {
    private final File fileOrigine;
    private final BufferedReader br;
    
    private final Transformer transformer;
    
    public FileInput(String fileName, Transformer transformer) throws FileNotFoundException {
        fileOrigine = new File(fileName);
        br = new BufferedReader(new FileReader(fileOrigine));
        
        this.transformer = transformer;
    }
    
    @Override
    public Utente readUtente() throws IOException {
        String line = br.readLine();
        return line != null ? transformer.inverseTransform(line) : null;
    }
    
    @Override
    public void close() throws IOException {
        br.close();
    }
}
