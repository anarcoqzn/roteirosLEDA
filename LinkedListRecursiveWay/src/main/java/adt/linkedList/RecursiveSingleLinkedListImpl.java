package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;
	
		
	public RecursiveSingleLinkedListImpl() {
		
	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		if(isEmpty()){
			return 0;
		}
		return 1+next.size();
	}

	@Override
	public T search(T element) {
		if(isEmpty()){
			return null;
		}
		
		else if (data == element){
			return data;
		}
		
		return next.search(element);
	}

	@Override
	public void insert(T element) {
		if(element != null){
			if(isEmpty()){
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			}else{
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null){	
			if(!isEmpty()){
				if(this.data == element){
					setData(next.getData());
					setNext(next.getNext());
				
				}else {
					next.remove(element);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(){
		T[] result = (T[]) new Integer[size()];
		toArray(result, this, 0);
		return result;
	}

	private void toArray(T[] arrayAux, RecursiveSingleLinkedListImpl<T> node, int index) {
		if(!node.isEmpty()){
			arrayAux[index] = node.getData();
			node.toArray(arrayAux, node.getNext(), index+1);
		}
	}
	
	//GETTERS N SETTERS

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
