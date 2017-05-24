package snowtaxy;

public class UtenteTransformers {

    public static Transformer<Utente, String> toSemicolonSeparated() {
        return new Transformer<Utente, String>() {

            @Override
            public String transform(Utente utente) {
                return utente.getNome() + ";" + utente.getCognome() + ";" + utente.getRuolo() + ";";
            }
        };
    }

    public static Transformer<String, Utente> fromSemicolonSeparated() {
        return new Transformer<String, Utente>() {

            @Override
            public Utente transform(String linea) {
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
        };
    }
}
