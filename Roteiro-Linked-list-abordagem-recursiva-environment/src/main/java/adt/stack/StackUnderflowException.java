package adt.stack;

@SuppressWarnings("serial")
public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("Stack is empty");
	}
}
