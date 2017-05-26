package snowtaxy.messages;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue<T> implements MessageSender<T>, MessageReceiver<T>
{
	private final BlockingQueue<Message<T>> queue = new LinkedBlockingQueue<>();

	@Override
	public void send(T t)
	{
		try
		{
			queue.put(new Message<>(t));
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void close()
	{
		try
		{
			queue.put((Message<T>) Message.EOT);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public T receive()
	{
		try
		{
			return queue.take().getPayload();
		} catch (InterruptedException e)
		{
			return null;
		}
	}
}