package main;

import java.util.NoSuchElementException;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
	}
	
	public void enqueue(T element) {
		q[tail] = element;
		if(tail == q.length)
		{
			tail = 1;
		}
		else
		{
			tail++;
			numEntries++;
		}
	}
	
	public void dequeue() throws NoSuchElementException 
	{ 
		if(numEntries == 0)
		{
			throw new NoSuchElementException();
		}
		else
		{
			head = (head + 1) % q.length;
			numEntries--;
		}
	}
	
	public T front() {
		if(numEntries == 0)
		{
			throw new NoSuchElementException();
		}
		else
		{
			
			return q[head];
		}
	}
	
	public int size() {
		return numEntries;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
