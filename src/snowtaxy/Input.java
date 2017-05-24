package snowtaxy;

import java.io.Closeable;
import java.io.IOException;

public interface Input<Utente> extends Closeable {

    Utente read() throws IOException;
    
}
