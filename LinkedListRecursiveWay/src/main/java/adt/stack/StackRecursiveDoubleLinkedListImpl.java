package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		list = new RecursiveDoubleLinkedListImpl<T>();
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		if(element != null){
			if(isFull()){
				throw new StackOverflowException();
			}else{
				list.insert(element);
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		
		T temp = ((RecursiveDoubleLinkedListImpl<T>) list).getLast();
		list.removeLast();
		return temp;
	}

	@Override
	public T top() {
		return ((RecursiveDoubleLinkedListImpl<T>) list).getLast();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}

}
