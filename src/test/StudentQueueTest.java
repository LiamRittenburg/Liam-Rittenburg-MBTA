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

	@Test
	void testFront()
	{
		Queue<Rider> q4 = new Queue<Rider>(3);
		Rider r1 = new Rider("123", "A", "B");
		Rider r2 = new Rider("456", "C", "D");
		Rider r3 = new Rider("789", "E", "F");
		Rider r4 = new Rider("000", "G", "H");
		q4.enqueue(r1);
		q4.enqueue(r2);
		q4.enqueue(r3);
		assertEquals(r1, q4.front());
		q4.dequeue();
		assertEquals(r2, q4.front());
		q4.dequeue();
		assertEquals(r3, q4.front());
	}

	@Test
	void testSize()
	{
		Queue<Rider> q5 = new Queue<Rider>(3);
		Rider r1 = new Rider("123", "A", "B");
		Rider r2 = new Rider("456", "C", "D");
		Rider r3 = new Rider("789", "E", "F");
		Rider r4 = new Rider("000", "G", "H");
		assertEquals(0, q5.size());
		q5.enqueue(r1);
		q5.enqueue(r2);
		q5.enqueue(r3);
		assertEquals(3, q5.size());
		q5.enqueue(r4);
		assertEquals(3, q5.size());
		q5.dequeue();
		q5.dequeue();
		q5.dequeue();
		assertEquals(0, q5.size());
	}

	@Test
	void testToString()
	{
		Queue<Rider> q6 = new Queue<Rider>(3);
		Rider r1 = new Rider("123", "A", "B");
		Rider r2 = new Rider("456", "C", "D");
		Rider r3 = new Rider("789", "E", "F");
		Rider r4 = new Rider("000", "G", "H");
		assertEquals("", q6.toString());
		q6.enqueue(r1);
		assertEquals("123, B", q6.toString());
		q6.enqueue(r2);
		assertEquals("123, B, 456, D", q6.toString());
		q6.enqueue(r3);
		assertEquals("123, B, 456, D, 789, F", q6.toString());
		q6.dequeue();
		assertEquals("456, D, 789, F", q6.toString());
		q6.dequeue();
		assertEquals("789, F", q6.toString());
		q6.dequeue();
		assertEquals("", q6.toString());
	}

}
