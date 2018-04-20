package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest {
	
	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;
	
	@Before
	public void setUp() throws Exception {

		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(1);
		lista1.insert(2);
		lista1.insert(3);

		
		// Lista com 1 elemento.
		lista3.insert(1);
	}
	
	private void getImplementations(){
		lista1 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista2 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista3 = new RecursiveDoubleLinkedListImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(lista2.isEmpty());
		
		Assert.assertFalse(lista3.isEmpty());
		
		lista3.removeLast();
		Assert.assertTrue(lista3.isEmpty());
		
		lista3.insert(1);
		Assert.assertFalse(lista3.isEmpty());
		lista3.removeFirst();
		Assert.assertTrue(lista3.isEmpty());
		lista3.insert(1);
		Assert.assertFalse(lista3.isEmpty());
		lista3.remove(1);
		Assert.assertTrue(lista3.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertTrue(lista1.size() == 3);
		Assert.assertTrue(lista2.size() == 0);
		Assert.assertTrue(lista3.size() == 1);
		
		lista3.removeLast();
		Assert.assertTrue(lista3.size() == 0);
		
		lista3.insert(1);
		lista3.removeFirst();
		Assert.assertTrue(lista3.size() == 0);
		
		lista3.insert(1);
		lista3.remove(1);
		Assert.assertTrue(lista3.size() == 0);
		
		lista3.insertFirst(1);
		Assert.assertTrue(lista3.size() == 1);
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(lista1.search(1) == 1);
		Assert.assertTrue(lista1.search(2) == 2);
		Assert.assertTrue(lista1.search(3) == 3);
		Assert.assertTrue(lista1.search(4) == null);
		
		lista1.removeLast();
		Assert.assertTrue(lista1.search(3) == null);
		
		lista1.removeFirst();
		Assert.assertTrue(lista1.search(1) == null);
		
		Assert.assertTrue(lista2.search(1) == null);
		
		Assert.assertTrue(lista3.search(1) == 1);
	}

	@Test
	public void testInsert() {
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(1);
		Assert.assertTrue(lista2.size() == 1);
		
		lista2.remove(1);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(null);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(1);
		Assert.assertTrue(lista2.size() == 1);
		
		lista2.insert(1);
		Assert.assertTrue(lista2.size() == 2);
	}

	@Test
	public void testRemove() {
		Assert.assertTrue(lista1.size() == 3);
		
		lista1.remove(1);
		Assert.assertTrue(lista1.size() == 2);
		
		lista1.remove(10);
		Assert.assertTrue(lista1.size() == 2);
		
		lista1.remove(null);
		Assert.assertTrue(lista1.size() == 2);
		
		lista1.remove(2);
		Assert.assertTrue(lista1.size() == 1);
		
		lista1.remove(3);
		Assert.assertTrue(lista1.size() == 0);
		
		//#---------------------------------------------------
		
		RecursiveDoubleLinkedListImpl<Integer> list = new RecursiveDoubleLinkedListImpl<Integer>();
		Assert.assertTrue(list.size() == 0);
		
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		Integer[] array = new Integer[]{0,1,2,3};
		Assert.assertTrue( list.size() == 4 );
		Assert.assertArrayEquals(array, list.toArray());
		
		list.remove(2);
		array = new Integer[]{0,1,3};
		Assert.assertTrue( list.size() == 3 );
		Assert.assertArrayEquals(array, list.toArray());
		
		list.remove(1);
		array = new Integer[]{0,3};
		Assert.assertTrue( list.size() == 2 );
		Assert.assertArrayEquals(array, list.toArray());
		
		list.remove(0);
		array = new Integer[]{3};
		Assert.assertTrue( list.size() == 1 );
		Assert.assertArrayEquals(array, list.toArray());
		
		list.remove(2);
		array = new Integer[]{3};
		Assert.assertTrue( list.size() == 1 );
		Assert.assertArrayEquals(array, list.toArray());
		
		list.remove(3);
		array = new Integer[]{};
		Assert.assertTrue( list.size() == 0 );
		Assert.assertArrayEquals(array, list.toArray());
		
		list.remove(2);
		array = new Integer[]{};
		Assert.assertTrue( list.size() == 0 );
		Assert.assertArrayEquals(array, list.toArray());
		
		list.remove(null);
		array = new Integer[]{};
		Assert.assertTrue( list.size() == 0 );
		Assert.assertArrayEquals(array, list.toArray());
		
	}

	@Test
	public void testToArray() {
		RecursiveDoubleLinkedListImpl<Integer> list = new RecursiveDoubleLinkedListImpl<Integer>();
		Integer[] array = new Integer[]{};
		
		Assert.assertArrayEquals(array, list.toArray());
		
		array = new Integer[]{1};
		list.insert(1);
		Assert.assertArrayEquals(array, list.toArray());
		
		array = new Integer[]{1,2};
		list.insert(2);
		Assert.assertArrayEquals(array, list.toArray());
		
		array = new Integer[]{1,2,3};
		list.insert(3);
		Assert.assertArrayEquals(array, list.toArray());
		
		array = new Integer[]{4,1,2,3};
		list.insertFirst(4);
		Assert.assertArrayEquals(array, list.toArray());
	}
	
	// Métodos de DoubleLinkedList
	
	@Test
	public void testInsertFirst(){

		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insertFirst(1);
		Assert.assertTrue(lista2.size() == 1);
		
		lista2.remove(1);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insertFirst(null);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insertFirst(1);
		Assert.assertTrue(lista2.size() == 1);
				
		lista2.insertFirst(0);
		Assert.assertTrue(lista2.size() == 2);
		
		//#---------------------------------------------------
		
		RecursiveDoubleLinkedListImpl<Integer> list = new RecursiveDoubleLinkedListImpl<Integer>();
		
		Assert.assertTrue(list.size() == 0);
		
		list.insertFirst(0);
		Assert.assertTrue(list.getData() == 0);
		
		list.insertFirst(1);
		Assert.assertTrue(list.getNext().getData() == 0);
		Assert.assertTrue(list.getData() == 1);
		
		list.insertFirst(2);
		Assert.assertTrue(list.getData() == 2);
		Assert.assertTrue(list.size() == 3);
		
	}

	@Test
	public void testRemoveFirst(){

		RecursiveDoubleLinkedListImpl<Integer> list = new RecursiveDoubleLinkedListImpl<Integer>();
		Integer[] array = new Integer[]{2, 1, 0};
		Assert.assertTrue(list.size() == 0);
		
		list.insertFirst(0);
		list.insertFirst(1);
		list.insertFirst(2);
		
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 3);
		
		list.removeFirst();
		array = new Integer[]{1, 0};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 2);
		
		list.removeFirst();
		
		array = new Integer[]{0};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 1);
		
		list.removeFirst();
		
		array = new Integer[]{};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 0);
		
		list.removeLast();
		
		array = new Integer[]{};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 0);
		
	}
	
	@Test
	public void testRemoveLast(){

		RecursiveDoubleLinkedListImpl<Integer> list = new RecursiveDoubleLinkedListImpl<Integer>();
		Integer[] array = new Integer[]{2, 1, 0};
		Assert.assertTrue(list.size() == 0);
		
		list.insertFirst(0);
		list.insertFirst(1);
		list.insertFirst(2);
		
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 3);
		
		list.removeLast();
		array = new Integer[]{2, 1};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 2);
		
		list.removeLast();
		
		array = new Integer[]{2};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 1);
		
		list.removeLast();
		
		array = new Integer[]{};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 0);
		
		list.removeLast();
		
		array = new Integer[]{};
		Assert.assertArrayEquals(array, list.toArray());
		Assert.assertTrue(list.size() == 0);
		
	}
}