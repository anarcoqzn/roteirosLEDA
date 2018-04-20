package adt.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe contendo metodos para inversao de palavras e encontrar menor caracter ignorando repeticoes
 * 
 * @author Adalberto
 *
 */
public class WordManipulator {
	private StackImpl<Character> caracteres;
	
	/**
	 * Metodo para inverter cada palavra de uma frase. Isso significa que cada 
	 * palavra tera suas letras invertidas (como palindrome), mas a ordem
	 * em que as palavras aparecem na string original serah preservada. 
	 * 
	 * Exemplo: a inversao da frase "ESTA QUESTAO E MUITO FACIL"
	 * resulta em "ATSE OATSEUQ E OTIUM LICAF"
	 * 
	 * Na frase original pode existir mais de um espaco separando as palavras.
	 * No resultado existe apenas UM espaco separando as palavras.
	 * 
	 * Na frase original pode existir espaco antes da primeira palavra e depois da 
	 * ultima palavra. No resultado esses espacos nao aparecem.
	 * 
	 * Voce deve usar uma instancia de sua implementacao de pilha (StackImpl) e seu algoritmo 
	 * NAO pode usar nenhum metodo da classe String exceto charAt(int).
	 * 
	 * @param phrase a frase a ser tratada/invertida.
	 * @return
	 */
	public String invert(String phrase){
		
		if(phrase == null){
			return null;
		}
		
		String saida = "";
		this.caracteres = new StackImpl<Character>(phrase.length()); // Campelo autorizou o uso do metodo length()
		
		for(int i = 0; i < phrase.length(); i++){
			try {
				if((i == 0 || i == phrase.length()-1) && phrase.charAt(i) == 32){
					
				}else{
					if(i != 0 && i != phrase.length()-1 && phrase.charAt(i) == 32){
						if(phrase.charAt(i+1) == 32){
							i = i + 1;
						}
					}
					caracteres.push(phrase.charAt(i));
				}
			
			} catch (StackOverflowException e) {
				
			}
		}
		
		while(!caracteres.isEmpty()){
			try {
				saida += caracteres.pop();
			} catch (StackUnderflowException e) {
			}
		}
		return saida;
	}
	
	/**
	 * Metodo que retorna o k-esimo menor caracter (ordem lexicográfica) de uma String, 
	 * ignorando as ocorrencias repetidas. O valor de k inicia com 1 (para indicar o menor caracter).
	 * Por exemplo: considerando a string "bla cla dla pla". Caso o caracter solicitado esteja fora 
	 * da faixa de caracteres existentes na string, o método deve retornar o caracter ponto '.'.
	 * Dessa forma, getChar(1) = ' ', getChar(2) = 'a', getChar(3)='b', getChar(4)='c', 
	 * getChar(5)='d', getChar(6)='l', getChar(7)='p', getChar(8) em diante retornam '.'.
	 * 
	 * @param k
	 * @return
	 */
	
	public Character getChar(String string, int k){
		ArrayList<Character> letras = new ArrayList<Character>();
		
		Comparator<Character> comparador = new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return o1.compareTo(o2);
			}
		};
		
		for(int i = 0;i < string.length(); i++){
			if(!letras.contains(string.charAt(i))){
				letras.add(string.charAt(i));
			}
		}
		
		Collections.sort(letras, comparador);
		String p= "."; 
		
		if(k-1 >= letras.size() || k-1 < 0){
			return p.charAt(0);
		}else{
			return letras.get(k-1);
		}
	}
}
