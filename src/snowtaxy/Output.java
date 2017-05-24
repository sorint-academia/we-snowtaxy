package snowtaxy;

import java.io.Closeable;
import java.io.IOException;

public interface Output<T> extends Closeable {

    void write(T t) throws IOException;
}