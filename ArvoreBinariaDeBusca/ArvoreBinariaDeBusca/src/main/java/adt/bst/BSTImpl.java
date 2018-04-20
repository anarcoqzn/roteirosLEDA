package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected  BSTNode<T> root;
	private int indice;
	private T[] array;
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}
	
	private int height(BSTNode<T> node){
		if(node.isEmpty()){
			return -1;
		}else{
			int alturaRight = height((BSTNode<T>)node.getRight()); 
			int alturaLeft  = height((BSTNode<T>) node.getLeft());
			if(alturaRight > alturaLeft){
				return alturaRight + 1;
			}else{
				return alturaLeft + 1;
			}
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}
	
	private BSTNode<T> search(BSTNode<T> node, T element){
		BSTNode<T> found = new BSTNode<T>();
		if(!(node.isEmpty()) && (element != null)){
			if(element.compareTo(node.getData()) == 0){
				return node;
			}
			if(element.compareTo(node.getData()) > 0){
				return search((BSTNode<T>)node.getRight(), element);
			}else{
				return search((BSTNode<T>)node.getLeft(), element);
			}
		}
		return found;
	}

	@Override
	public void insert(T element) {
		insert(root, element);
	}
	
	private void insert(BSTNode<T> node,T element){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		}else if(element.compareTo(node.getData()) > 0){
			insert((BSTNode<T>) node.getRight(), element);
		}else{
			insert((BSTNode<T>) node.getLeft(), element);
		}
	}
	@Override
	public BSTNode<T> maximum() {
		return maximum(root);
	}
	
	private BSTNode<T> maximum(BSTNode<T> node){
		if(!node.isEmpty()){
			if(node.getRight().isEmpty()){
				return node;
			}else{
				return maximum((BSTNode<T>) node.getRight());
			}
		}else{
			return null;
		}
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(root);
	}
	
	private BSTNode<T> minimum(BSTNode<T> node){
		if(!node.isEmpty()){
			if(node.getLeft().isEmpty()){
				return node;
			}else{
				return minimum((BSTNode<T>) node.getLeft());
			}
		}else{
			return null;
		}
	}
	@Override
	public BSTNode<T> sucessor(T element){
		return sucessor(search(element));
	}

	private BSTNode<T> sucessor(BSTNode<T> aux1) {
		if(aux1 == maximum()){
			return null;
		}
		else if(aux1.isEmpty() || aux1 == null){
			return null;
		}else if(!(aux1.getRight().isEmpty())){
			return minimum((BSTNode<T>) aux1.getRight());
		}else{
			BSTNode<T> aux = (BSTNode<T>) aux1.getParent();
			while(!(aux.isEmpty()) && ((aux1 == aux.getRight()))){
				aux1 = aux;
				aux = (BSTNode<T>) aux.getParent();
			}
			return aux;
		}
	}
	
	@Override
	public BSTNode<T> predecessor(T element){
		return predecessor(search(element));
	}

	private BSTNode<T> predecessor(BSTNode<T> aux1) {
		if(aux1 == minimum()){
			return null;
		}
		else if(aux1.isEmpty() || aux1 == null){
			return null;
		}else if(!(aux1.getLeft().isEmpty())){
			return maximum((BSTNode<T>)aux1.getLeft());
		}else{
			BSTNode<T> aux = (BSTNode<T>) aux1.getParent();
			while(!(aux.isEmpty()) && ((aux1 == aux.getLeft()))){
				aux1 = aux;
				aux = (BSTNode<T>) aux.getParent();
			}
			return aux;
		}
	}

	@Override
	public void remove(T element) {
		remove(root, element);
	}
	
	private void remove(BSTNode<T> node, T element){
		if(!node.isEmpty() && element != null){
			if(element.compareTo(node.getData()) == 0){
				if(node.getRight().isEmpty() && node.getLeft().isEmpty()){
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
				}else if(node.getRight().isEmpty() && !node.getLeft().isEmpty()){
					BSTNode<T> aux = predecessor(node);
					node.setData(aux.getData());
					remove(aux, aux.getData());	
				}else{
					BSTNode<T> aux = sucessor(node);
					node.setData(aux.getData());
					remove(aux, aux.getData());
				}
			}else if(element.compareTo(node.getData()) > 0){
				remove((BSTNode<T>) node.getRight(), element);
			}else{
				remove((BSTNode<T>) node.getLeft(), element);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		array = (T[]) new Integer[size()];
		preOrder(root);
		indice = 0;
		return array;
	}
	
	private void preOrder(BSTNode<T> node){
		if(!node.isEmpty()){
			addArray(node.getData());
			preOrder((BSTNode<T>)node.getLeft());
			preOrder((BSTNode<T>)node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		array = (T[]) new Integer[size()];
		order(root);
		indice = 0;
		return array;
	}
	
	private void order(BSTNode<T> node){
		if(!node.isEmpty()){
			order((BSTNode<T>)node.getLeft());
			addArray(node.getData());
			order((BSTNode<T>)node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		array = (T[]) new Integer[size()];
		postOrder(root);
		indice = 0;
		return array;
	}
	
	private void postOrder(BSTNode<T> node){
		if(!node.isEmpty()){
			postOrder((BSTNode<T>)node.getLeft());
			postOrder((BSTNode<T>)node.getRight());
			addArray(node.getData());
		}
	}
	
	private T[] addArray(T element){
		array[indice] = element;
		indice++;
		return array;
	}

	/**
	 * This method is already implemented using recursion. You must understand how it work and 
	 * use similar idea with the other methods. 
	 */
	@Override
	public int size() {
		return size(root);
	}
	private int size(BSTNode<T> node){
		int result = 0;
		//base case means doing nothing (return 0)
		if(!node.isEmpty()){ //indusctive case
			result = 1 + size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		return result;
	}
}
