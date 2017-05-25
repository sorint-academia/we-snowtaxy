package snowtaxy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import snowtaxy.io.Input;
import snowtaxy.io.Output;

public class ReadFile {

    public static void main(String[] args) {
        ComponentFactory componentFactory = new ComponentFactory(args);
        BlockingQueue<Utente> messageQueue = new LinkedBlockingQueue<>();

        try {

            Input input = componentFactory.createInput(messageQueue);
            Output output = componentFactory.createOutput(messageQueue);

        } catch (ComponentCreationException e) {
            e.printStackTrace();
        }
    }
}