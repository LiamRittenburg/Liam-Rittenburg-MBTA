package test;
import main.DoubleLinkedList;
import main.Station;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentDLLTest {

	@Test
	void testInit()
	{
		DoubleLinkedList<Station> l1 = new DoubleLinkedList<>();
		assertTrue(l1.getFirst() == null);
		assertEquals(0, l1.size());
		
	}

	@Test
	void testGetFirst()
	{
		DoubleLinkedList<Station> l2 = new DoubleLinkedList<>();
		Station s = new Station("Alewife");
		assertEquals(null, l2.getFirst());
		l2.insert(s);
		assertEquals(s, l2.getFirst().getData());
	}

	@Test
	void testInsert()
	{
		DoubleLinkedList<Station> l3 = new DoubleLinkedList<>();
		Station s1 = new Station("Alewife");
		Station s2 = new Station("Davis");
		Station s3 = new Station("Harvard");
		Station s4 = new Station("Central");
		l3.insert(s1);
		assertEquals(s1, l3.getFirst().getData());
		l3.insert(s2);
		l3.insert(s3);
		l3.insert(s4);
		assertEquals(4, l3.size());
	}

	@Test
	void testDelete()
	{
		DoubleLinkedList<Station> l4 = new DoubleLinkedList<>();
		Station s1 = new Station("Alewife");
		Station s2 = new Station("Davis");
		Station s3 = new Station("Harvard");
		Station s4 = new Station("Central");
		assertEquals(null, l4.delete(s2));
		l4.insert(s1);
		assertEquals(s1, l4.getFirst().getData());
		l4.delete(s1);
		assertEquals(0, l4.size());
		l4.insert(s1);
		l4.insert(s2);
		l4.insert(s3);
		l4.insert(s4);
		assertEquals(4, l4.size());
		assertEquals(s3, l4.delete(s3));
		assertEquals(3, l4.size());
		l4.delete(s4);
		assertEquals(2, l4.size());
	}

	@Test
	void testGet()
	{
		DoubleLinkedList<Station> l5 = new DoubleLinkedList<>();
		Station s1 = new Station("Alewife");
		Station s2 = new Station("Davis");
		Station s3 = new Station("Harvard");
		Station s4 = new Station("Central");
		assertEquals(null, l5.get(s1));
		l5.insert(s1);
		l5.insert(s2);
		l5.insert(s3);
		l5.insert(s4);
		assertEquals(s3, l5.get(s3));
		assertEquals(s4, l5.get(s4));
		assertEquals(s1, l5.get(s1));
	}

	@Test
	void testSize()
	{
		DoubleLinkedList<Station> l6 = new DoubleLinkedList<>();
		Station s1 = new Station("Alewife");
		Station s2 = new Station("Davis");
		Station s3 = new Station("Harvard");
		Station s4 = new Station("Central");
		assertEquals(0, l6.size());
		l6.delete(s1);
		assertEquals(0, l6.size());
		l6.insert(s1);
		assertEquals(1, l6.size());
		l6.delete(s1);
		assertEquals(0, l6.size());
		l6.insert(s1);
		l6.insert(s2);
		l6.insert(s3);
		l6.insert(s4);
		assertEquals(4, l6.size());
	}

	@Test
	void testToString()
	{
		
	}

}
