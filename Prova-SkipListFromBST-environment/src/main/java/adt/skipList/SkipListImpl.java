package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;
	
	protected int height;
	protected int maxHeight;

	//SET THIS VALUE TO TRUE IF YOU ARE IMPLEMENTING MAX_LEVEL = LEVEL
	//SET THIS VALUE TO FALSE IF YOU ARE IMPLEMENTING MAX_LEVEL != LEVEL
	protected boolean USE_MAX_HEIGHT_AS_HEIGHT = true;
	protected double PROBABILITY = 0.5; 
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SkipListImpl(int maxHeight) {
		if(USE_MAX_HEIGHT_AS_HEIGHT){
			this.height = maxHeight;
		}else{
			this.height = 1;
		}
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}
	
	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL
	 * Caso esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com 
	 * level=1 e o metodo deve conectar apenas o forward[0].  
	 */
	private void connectRootToNil(){
	  for (int i = 0; i< height; i++){
		  root.forward[i] = NIL;
	  }
	}
	
	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no metodo
	 * insert(int,V) 
	 */
	private int randomLevel(){
		int randomLevel = 1;
		double random = Math.random();
		while(Math.random() <= PROBABILITY && randomLevel < maxHeight){
			randomLevel = randomLevel + 1;
		}
		return randomLevel;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insert(int key, T newValue) {
		if(newValue != null){
						
			SkipListNode<T>[] update = new SkipListNode[maxHeight];
			SkipListNode<T> aux = root;
			
			for(int i = height-1;i >= 0; i--){
				while(aux.getForward(i).getKey() < key){
					aux = aux.getForward(i);
				}
				update[i] = aux;
			}
			
			aux = aux.getForward(0);
			
			if(aux.getKey() == key){
				aux.setValue(newValue);
			}else{
				int nodeLevel = randomLevel();
				if(nodeLevel > height){
					for(int i = height + 1; i < nodeLevel; i++){
						update[i] = root;
					}
					this.height = nodeLevel;
				}
				aux = new SkipListNode<T>(key, nodeLevel, newValue);
				for(int i = 0; i < nodeLevel;i++){
					aux.forward[i] = update[i].getForward(i);
					update[i].forward[i] = aux;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(int key, T newValue, int height) {
		if(newValue != null && height <= maxHeight){
			SkipListNode<T>[] update = new SkipListNode[maxHeight];
			SkipListNode<T> aux = root;
			
			for(int i = this.height-1;i >= 0; i--){
				while(aux.getForward(i).getKey() < key){
					aux = aux.getForward(i);
				}
				update[i] = aux;
			}
			
			aux = aux.getForward(0);
			
			if(aux.getKey() == key){
				aux.setValue(newValue);
			}else{
				int nodeLevel = height;
				if(nodeLevel > height){
					for(int i = height + 1; i < nodeLevel; i++){
						update[i] = root;
					}
					this.height = nodeLevel;
				}
				aux = new SkipListNode<T>(key, height, newValue);
				for(int i = 0; i < height;i++){
					aux.forward[i] = update[i].getForward(i);
					update[i].forward[i] = aux;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(int key) {
		SkipListNode<T>[] update = new SkipListNode[maxHeight];
		SkipListNode<T> aux = root;
		
		for(int i = this.height-1;i >= 0; i--){
			while(aux.getForward(i).getKey() < key){
				aux = aux.getForward(i);
			}
			update[i] = aux;
		}
		aux = aux.getForward(0);
		
		if(aux.key == key){
			for (int i = 0; i < height; i++){
				if(update[i].getForward(i) != aux){
					break;
				}else{
					update[i].forward[i] = aux.getForward(i);
				}
			}
			while(height > 1  && root.getForward(height-1) == NIL){
				height--;
			}
		}
	}

	@Override
	public int height() {
		return root.height;
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> aux = root;
		for(int i = height-1; i >= 0; i--){
			while(aux.getForward(i).getKey() < key){
				aux = aux.getForward(i);
			}
		}
		aux = aux.getForward(0);
		if(aux.getKey() == key){
			return aux;
		}
		return null;
	}

	@Override
	public int size(){
		SkipListNode<T> aux = root.getForward(0);
		int size = 0;
		while(aux.getValue() != null){
			aux = aux.getForward(0);
			size ++;
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SkipListNode<T>[] toArray() {
		SkipListNode<T>[] resp = new SkipListNode[size() + 2];
		SkipListNode<T> aux = root;
		for (int i = 0; i < resp.length; i++) {
			resp[i] = aux;
			aux = aux.forward[0];
		}
		return resp;
	}

}
