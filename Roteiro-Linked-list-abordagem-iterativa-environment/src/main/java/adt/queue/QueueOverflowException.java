package adt.queue;

@SuppressWarnings("serial")
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("Fila cheia");
	}

}
