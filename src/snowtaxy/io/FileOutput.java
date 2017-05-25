package snowtaxy.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import snowtaxy.Transformer;
import snowtaxy.Utente;

public class FileOutput extends Output
{
	private final File fileDest;
	private final BufferedWriter bw;

	private final Transformer<Utente, String> transformer;

	public FileOutput(String fileName, Transformer<Utente, String> transformer, BlockingQueue<Utente> messageQueue) throws IOException
	{
		super(messageQueue);
		fileDest = new File(fileName);
		bw = new BufferedWriter(new FileWriter(fileDest));

		this.transformer = transformer;
	}

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
