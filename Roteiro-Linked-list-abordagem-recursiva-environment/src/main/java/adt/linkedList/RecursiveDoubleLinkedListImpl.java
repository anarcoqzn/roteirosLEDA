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
		RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>();
		newNode.setData(element);
		newNode.setPrevious(this.getPrevious());
		this.getPrevious().setNext(newNode);
		this.setPrevious(newNode);
		newNode.setNext(this);
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented yet!");
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
					if(getPrevious().isEmpty() && getNext().isEmpty()){
						setData(null);
						setPrevious(null);
						setNext(null);
					}else{
						setData(getNext().getData());
						getPrevious().setNext((getNext()));
						((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious((getPrevious()));
					}
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
}
