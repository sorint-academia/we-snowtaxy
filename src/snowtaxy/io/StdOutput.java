package snowtaxy.io;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;

import snowtaxy.Transformer;
import snowtaxy.Utente;

public class StdOutput extends Output
{
	private final PrintStream out;

	private final Transformer<Utente, String> transformer;

	public StdOutput(Transformer<Utente, String> transformer, BlockingQueue<Utente> messageQueue)
	{
		super(messageQueue);
		out = System.out;

		this.transformer = transformer;
	}

	public void write(Utente utente) throws OutputWriteException
	{
		out.println(transformer.transform(utente));
	}

	public void close() throws OutputWriteException
	{
	}
}
