package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import adt.bst.BSTImpl;
import adt.skipList.fromBST.SkipListFromBSTImpl;

public class TestSkipListFromBST {

	@Test
	public void testImportFromBST() {
		BSTImpl<Integer> treeBST = new BSTImpl<Integer>();
		treeBST.insert(25);
		treeBST.insert(47);
		treeBST.insert(8);
		treeBST.insert(3);
		
		SkipListFromBSTImpl skipListFromBST = new SkipListFromBSTImpl(treeBST.height()+1);
		skipListFromBST.importFromBST(treeBST);
		assertEquals("[<ROOT,3,3>, <0,1>, <1,2>, <2,3>, <3,2>, <NIL,3>]", Arrays.toString(skipListFromBST.toArray()));
	}
	
	@Test
	public void generalTest(){
		BSTImpl<Integer> treeBST = new BSTImpl<Integer>();
		treeBST.insert(5);
		treeBST.insert(2);
		treeBST.insert(7);
		treeBST.insert(1);
		treeBST.insert(3);
		treeBST.insert(6);
		treeBST.insert(8);
		treeBST.insert(0);
		treeBST.insert(4);
		treeBST.insert(9);
		
		SkipListFromBSTImpl skipListFromBST = new SkipListFromBSTImpl(treeBST.height()+1);
		skipListFromBST.importFromBST(treeBST);
		assertEquals("[<ROOT,4,4>, <0,1>, <1,2>, <2,3>, <3,2>, <4,1>, <5,4>, <6,2>, <7,3>, <8,2>, <9,1>, <NIL,4>]", Arrays.toString(skipListFromBST.toArray()));
	}
}
