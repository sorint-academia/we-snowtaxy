package snowtaxy.io;

import java.util.concurrent.BlockingQueue;

import snowtaxy.Utente;

public abstract class Output extends Thread implements AutoCloseable {
    private final BlockingQueue<Utente> messageQueue;

    public Output(BlockingQueue<Utente> messageQueue) {
        this.messageQueue = messageQueue;
        start();
    }

    protected abstract void write(Utente utente) throws OutputWriteException;

    public abstract void close() throws OutputWriteException;

    @Override
    public void run() {
        Utente utente;
        try {
            while ((utente = messageQueue.take()) != null) {
                write(utente);
            }
        } catch (InterruptedException | OutputWriteException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (OutputWriteException e) {
                e.printStackTrace();
            }
        }
    }
}