package snowtaxy;

import java.io.Closeable;
import java.io.IOException;

public interface Input<T> extends Closeable {

    T read() throws IOException;
}
