package adt.queue;

public class CircularQueue<T> implements Queue<T> {
	
	private T[] array;
	private int tail;
	private int head;
	private int elements;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int size){
		array = (T[])new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(isFull()){
			throw new QueueOverflowException();
		}
		else if(this.tail == this.array.length-1){
			this.tail = 0;
			
		}else{
			this.tail ++;	
		}
		array[tail] = element;
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		head++;
		return array[head-1];
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;	
		}
		return array[head];
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
