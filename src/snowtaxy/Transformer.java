package snowtaxy;

public interface Transformer {

    String transform(Utente utente);
    Utente inverseTransform(String string);
}
