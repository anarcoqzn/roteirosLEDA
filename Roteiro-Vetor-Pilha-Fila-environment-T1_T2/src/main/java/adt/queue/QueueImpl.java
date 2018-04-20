package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
		
	
	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		//TODO Implement your code here
		if(isEmpty()){
			return null;
		}
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		//TODO Implement your code here
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		//TODO Implement your code here
		return tail == array.length-1;
	}
	
	private void shiftLeft(){
		//TODO Implement your code here
		for(int i = 0; i < tail-1; i++){
			array[i] = array[i+1];
		}
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		//TODO Implement your code here
		if(isFull()){
			throw new QueueOverflowException();		
		}
		this.tail++;
		array[tail] = element;
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		//TODO Implement your code here
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		
		T element = head();
		shiftLeft();
		return element;
	}
}
