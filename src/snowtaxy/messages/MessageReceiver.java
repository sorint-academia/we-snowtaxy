package snowtaxy.messages;

public interface MessageReceiver<T>
{

	T receive();

}