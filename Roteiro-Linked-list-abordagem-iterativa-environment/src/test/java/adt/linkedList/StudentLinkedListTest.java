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
		
		lista2.insert(3);
		lista2.insert(2);
		lista2.insert(1);
		
	}
	
	private void getImplementations(){
		lista1 = new SingleLinkedListImpl<Integer>();
		lista2 = new SingleLinkedListImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(false, lista1.isEmpty());
		Assert.assertEquals(false, lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(3, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(lista1.search(1).equals(1));
		Assert.assertTrue(lista1.search(2).equals(2));
		Assert.assertTrue(lista1.search(3).equals(3));
		Assert.assertTrue(lista1.search(1).equals(1));
		Assert.assertTrue(lista1.search(2).equals(2));
		Assert.assertTrue(lista2.search(3).equals(3));
		
		//Assert.assertTrue(lista1.search(null).equals(null)); // consertar para passar neste teste
		
	}

	@Test
	public void testInsert() {
		lista1.insert(34);
		Assert.assertTrue(lista1.search(34).equals(34));
		
		lista2.insert(87);
		Assert.assertTrue(lista2.search(87).equals(87));
	}

	@Test
	public void testRemove() {
		lista1.remove(1);
		lista1.remove(2);
		
		Assert.assertNull(lista1.search(1));
		
	}

	@Test
	public void testToArray() {
		Assert.fail("Not implemented!");
	}
}