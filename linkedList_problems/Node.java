package LinkedList_Problems;

public class Node<Key,Value> {
	private Node next;
	private Node previous;
	Key key;
	Value val;
	
	Node(Key key, Value val)
	{
		this.key = key;
		this.val = val;
	}
	
	public void setNext(Node n) 
	{
		this.next = n;
	}
	
	public Node getNext() 
	{
		return next;
	}
	
	public Node getPrev() 
	{
		return previous;
	}
	
}
