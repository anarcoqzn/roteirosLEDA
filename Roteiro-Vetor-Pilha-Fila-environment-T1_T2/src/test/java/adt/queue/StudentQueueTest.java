package adt.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException{
		queue1 = new CircularQueue<Integer>(6);
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		
		queue2 = new CircularQueue<Integer>(2);
		queue2.enqueue(1);
		queue2.enqueue(2);
		
		queue3 = new CircularQueue<Integer>(6);
	}
	
	//MÉTODOS DE TESTE
	@Test
	public void testHead() {
		Assert.assertTrue(queue1.head().equals(1));
		Assert.assertTrue(queue2.head().equals(1));
		Assert.assertEquals(null, queue3.head());
	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(queue1.isEmpty(), false);
		Assert.assertEquals(queue2.isEmpty(), false);
		Assert.assertEquals(queue3.isEmpty(), true);
	}

	@Test
	public void testIsFull() {
		Assert.assertEquals(queue1.isFull(), false);
		Assert.assertEquals(queue2.isFull(), true);
		Assert.assertEquals(queue3.isFull(), false);
	}

	@Test
	public void testEnqueue() throws QueueOverflowException {
		// nao eh pra dar erro
		
		queue1.enqueue(4);
		queue1.enqueue(5);
		
		queue3.enqueue(1);
		queue3.enqueue(2);
		queue3.enqueue(3);
	}
	
	@Test(expected=QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(4);
	}

	@Test
	public void testDequeue() throws QueueUnderflowException, QueueOverflowException {
		Assert.assertTrue(queue1.dequeue().equals(1));
		Assert.assertTrue(queue2.dequeue().equals(1));
		queue3.enqueue(1);
		Assert.assertTrue(queue3.dequeue().equals(1));
	}
	
	@Test(expected=QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		queue3.dequeue();
	}
}