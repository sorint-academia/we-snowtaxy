package snowtaxy;

public class ReadFile {

    public static void main(String[] args) throws Exception {

        Input input = new FileInput("file/input.txt", new SemicolonSeparatedTransformer());
        Output output = new FileOutput("file/output.txt", new SemicolonSeparatedTransformer());
        // bw.write("Nome;Cognome;Ruolo;");
        // bw.newLine();

        try {
            Utente utente;
            while ((utente = input.readUtente()) != null) {
                output.writeUtente(utente);
            }
        } finally {
            output.close();
            input.close();
        }

    }

}
