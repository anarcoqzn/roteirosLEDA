package adt.skipList.fromBST;

import adt.bst.BST;
import adt.skipList.SkipList;

/**
 * Uma skip list especifica que pode ser construida a partir de uma BST e possui
 * uma configuracao/topologia proximo a da BST usada em sua construcao.
 * @author Adalberto
 *
 * @param <T>
 */
public interface SkipListFromBST<T extends Comparable<T>> extends SkipList<T> {
	
	/**
	 * Este metodo importa todos os elementos de uma BST em uma skip list 
	 * Cada elemento da BST eh inserido na skip list de forma a respeitar/seguir
	 * a topologia da BST. Assim, cada nivel da skip list corresponde (tem os mesmos 
	 * elementos) do correspondente nivel na BST. Por exemplo, a raiz que esta no nivel 0 
	 * da arvore estara no nivel maximo da skip list. Os filhos 
	 * da raiz estarao no nivel imediatamente abaixo, e assim por diante. 
	 * Assim, eh de se esperar que os nos do nivel mais baixo da arvore tenha altura
	 * 1 na skip list.
	 * 
	 * Restricoes a serem seguidas:
	 *  - Se a skip list nao esta vazia voce precisa remover todos os elementos (resetar)
	 *    antes de importar os elementos da BST. Para isso, a altura da skip list deve corresponder 
	 *    a altura da arvore sempre que se vai fazer uma importacao (considere isso também
	 *    no reset da skip list).
	 *  
	 *  - Voce nao pode modificar sua implementacao de BST e deve mexer apenas na 
	 *    classe SkipListFromBSTImpl.java. A classe SkipList
	 * 
	 * 
	 * Um exemplo gráfico seria:
	 *  considere aseguinte arvore binaria abaixo
	 *                   25
	 *            8              47
	 *      3  
	 *
	 * ao importar os elementos acima em uma skip list ela ficaria:
	 * 
	 * h=3               25
	 * h=2        8      25      47
	 * h=1  3     8      25      47
	 * 
	 * Skip list com altura maxima 3 e nos 3, 8, 25, 47 :
	 * [<ROOT,3,3>, <3,1>, <8,2>, <25,3>, <47,2>, <NIL,3>]
	 * 
	 * @param bst
	 */
	public void importFromBST(BST<T> bst);
}
