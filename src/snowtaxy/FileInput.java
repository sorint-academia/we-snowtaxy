package snowtaxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class FileInput implements Input {
    private final File fileOrigine;
    private final BufferedReader br;

    public FileInput(String fileName) throws FileNotFoundException {
        fileOrigine = new File(fileName);
        br = new BufferedReader(new FileReader(fileOrigine));
    }

    public static interface LineReader {
        Utente readLine(String input) throws InputReadException;
    }

    private Function<String, Utente> lineReader;

    public void setLineReader(Function<String, Utente> lineReader) {
        this.lineReader = lineReader;
    }

    @Override
    public Utente read() throws InputReadException {
        try {
            String linea = br.readLine();
            if (linea == null) {
                return null;
            }

            return lineReader.apply(linea);

        } catch (IOException e) {
            throw new InputReadException(e);
        }
    }

    @Override
    public void close() throws InputReadException {
        try {
            br.close();
        } catch (IOException e) {
            throw new InputReadException(e);
        }
    }
}
