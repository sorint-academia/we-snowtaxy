package snowtaxy;

public class SemicolonSeparatedTransformer implements Transformer {

    @Override
    public String transform(Utente utente) {
        return utente.getNome() + ";" + utente.getCognome() + ";" + utente.getRuolo() + ";";
    }

    @Override
    public Utente inverseTransform(String linea) {
        String nome, cognome, ruolo;

        nome = linea.substring(0, linea.indexOf(";"));
        linea = linea.substring(nome.length() + 1, linea.length());
        cognome = linea.substring(0, linea.indexOf(";"));
        linea = linea.substring(cognome.length() + 1, linea.length());
        ruolo = linea.substring(0, linea.indexOf(";"));
        if (ruolo.equals("DEV")) {
            return (new Utente(nome, cognome, ruolo));
        } else {
            return null;
        }
    }
}
