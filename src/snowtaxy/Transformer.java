package snowtaxy;

public interface Transformer<Utente, String> {

    String transform(Utente utente);
}
