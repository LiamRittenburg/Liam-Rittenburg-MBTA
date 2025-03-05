/**
 * This class constructs Node(T data), and creates the setData(T data), setNext(Node<T> next), setPrev(Node<T> prev), 
 * getNext(), getPrev(), getData(), and toString() methods.
 * Known bugs: None
 * 
 * Liam Rittenburg
 * liamrittenburg@brandeis.edu
 * March 2025
 * COSI 21A PA1
 */
package main;

public class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	/**
	 * This constructor constructs a new Node and sets its data equal to the argument (T data)
	 * @param data
	 */
	public Node(T data) {
		this.data = data;
	}
	
	/**
	 * This method sets the data of the node to the argument (T data)
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * This method sets the nodes "next" field equal to the argument (Node<T> next)
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * This method sets the nodes "prev" field equal to the argument (Node<T> prev)
	 * @param prev
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	/**
	 * This method returns the node that this node is pointing to, and null if the node is pointing to null
	 * @return
	 */
	public Node<T> getNext() {
		return this.next;
	}
	
	/**
	 * This method returns the node that this node is pointing to, and null if the node is pointing to null
	 * @return
	 */
	public Node<T> getPrev() {
		return this.prev;
	}
	
	/**
	 * This method returns the "data" field of the node this method is called on
	 * @return
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * This method returns a string representation of the node this method is called upon.
	 */
	@Override
	public String toString() {
		return data.toString();
	}
}
