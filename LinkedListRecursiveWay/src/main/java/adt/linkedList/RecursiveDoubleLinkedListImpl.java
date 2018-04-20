package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	
	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next, RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {
		if(element != null){
			if(isEmpty()){
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>());
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			}else{
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>(getData(), getNext(), this);
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(newNode);
				setData(element);
				setNext(newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			if(getNext().isEmpty()){
				setData(null);
				setNext(null);
				setPrevious(null);
			}else{
				setData(getNext().getData());
				((RecursiveDoubleLinkedListImpl<T>) getNext().getNext()).setPrevious(this);
				setNext(getNext().getNext());
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(getNext().isEmpty()){
				setData(null);
				setNext(null);
				setPrevious(null);
			}else{
				((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
			}
		}
	}
	
	@Override
	public void insert(T element){
		if(element != null){
			if(isEmpty()){
				RecursiveDoubleLinkedListImpl<T> NIL = new RecursiveDoubleLinkedListImpl<T>();
				setData(element);
				setNext(NIL);
				NIL.setPrevious(this);
				if(getPrevious() == null){
					NIL = new RecursiveDoubleLinkedListImpl<T>();
					NIL.setNext(this);
					setPrevious(NIL);
				}
			}else{
				getNext().insert(element);
			}
		}
	}
	
	@Override
	public void remove(T element){
		if(element != null){
			if(!isEmpty()){
				if(getData() == element){
					removeFirst();
				}else{
					getNext().remove(element);
				}
			}
		}
	}
	
	// GETTERS N SETTERS
	
	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
	
	public T getLast(){
		if(!isEmpty()){
			if(getNext().isEmpty()){
				return this.getData();
			}
		}
		return ((RecursiveDoubleLinkedListImpl<T>) getNext()).getLast();
	}
}
