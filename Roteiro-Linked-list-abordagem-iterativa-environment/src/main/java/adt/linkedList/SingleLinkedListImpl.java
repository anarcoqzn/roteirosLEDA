package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if(this.head.isNIL()){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		
		while(!aux.isNIL()){
			size += 1;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		
		while(!(aux.isNIL()) && aux.getData() != element){
			aux = aux.next;
		}

		return aux.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = head;
		if(head.isNIL()){
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element,head);
			head = newNode;
		}else{
		
			while(!aux.next.isNIL()){
				aux = aux.next;
			}
		}
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element,aux.next);
		aux.next = newNode;
	}

	@Override
	public void remove(T element) {
		if(head.data == element){
			head = head.next;
		}else{
			SingleLinkedListNode<T> aux =  head;
			while(!aux.next.isNIL()){
				if(aux.next == element){
					aux = aux.next.next;
				}
				aux = aux.next;
			}
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(){
		T[] result = (T[]) new Integer[size()];
		int cont = 0;
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()){
			result[cont] = aux.getData(); 
			aux = aux.next;
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}	
}
