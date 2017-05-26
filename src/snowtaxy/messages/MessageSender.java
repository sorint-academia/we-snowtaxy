package snowtaxy.messages;

public interface MessageSender<T>
{

	void send(T utente);

	void close();

}