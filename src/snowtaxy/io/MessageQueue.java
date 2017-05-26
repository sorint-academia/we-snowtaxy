package snowtaxy.io;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import snowtaxy.Utente;

public class MessageQueue implements MessageSender, MessageReceiver {
	private final BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
	
	@Override
	public void send(Utente utente) {
		try
		{
			queue.put(new Message(utente));
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() {
		try
		{
			queue.put(Message.EOT);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public Utente receive() {
		try
		{
			return queue.take().getPayload();
		} catch (InterruptedException e)
		{
			return null;
		}
	}
}