package testqueue;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue_singlelinkedlist.FifoQueue;
class TestAppendFIfoQueue {
	private FifoQueue<Integer> myIntQueue;
    private FifoQueue<Integer> mySecondIntQueue;

	@BeforeEach
	void setUp() throws Exception {
		myIntQueue = new FifoQueue<>();
        mySecondIntQueue = new FifoQueue<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		myIntQueue = null;
        mySecondIntQueue = null;
	}

	/** Test if two empty queues throws IllegalArgumentException */
	@Test
	void testAppendEmptyQueues() {
		assertEquals(0, myIntQueue.size(), "Wrong queuesize");
		assertEquals(0, mySecondIntQueue.size(), "Wrong queuesize");

	}
	/** Test appending empty queue to non empty queue  */
	@Test
	void testAppendEmptytoNonEmptyQueue() {
		myIntQueue.offer(5);
		myIntQueue.offer(7);
		myIntQueue.offer(1);

		myIntQueue.append(mySecondIntQueue);

		assertEquals(3, myIntQueue.size(), "Wrong queuesize");
		assertEquals(0, mySecondIntQueue.size(), "Wrong queuesize");

		assertEquals(5, (int) myIntQueue.poll(), "Element in wrong order");
        assertEquals(7, (int) myIntQueue.poll(), "Element in wrong order");
		assertEquals(1, (int) myIntQueue.poll(), "Element in wrong order");
	}

	
    /**
      Test append non-empty queue to non-empty queue */

    @Test
    public void testAppendNonEmptyToNonEmpty() {
        myIntQueue.offer(1);
        myIntQueue.offer(2);
        myIntQueue.offer(3);
        mySecondIntQueue.offer(1);
        mySecondIntQueue.offer(2);
        mySecondIntQueue.offer(3);

        myIntQueue.append(mySecondIntQueue);

        assertEquals("Wrong size of queue", 6, myIntQueue.size());
        assertEquals("Wrong size of queue", 0, mySecondIntQueue.size());

        assertEquals("Element in wrong order", 1, (int) myIntQueue.poll());
        assertEquals("Element in wrong order", 2, (int) myIntQueue.poll());
        assertEquals("Element in wrong order", 3, (int) myIntQueue.poll());
        assertEquals("Element in wrong order", 1, (int) myIntQueue.poll());
        assertEquals("Element in wrong order", 2, (int) myIntQueue.poll());
        assertEquals("Element in wrong order", 3, (int) myIntQueue.poll());
    }

	 /** Test appending queue with itself */

    @Test
    public void testAppendSameQueueException(){
		assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue));
	}
}
