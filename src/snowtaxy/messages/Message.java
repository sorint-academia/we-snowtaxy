package snowtaxy.messages;

public class Message<T>
{

	public static final Message<?> EOT = new Message<>(null);

	private final T payload;

	public Message(T payload)
	{
		this.payload = payload;
	}

	public T getPayload()
	{
		return payload;
	}
}