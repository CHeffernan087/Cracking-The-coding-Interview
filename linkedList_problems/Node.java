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
	
	public void setPrev(Node n) 
	{
		this.previous = n;
	}
	
	public Node getNext() 
	{
		return next;
	}
	
	public Node getPrev() 
	{
		return previous;
	}
	
	public void deleteNode() 
	{
		
		Node next = this.getNext();
		Node prev = this.getPrev();
		
		this.previous.setNext(next);
		if(this.next!=null) {
		this.next.setPrev(prev);
		}
	}
	
}
