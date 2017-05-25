package snowtaxy;

import java.io.Closeable;
import java.io.IOException;

public interface Output extends AutoCloseable
{
	void write(Utente utente) throws OutputWriteException;

	void close() throws OutputWriteException;
}