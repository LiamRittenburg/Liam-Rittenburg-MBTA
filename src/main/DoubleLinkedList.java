/**
 * This class constructs DoubleLinkedList() and creates the getFirst(), insert(T element), delete(T key), get (T key),
 * size(), toString()
 * Known bugs: None
 * 
 * Liam Rittenburg
 * liamrittenburg@brandeis.edu
 * March 2025
 * COSI 21A PA1
 */
package main;

public class DoubleLinkedList<T> {

	private Node<T> L;
	private Node<T> curr;
	private int len;

	/**
	 * This method initializes an empty DoubleLinkedList object.
	 */
	public DoubleLinkedList() {
		
	}
	
	/**
	 * This method returns the first node of the linked list, and null if the list is empty
	 */
	public Node<T> getFirst() {
		return L;
	}
	
	/**
	 * This method inserts a new node containing the argument (T element) and inserts it at the end of the list
	 * @param element
	 */
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
	
	/**
	 * This method deletes the node specified by the argument (T key). If the node specified by (T key) exists in the list,
	 * the node is deleted and returned. If it is not found, null is returned.
	 * @param key
	 * @return
	 */
	public T delete(T key) {
		Node<T> trav = L;
		T retKey = null;
		{
			while(trav != null)
			{
				if(trav.getData().equals(key))
				{
					if(trav.getPrev() != null)
					{
						trav.getPrev().setNext(trav.getNext());
					}
					else
					{
						L = trav.getNext();
					}
					if(trav.getNext() != null)
					{
						trav.getNext().setPrev(trav.getPrev());
					}
					len--;
					return trav.getData();
				}
				else
				{
					trav = trav.getNext();
				}
			}
			return retKey;
		}
	}
	
	/**
	 * This method finds the first node specified by the argument (T key) and returns it. If there is no node specified
	 * by (T key) in the list, null is returned.
	 * @param key
	 * @return
	 */
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
	
	/**
	 * This method returns the number of nodes in the linked list.
	 * @return
	 */
	public int size() {
		return len;
	}
	
	/**
	 * This method returns a string representation of the linked list.
	 */
	@Override
	public String toString() {
		String list = "";
		Node<T> trav = L;
		while(trav != null)
		{
			list = list + trav.getData().toString();
			trav = trav.getNext();
		}
		return list;
	}
}
