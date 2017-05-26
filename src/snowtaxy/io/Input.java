package snowtaxy.io;

import snowtaxy.Utente;
import snowtaxy.messages.MessageSender;

public abstract class Input extends Thread implements AutoCloseable
{
	private final MessageSender<Utente> messageQueue;

	public Input(MessageSender<Utente> messageQueue)
	{
		this.messageQueue = messageQueue;
	}

	protected abstract Utente read() throws InputReadException;

	public abstract void close() throws InputReadException;

	@Override
	public void run()
	{
		Utente utente;
		try
		{
			while ((utente = read()) != null)
			{
				messageQueue.send(utente);
			}

			messageQueue.close();

		} catch (InputReadException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				close();
			} catch (InputReadException e)
			{
				e.printStackTrace();
			}
		}
	}
}
