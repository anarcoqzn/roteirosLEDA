package adt.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQueueUsingHeap {
	QueueUsingHeap<Integer> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new QueueUsingHeap<Integer>(5);
		queue.enqueue(5);
		queue.enqueue(7);
		
	}

	@Test
	public void testEnqueue() throws QueueOverflowException {
		assertTrue(5 == queue.head());
		
		queue.enqueue(6);
		assertTrue(5 == queue.head());
		
		queue.enqueue(3);
		assertTrue(5 == queue.head());
		
		queue.enqueue(0);
		assertTrue(5 == queue.head());
	}

	@Test(expected=QueueUnderflowException.class)
	public void testDequeue() throws Exception {
		assertTrue(5 == queue.head());
		
		queue.dequeue();
		assertTrue(7 == queue.head());
		
		
		queue.dequeue();
	}

	@Test
	public void testHead() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFull() {
		fail("Not yet implemented");
	}

}
