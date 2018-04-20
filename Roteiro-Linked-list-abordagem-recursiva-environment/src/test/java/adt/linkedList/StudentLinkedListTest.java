package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {
	
	private LinkedList<Integer> lista1;
	private LinkedList<Integer> lista2;
	
	@Before
	public void setUp() throws Exception {
		
		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);
		
	}
	
	private void getImplementations(){
		lista1 = new RecursiveSingleLinkedListImpl<Integer>();
		lista2 = new RecursiveSingleLinkedListImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(false, lista1.isEmpty());
		Assert.assertEquals(true, lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertEquals(1, (int) lista1.search(1));
		Assert.assertEquals(2, (int) lista1.search(2));
		Assert.assertEquals(3, (int) lista1.search(3));
		
		Assert.assertEquals(null, lista1.search(null));
		Assert.assertEquals(null, lista2.search(null));
		
		Assert.assertEquals(null, lista2.search(1));
		
	}

	@Test
	public void testInsert() {
		lista1.insert(34);
		Assert.assertTrue(lista1.search(34).equals(34));
		
		lista2.insert(87);
		Assert.assertTrue(lista2.search(87).equals(87));
	}
	
	@Test
	public void testInsertNullValue(){
		RecursiveSingleLinkedListImpl<Integer> umaLista = new RecursiveSingleLinkedListImpl<Integer>();
		
		umaLista.insert(null);
		umaLista.insert(null);
		umaLista.insert(null);
		Assert.assertEquals(0, umaLista.size());
		
		umaLista.insert(1);
		umaLista.insert(2);
		Assert.assertEquals(2, umaLista.size());
		
		umaLista.insert(null);
		umaLista.insert(null);
		umaLista.insert(null);
		Assert.assertEquals(2, umaLista.size());
	}

	@Test
	public void testRemove() {
		lista1.remove(1);
		lista1.remove(2);
		
		Assert.assertNull(lista1.search(1));
		
	}
	
	@Test
	public void testRemoveNullValue(){
		RecursiveSingleLinkedListImpl<Integer> umaLista = new RecursiveSingleLinkedListImpl<Integer>();
		
		Assert.assertEquals(0, umaLista.size());
		umaLista.remove(null);
		Assert.assertEquals(0, umaLista.size());
		
		
		umaLista.insert(1);
		umaLista.insert(2);
		Assert.assertEquals(2, umaLista.size());
		
		umaLista.remove(2);
		Assert.assertEquals(1, umaLista.size());
		
		umaLista.remove(null);
		Assert.assertEquals(1, umaLista.size());
	}

	@Test
	public void testToArray() {
		RecursiveSingleLinkedListImpl<Integer> lista = new RecursiveSingleLinkedListImpl<Integer>();
		lista.insert(3);
		lista.insert(2);
		lista.insert(1);
		Integer[] array = new Integer[]{3, 2, 1};
		Integer[] outroArray = lista.toArray();
		Assert.assertArrayEquals(array, outroArray);
	}
}