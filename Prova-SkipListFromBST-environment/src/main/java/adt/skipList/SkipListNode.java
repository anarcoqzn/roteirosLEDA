package adt.skipList;

public class SkipListNode<T> {

	//a chave do root eh Integer.MIN_VALUE e a do NIL eh Integer.MAX_VALUE
	protected int key;
	protected int height;
	protected T value;
	protected SkipListNode<T>[] forward;
	
	@SuppressWarnings("unchecked")
	public SkipListNode(int key, int height, T satelliteData){
		this.key = key;
		this.height = height;
		this.value = satelliteData;
		this.forward = new SkipListNode[height];
	}
	
		
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public T getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}


	public void setKey(int key) {
		this.key = key;
	}


	@Override
	public String toString(){
		String result = "";
		if(this.key == Integer.MIN_VALUE){
			result = "<ROOT," + this.height + "," + this.countForwardsNotNull() + ">";
		}else if(this.key == Integer.MAX_VALUE){
			result = "<NIL," + this.height + ">";
		}else{
			result = "<" + this.key + "," + this.height + ">";
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if(obj instanceof SkipListNode){
			resp = this.key == ((SkipListNode<T>)obj).key 
					&& this.height == ((SkipListNode<T>)obj).height
					&& this.countForwardsNotNull() == ((SkipListNode<T>)obj).countForwardsNotNull();
		}
		return resp;
	}
	private int countForwardsNotNull(){
		int resp = 0;
		for (int i = 0; i < forward.length; i++) {
			if(forward[i] != null){
				resp++;
			}
		}
		return resp;
	}


	public SkipListNode<T>[] getForward() {
		return forward;
	}
	
	public SkipListNode<T> getForward(int level) {
		return forward[level];
	}


	public int getKey() {
		return key;
	}
}
