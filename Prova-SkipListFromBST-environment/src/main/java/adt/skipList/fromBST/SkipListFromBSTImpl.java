package adt.skipList.fromBST;

import adt.bst.BST;
import adt.bst.BSTNode;
import adt.skipList.SkipListImpl;

public class SkipListFromBSTImpl extends SkipListImpl<Integer> implements SkipListFromBST<Integer> {
	
	public SkipListFromBSTImpl(int maxHeight) {
		super(maxHeight);
	}

	public void importFromBST(BST<Integer> bst){
		Integer[] elements = bst.order();
		for(int i = 0; i < elements.length; i++){
			int height = determinateHeightNode(bst, elements[i]);
			if(height > 0){
				insert(i, elements[i], height);
			}
		}
	}
	
	private int determinateHeightNode(BST<Integer> bst, Integer element){
		BSTNode<Integer> node = (BSTNode<Integer>) bst.search(element);
		int height = bst.height() + 1; // a altura da bst eh diferente da altura da skiplist. Por isso o +1.
		if(!node.isEmpty()){
			BSTNode<Integer> outroNo = (BSTNode<Integer>) bst.getRoot();
			
			while(outroNo.getData().compareTo(node.getData()) != 0){
				if(node.getData().compareTo(outroNo.getData()) > 0){
					outroNo = (BSTNode<Integer>) outroNo.getRight();
				}
				else{
					outroNo = (BSTNode<Integer>) outroNo.getLeft();
				}
				height--;
			}
			return height;
		}
		return -1;
	}
}