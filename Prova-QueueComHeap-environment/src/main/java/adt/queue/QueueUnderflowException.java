package adt.queue;

@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Fila vazia");
	}

}
