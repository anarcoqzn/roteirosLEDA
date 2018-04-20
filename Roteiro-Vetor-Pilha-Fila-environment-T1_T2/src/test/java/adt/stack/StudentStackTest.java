package adt.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException{
		stack1 = new StackImpl<Integer>(6);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		
		stack2 = new StackImpl<Integer>(2);
		stack2.push(1);
		stack2.push(2);
		
		stack3 = new StackImpl<Integer>(6);
	}
	
	//MÉTODOS DE TESTE
	@Test
	public void testTop() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testIsEmpty() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testIsFull() {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testPush() {
		Assert.fail("Not implemented!");
	}
	
	@Test(expected=StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		Assert.fail("Not implemented!");
	}

	@Test
	public void testPop() {
		Assert.fail("Not implemented!");
	}
	
	@Test(expected=StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		Assert.fail("Not implemented!");
	}
}