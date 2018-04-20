package adt.linkedList;

/**
 * The interface of a generic linked list. 
 */
public interface LinkedList<T> {
	/**
	 * Returns true if the list is empty or false, otherwise.
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements on the list.
	 * @return
	 */
	public int size();
	
	/**
	 * Searches a given element in the list. The search must be sequential from the beginning 
	 * to the end of the list. If the element is not in the list, then it returns null.
	 * @param element
	 * @return
	 */
	public T search(T element);
	
	/**
	 * Inserts a new element at the end of the list.
	 * @param element
	 */
	public void insert(T element);
	
	/**
	 * Removes an element from the list. If the element does not exist the list is not changed.
	 * @param element
	 */
	public void remove(T element);
	
	/**
	 * Returns an array containing all elements in the structure. The array 
	 * does not contain empty spaces (or null elements). The elements are put into the array
	 * from the beginning to the end of the list. 
	 */
	public T[] toArray();
}