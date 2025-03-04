package main;

public class DoubleLinkedList<T> {

	private Node<T> L;
	private Node<T> curr;
	private int len;

	public DoubleLinkedList() {
		
	}
	
	public Node<T> getFirst() {
		return L;
	}
	
	
	public void insert(T element) {
		Node<T> newNode = new Node<T>(element);
		if(L == null)
		{
			L = newNode;
			len++;
			curr = newNode;
		}
		else
		{
			newNode.setPrev(curr);
			curr.setNext(newNode);
			curr = newNode;
			len++;
		}
	}
	
	public T delete(T key) {
		T retKey = null;
		Node<T> trav = new Node<T>(key);
		if(size() > 0)
		{
			trav = L;
			while(trav != null)
			{
				if(trav.getData() == key)
				{
					Node<T> tmp = trav.getPrev();
					tmp.setNext(trav.getNext());
					(tmp.getNext()).setPrev(tmp);
					len--;
					return retKey;
				}
				else
				{
					trav = trav.getNext();
				}
			}
		}
		return retKey;
	}
	
	public T get(T key) {
		Node<T> trav = L;
		T retKey = null;
		{
			while(trav != null)
			{
				if(trav.getData().equals(key))
				{
					retKey = trav.getData();
					return retKey;
				}
				else
				{
					trav = trav.getNext();
				}
			}
			return retKey;
		}
	}
	
	public int size() {
		return len;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
