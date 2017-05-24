package snowtaxy;

public class ReadFile {

    public static void main(String[] args) throws Exception {

        Input<Utente> input = new FileInput<>("file/input.txt", UtenteTransformers.fromSemicolonSeparated());
        Output<Utente> output = new FileOutput<>("file/output.txt", UtenteTransformers.toSemicolonSeparated());
        // bw.write("Nome;Cognome;Ruolo;");
        // bw.newLine();

        try {
            Utente utente;
            while ((utente = input.read()) != null) {
                output.write(utente);
            }
        } finally {
            output.close();
            input.close();
        }

    }

}
