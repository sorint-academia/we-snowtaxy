package snowtaxy.io;

import snowtaxy.Utente;

public class Message {
	
	public static final Message EOT = new Message(null);
	
	private final Utente payload;

	public Message(Utente payload)
	{
		this.payload = payload;
	}
	
	public Utente getPayload()
	{
		return payload;
	}
}