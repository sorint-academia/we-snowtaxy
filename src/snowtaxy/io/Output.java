package snowtaxy.io;

import snowtaxy.Utente;
import snowtaxy.messages.MessageReceiver;

public abstract class Output extends Thread implements AutoCloseable
{
	private final MessageReceiver<Utente> messageQueue;

	public Output(MessageReceiver<Utente> messageQueue)
	{
		this.messageQueue = messageQueue;
	}

	protected abstract void write(Utente utente) throws OutputWriteException;

	public abstract void close() throws OutputWriteException;

	@Override
	public void run()
	{
		Utente utente;
		try
		{
			while ((utente = messageQueue.receive()) != null)
			{
				write(utente);
			}
		} catch (OutputWriteException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				close();
			} catch (OutputWriteException e)
			{
				e.printStackTrace();
			}
		}
	}
}