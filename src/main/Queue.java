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
			//tail--;
		}
	}
	
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
	
	public int size() {
		return numEntries;
	}
	
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
