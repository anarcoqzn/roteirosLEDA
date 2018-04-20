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
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		
		// Lista com 1 elemento.
		lista3.insert(1);
	}
	
	private void getImplementations(){
		//TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = null;
		lista2 = null;
		lista3 = null;
	}

	@Test
	public void testIsEmpty() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testSize() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testSearch() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testInsert() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testRemove() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testToArray() {
		Assert.fail("Not implemented!");
	}
	
	// Métodos de DoubleLinkedList
	
	@Test
	public void testInsertFirst(){
		Assert.fail("Not implemented!");
	}

	@Test
	public void testRemoveFirst(){
		Assert.fail("Not implemented!");
	}
	
	@Test
	public void testRemoveLast(){
		Assert.fail("Not implemented!");
	}
}