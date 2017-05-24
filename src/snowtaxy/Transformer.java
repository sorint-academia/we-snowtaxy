package snowtaxy;

public interface Transformer<From, To> {

    To transform(From from);
}
