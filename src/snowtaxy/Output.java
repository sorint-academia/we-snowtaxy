package snowtaxy;

public class Output {
	public String utenteToString(Utente utente) {
		return utente.getNome() + ";" + utente.getCognome() + ";" + utente.getRuolo() + ";";
	}
}
