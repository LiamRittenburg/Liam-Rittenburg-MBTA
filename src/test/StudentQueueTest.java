package test;
import main.Queue;
import main.Rider;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class StudentQueueTest {

	@Test
	void testInit() {
		Queue q1 = new Queue(5);
		assertEquals(0, q1.size());
	}

	@Test
	void testEnqueue()
	{
		Queue<Rider> q2 = new Queue<Rider>(3);
		Rider r1 = new Rider("123", "A", "B");
		Rider r2 = new Rider("456", "C", "D");
		Rider r3 = new Rider("789", "E", "F");
		Rider r4 = new Rider("000", "G", "H");
		q2.enqueue(r1);
		assertEquals(1, q2.size());
		q2.enqueue(r2);
		q2.enqueue(r3);
		assertEquals("123, B, 456, D, 789, F", q2.toString());
		q2.enqueue(r4);
		assertEquals("123, B, 456, D, 789, F", q2.toString());
	}

	@Test
	void testDequeue()
	{
		Queue<Rider> q3 = new Queue<Rider>(3);
		Rider r1 = new Rider("123", "A", "B");
		Rider r2 = new Rider("456", "C", "D");
		Rider r3 = new Rider("789", "E", "F");
		Rider r4 = new Rider("000", "G", "H");
		q3.enqueue(r1);
		assertEquals(1, q3.size());
		q3.dequeue();
		assertEquals(0, q3.size());
		q3.enqueue(r1);
		q3.enqueue(r2);
		q3.enqueue(r3);
		assertEquals("123, B, 456, D, 789, F", q3.toString());
		q3.dequeue();
		assertEquals("456, D, 789, F", q3.toString());
		

	}

}
