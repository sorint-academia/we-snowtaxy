package snowtaxy;

public class Utente {
	String nome, cognome, ruolo;
	
	public Utente(String nome, String cognome, String ruolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}
