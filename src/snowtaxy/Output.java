package snowtaxy;

import java.io.Closeable;
import java.io.IOException;

public interface Output extends Closeable {

    void writeUtente(Utente utente) throws IOException;
}