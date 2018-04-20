package adt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;
import adt.stack.WordManipulator;

public class TestWordManipulator {

	private WordManipulator manipulador;
	
	@Before
	public void setUp() throws Exception {
		manipulador = new WordManipulator();
	}

	@Test
	public void testInvert() throws StackOverflowException {
		String palavra = ("palavra a b c");
		int tamanhoEsperado = palavra.length();
		
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado);
		
		palavra = ("palavra  a b c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado);
		
		palavra = (" palavra a b c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado);
		
		palavra = ("palavra a b c ");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado);
		
		palavra = (" palavra a b c ");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado);
		
		palavra = (" palavra  a  b  c ");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado);
		
		palavra = (" p alavra  a  b  c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado+1);
		
		palavra = (" p a lavra  a  b  c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado+2);
		
		palavra = (" p a l avra  a  b  c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado+3);
		
		palavra = (" p a l a vra  a  b  c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado+4);
		
		palavra = (" p a l a v ra  a  b  c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado+5);
		
		palavra = (" p a l a v r a  a  b  c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado+6);
		
		palavra = (" p  a  l  a  v  r  a  a  b  c");
		assertTrue(manipulador.invert(palavra).length() == tamanhoEsperado+6);
		
		assertNull(manipulador.invert(null));
		
		System.out.println(manipulador.invert("ESTA QUESTAO EH FACIL DEMAIS"));
	}

	@Test
	public void testGetChar() {
		manipulador = new WordManipulator();
		String palavra = ("bla cla dla pla");
		String esperados = " abcdlp";
		
		for(int i = 0; i < esperados.length(); i++){
			assertTrue(manipulador.getChar(palavra, i+1) == esperados.charAt(i));
		}
		esperados = ".";
		assertTrue(manipulador.getChar(palavra, 15) == esperados.charAt(0));
	}
}
