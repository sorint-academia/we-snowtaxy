package snowtaxy;

import java.io.Closeable;
import java.io.IOException;

public interface Input extends Closeable {

    Utente readUtente() throws IOException;
}
