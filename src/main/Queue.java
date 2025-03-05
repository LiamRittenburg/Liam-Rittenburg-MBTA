/**
 * This class constructs Queue(int capacity) and creates the enqueue(T element), dequeue(), front(), size(), and toString() methods.
 * Known bugs: None
 * 
 * Liam Rittenburg
 * liamrittenburg@brandeis.edu
 * March 2025
 * COSI 21A PA1
 */

package main;

import java.util.NoSuchElementException;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	/**
	 * Runtime: O(1)
	 * This method constructs an empty Queue object that can hold "capacity" amount of elements.
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
	}
	
	/**
	 * Runtime: O(1)
	 * This method takes element as an argument, and adds the element to the queue as long as there is room.
	 * If there is no room, the queue remains unchanged.
	 * @param element
	 */
	public void enqueue(T element) {
		if(size() < q.length)
		{
			if(tail == q.length)
			{
				tail = 0;
				q[tail] = element;
				tail++;
				numEntries++;
			}
			else
			{
				q[tail] = element;
				tail++;
				numEntries++;
			}
		}
	}
	
	/**
	 * Runtime: O(1)
	 * This method dequeues an element from the front of the queue, as long as the queue is not empty. If the queue is
	 * empty, a NoSuchElementException is thrown.
	 * @throws NoSuchElementException
	 */
	public void dequeue() throws NoSuchElementException 
	{ 
		if(numEntries == 0)
		{
			throw new NoSuchElementException("Error: empty Queue");
		}
		else
		{
			q[head] = null;
			head = (head + 1) % q.length;
			numEntries--;
		}
	}
	
	/**
	 * Runtime: O(1)
	 * This method returns the element at the front of the queue without removing it, as long as the queue is not empty.
	 * If the queue is empty, a NoSuchElementException is thrown.
	 * @return
	 */
	public T front() {
		if(numEntries == 0)
		{
			throw new NoSuchElementException("Error: empty Queue");
		}
		else
		{
			
			return q[head];
		}
	}
	
	/**
	 * Runtime: O(1)
	 * This method returns the amount of elements that are in the queue.
	 * @return
	 */
	public int size() {
		return numEntries;
	}
	
	/**
	 * Runtime: O(n)
	 * This method returns a string representation of the queue.
	 */
	@Override
	public String toString() {
		String ret = "";
		int i = 0;
		int index = head;
		while(i < size() - 1)
		{
			ret = ret + q[index].toString() + ", ";
			i++;
			index = index + 1 % q.length;
		}
		if(size() > 0)
		{
			ret = ret + q[tail - 1].toString();
		}
		return ret;
	}
}
