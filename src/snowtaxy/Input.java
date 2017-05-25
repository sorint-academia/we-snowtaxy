package snowtaxy;

public interface Input extends AutoCloseable
{

	Utente read() throws InputReadException;

	void close() throws InputReadException;
}
