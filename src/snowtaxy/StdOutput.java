package snowtaxy;

import java.io.IOException;
import java.io.PrintStream;

public class StdOutput implements Output
{
	private final PrintStream out;

	private final Transformer<Utente, String> transformer;

	public StdOutput(Transformer<Utente, String> transformer)
	{
		out = System.out;

		this.transformer = transformer;
	}

	@Override
	public void write(Utente utente) throws OutputWriteException
	{
		out.println(transformer.transform(utente));
	}

	@Override
	public void close() throws OutputWriteException
	{
	}
}
