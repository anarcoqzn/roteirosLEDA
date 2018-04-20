package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, nil, nil);
		newNode.next = head;
		head = newNode;
		
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

}
