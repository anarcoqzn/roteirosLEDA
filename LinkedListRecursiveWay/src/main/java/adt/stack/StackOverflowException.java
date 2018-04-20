package adt.stack;

@SuppressWarnings("serial")
public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("Stack is full");
	}
	
}
