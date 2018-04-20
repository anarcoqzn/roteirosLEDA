package adt.stack;

import adt.linkedList.DoubleLinkedList;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {
	
	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackDoubleLinkedListImpl(int size) {
		//TODO adjust your constructor
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		// TODO Auto-generated method stub

	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
