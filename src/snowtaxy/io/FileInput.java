package snowtaxy.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageWriteParam;

import snowtaxy.Transformer;
import snowtaxy.Utente;

public class FileInput implements Input
{
	private final File fileOrigine;
	private final BufferedReader br;

	private final Transformer<String, Utente> transformer;

	public FileInput(String fileName, Transformer<String, Utente> transformer) throws FileNotFoundException
	{
		fileOrigine = new File(fileName);
		br = new BufferedReader(new FileReader(fileOrigine));

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
		try
		{
			br.close();
		} catch (IOException e)
		{
			throw new InputReadException(e);
		}
	}
}
