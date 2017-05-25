package snowtaxy.io;

import java.util.concurrent.BlockingQueue;

import snowtaxy.Transformer;
import snowtaxy.Utente;

public abstract class Input extends Thread implements AutoCloseable {
    private final BlockingQueue<Utente> messageQueue;

    public Input(BlockingQueue<Utente> messageQueue) {
        this.messageQueue = messageQueue;
        start();
    }

	protected abstract Utente read() throws InputReadException;

    public abstract void close() throws InputReadException;

    @Override
    public void run() {
        Utente utente;
        try {
            while ((utente = read()) != null) {
                messageQueue.put(utente);
            }
            
            messageQueue.put(null);
            
        } catch (InterruptedException | InputReadException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (InputReadException e) {
                e.printStackTrace();
            }
        }
    }
}
