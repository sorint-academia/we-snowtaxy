package snowtaxy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInput implements Input
{
	private final BufferedReader br;

	private final Transformer<String, Utente> transformer;

	public StdInput(Transformer<String, Utente> transformer)
	{
		br = new BufferedReader(new InputStreamReader(System.in));

		this.transformer = transformer;
	}

	@Override
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

	@Override
	public void close() throws InputReadException
	{
	}
}
