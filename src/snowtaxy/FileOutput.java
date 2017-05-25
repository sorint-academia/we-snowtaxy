package snowtaxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output
{
	private final File fileDest;
	private final BufferedWriter bw;

	private final Transformer<Utente, String> transformer;

	public FileOutput(String fileName, Transformer<Utente, String> transformer) throws IOException
	{
		fileDest = new File(fileName);
		bw = new BufferedWriter(new FileWriter(fileDest));

		this.transformer = transformer;
	}

	@Override
	public void write(Utente utente) throws OutputWriteException
	{
		try
		{
			bw.write(transformer.transform(utente));
			bw.newLine();
		} catch (IOException e)
		{
			throw new OutputWriteException(e);
		}

	}

	@Override
	public void close() throws OutputWriteException
	{
		try
		{
			bw.close();
		} catch (IOException e)
		{
			throw new OutputWriteException(e);
		}
	}
}
