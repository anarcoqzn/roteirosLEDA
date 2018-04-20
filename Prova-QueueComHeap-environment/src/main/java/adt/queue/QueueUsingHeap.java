package adt.queue;

import adt.heap.GenericHeap;
import adt.heap.MaxHeapImpl;

/**
 * Implementacao de fila usando heap. A ideia é implementar uma fila (com a politica FIFO, respeitando
 * a ordem temporal) usando uma heap como estrutura sobrejacente. Voce deve reutilizar sua implementacao de heap.
 * 
 * Voce nao pode criar nenhum atributo amais na classe!
 *  
 * @author Adalberto
 *
 * @param <T>
 */
public class QueueUsingHeap<T extends Comparable<T>> implements Queue<T> {

	/**
	 * NAO SERA PERMITIDO A CRIACAO DE OUTROS ATRIBUTOS NESTA CLASSE.
	 */
	private int size;
	private GenericHeap<T> heap;
	
	public QueueUsingHeap(int size) {
		heap = new MaxHeapImpl<T>();
		this.size = size;
	}
	
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}else{
			heap.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}else{
			return heap.extractRootElement();
		}
	}

	@Override
	public T head() {
		return heap.rootElement();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public boolean isFull() {
		return heap.toArray().length == size;
	}
}