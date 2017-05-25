package snowtaxy;

public class Utente
{
	private String nome, cognome, ruolo;

	public Utente(String nome, String cognome, String ruolo)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
	}

	public String getNome()
	{
		return nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public String getRuolo()
	{
		return ruolo;
	}
}
