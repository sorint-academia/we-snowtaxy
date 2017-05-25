package snowtaxy;

import java.io.Closeable;
import java.io.IOException;

public interface Input extends AutoCloseable
{

	Utente read() throws InputReadException;

	void close() throws InputReadException;
}
