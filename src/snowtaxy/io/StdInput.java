package snowtaxy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import snowtaxy.Transformer;
import snowtaxy.Utente;

public class StdInput extends Input
{
	private final BufferedReader br;

	private final Transformer<String, Utente> transformer;

	public StdInput(Transformer<String, Utente> transformer, MessageSender messageQueue)
	{
		super(messageQueue);
		br = new BufferedReader(new InputStreamReader(System.in));

		this.transformer = transformer;
	}

	public Utente read() throws InputReadException
	{
		try
		{
			String line = br.readLine();
			return line != null ? transformer.transform(line) : null;
		} catch (IOException e)
		{
			throw new InputReadException(e);
		}
	}

	public void close() throws InputReadException
	{
	}
}
