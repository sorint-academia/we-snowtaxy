package snowtaxy;

import java.util.function.Function;

public class UtenteTransformers {

    private static class SeparatedLineReader implements Function<String, Utente> {

        private final String delimiter;

        public SeparatedLineReader() {
            this(";");
        }

        public SeparatedLineReader(String delimiter) {
            this.delimiter = delimiter;
        }

        @Override
        public Utente apply(String linea) {
            String nome, cognome, ruolo;

            nome = linea.substring(0, linea.indexOf(delimiter));
            linea = linea.substring(nome.length() + 1, linea.length());
            cognome = linea.substring(0, linea.indexOf(delimiter));
            linea = linea.substring(cognome.length() + 1, linea.length());
            ruolo = linea.substring(0, linea.indexOf(delimiter));

            return new Utente(nome, cognome, ruolo);
        }

    }

    public static Function<Utente, String> toSemicolonSeparated() {
        return new Function<Utente, String>() {

            @Override
            public String apply(Utente utente) {
                return utente.getNome() + ";" + utente.getCognome() + ";" + utente.getRuolo() + ";";
            }
        };
    }

    public static Function<String, Utente> fromDelimitedInput() {
        return new SeparatedLineReader();
    }

    public static Function<String, Utente> fromDelimitedInput(String delimiter) {
        return new SeparatedLineReader(delimiter);
    }
}
