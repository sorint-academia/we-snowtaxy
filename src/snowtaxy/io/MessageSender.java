package snowtaxy.io;

import snowtaxy.Utente;

public interface MessageSender
{

	void send(Utente utente);

	void close();

}