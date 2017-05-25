package snowtaxy;

public interface Output extends AutoCloseable
{
	void write(Utente utente) throws OutputWriteException;

	void close() throws OutputWriteException;
}