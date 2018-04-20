package adt.linkedList;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedTest2 {

	private LinkedList<Integer> lista1;

	private LinkedList<Integer> minhaListaVazia;
	private LinkedList<Integer> minhaListaUnitaria;
	private LinkedList<Integer> minhaListaComDoisElementos;
	private LinkedList<Integer> minhaListaElementosIguais;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		minhaListaUnitaria.insert(10);
		
		minhaListaElementosIguais.insert(5);
		minhaListaElementosIguais.insert(5);
		minhaListaElementosIguais.insert(5);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<Integer>();

		minhaListaVazia = new RecursiveDoubleLinkedListImpl<Integer>();
		minhaListaUnitaria = new RecursiveDoubleLinkedListImpl<Integer>();
		minhaListaComDoisElementos = new RecursiveDoubleLinkedListImpl<Integer>();

		minhaListaElementosIguais = new RecursiveDoubleLinkedListImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(minhaListaVazia.isEmpty()); // deve falhar
		
		// Testar a linha abaixo apos receber falha 
		//Assert.assertTrue(minhaListaVazia.isEmpty());
		
		//Assert.fail("Not implemented!");
	}

	@Test
	public void testSize() {
		//Assert.assertEquals(2, lista1.size()); //deve dar falha
		
		// apos dar falha, testar a linha abaixo (deve passar nos testes)
		Assert.assertEquals(3, lista1.size());
		
	}

	@Test
	public void testSearch() {
		Assert.assertNull(minhaListaComDoisElementos.search(9)); // deve falhar
		
		// a partir daqui deve funcionar:
		minhaListaComDoisElementos.insert(9);
		Assert.assertEquals(9, (int)minhaListaComDoisElementos.search(9));
		
		// Assert.fail("Not implemented!");
	}

	@Test
	public void testInsert() {
		// só 'descomentar' a linha abaixo apos saber que o teste da erro
		minhaListaComDoisElementos.insert(7); 
		Assert.assertEquals(7, (int)minhaListaComDoisElementos.search(7));
		
		//Assert.fail("Not implemented!");
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, minhaListaElementosIguais.size());
		minhaListaElementosIguais.remove(5);
		Assert.assertEquals(2, minhaListaElementosIguais.size());
		Assert.assertNotNull(minhaListaElementosIguais.search(5));
		Assert.assertEquals(5, (int)minhaListaElementosIguais.search(5));
		
		minhaListaElementosIguais.remove(5);
		minhaListaElementosIguais.remove(5);
		Assert.assertNull(minhaListaElementosIguais.search(5));
		
		//Assert.fail("Not implemented!");
	}

	@Test
	public void testToArray() {
		// int[] array = new int[] {3, 2, 1}; Porque nao da certo?
		
		//Assert.assertNotEquals(array, lista1.toArray()); // deve falhar
		
		// apos falhar, a linha abaixo deve passar nos testes
		Assert.assertEquals("[3, 2, 1]",  Arrays.toString(lista1.toArray()));
		
		//Assert.fail("Not implemented!");
	}
}