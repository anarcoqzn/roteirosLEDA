package adt.heap;

import java.util.Arrays;

public class MaxHeapImpl<T extends Comparable<T>> implements MaxHeap<T> {
	
	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	private QueueElement<T>[] heap;
	private int ultimoIndice;
	
	@SuppressWarnings("unchecked")
	public MaxHeapImpl() {
		heap = new QueueElement[INITIAL_SIZE];
		ultimoIndice = -1;
	}
	
	private int parent(int i){
		if(!isEmpty() && i > 0){
			int i1;
			if(i % 2 == 0){
				i1 = (int) Math.floor(i/2) - 1; 
			}else{
				i1 = (int) Math.floor(i/2);
			}
			return i1;
		}
		return -1;
	}
	
	private int left(int i){
		int i1 = -1;
		if(!isEmpty()){
			i1 = 2*i + 1;
			if(i1 <= ultimoIndice && heap[i1] != null){
				return i1;
			}else{
				return -1;
			}
		}
		return i1;
	}

	private int right(int i){
		int i1 = -1;
		if(!isEmpty()){
			i1 = (2*i) + 2; 
			if(i1 <= ultimoIndice && heap[i1] != null){
				return i1;
			}else{
				return -1;
			}
		}
		return i1;
	}

	
	@Override
	public void buildHeap(T[] array){
		for(int i = 0; i < array.length; i++){
			heap[i] = new QueueElement<T>(array[i]);
		}
		ultimoIndice = array.length-1;
		for(int i = (int)Math.floor(array.length/2)+1 ;i >= 0; i--){
			heapify(i);
		}
	}
	
	private void heapify(int position){
		int maior = -1;
		if(!isEmpty() && position >=0 && position <= ultimoIndice){
			int left = left(position);
			int right = right(position);
		
			if(left >= 0 && left <= ultimoIndice && heap[left].compareTo(heap[position]) > 0){
				maior = left;
			}else{
				maior = position;
			}

			if(right >= 0 && right <= ultimoIndice && heap[right].compareTo(heap[maior]) > 0){
				maior = right(position);
			}
			if(maior != position){
				Util.swap(heap, position, maior);
				heapify(maior);
			}
		}
	}
	
	@Override
	public boolean isEmpty(){
		if(ultimoIndice == -1 || ultimoIndice == 0){
			return true;
		}
		return false;
	}
	
	@Override
	public void insert(T element) {
		QueueElement<T> newElement = new QueueElement<T>(element); 
		if(element != null){
			if(isFull()){
				T[] novoHeap = Arrays.copyOf(toArray(), heap.length+INCREASING_FACTOR);
				buildHeap(novoHeap);
			}
			if(ultimoIndice == -1){
				ultimoIndice = 0;
			}
			heap[ultimoIndice] = newElement;
			heapify(parent(ultimoIndice));
			ultimoIndice++;
		}
	}

	@Override
	public T extractRootElement(){
		if(!isEmpty()){
			T temp = heap[0].getData();
			heap[0].setData(heap[ultimoIndice-1].getData());
			heap[0].setTime(heap[ultimoIndice-1].getTime());
			ultimoIndice--;
			heapify(0);
			return temp;
		}
		return null;
	}

	@Override
	public T rootElement() {
		if(!isEmpty()){
			return heap[0].getData();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] heapsort(T[] array) {
		buildHeap(array);
		if(!isEmpty()){	
			T[] copia = toArray().clone();
			for(int i = heap.length - 1; i >= 0; i--){
				copia[i] = extractRootElement();
				heapify(0);
			}
			heap = (QueueElement<T>[]) new Object[0];
			return copia;
		}else{
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		if(isEmpty()){
			return (T[]) new Integer[0];
		}
		T[] arrayRepresentation = (T[]) new Integer[ultimoIndice];
		for(int i = 0; i <= ultimoIndice;i++){
			if(heap[i] != null){
				arrayRepresentation[i] = heap[i].getData();
			}
		}
		return arrayRepresentation;
	}
	
	private boolean isFull(){
		return ultimoIndice == heap.length-1;
	}
}