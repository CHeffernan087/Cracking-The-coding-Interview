package LinkedList_Problems;

public class LinkedList<Key, Value extends Comparable<Key>> {
	
	Node head;
	Node tail;
	int size = 0;
	
	LinkedList(Key key, Value val)
	{
		head = new Node(key, val);
	}
	
	public void swapNodes(Node n1, Node n2) {
		Node tmpPrev = n1.getPrev();
		Node tmpNext = n1.getNext();
		
		n1.setNext(n2.getNext());
		n1.setPrev(n2.getPrev());
		n2.setNext(tmpNext);
		n2.setPrev(tmpPrev);
	}
	
	
	
	public void put(Key key, Value val) 
	{
		put(head, key,val);
	}
	
	private void put(Node n, Key key, Value val) 
	{
		if(n.getNext()==null) 
		{
			Node newNode = new Node(key,val);
			n.setNext(newNode);
			newNode.setPrev(n);
			tail = newNode;
			return;
		}
		else {
			put(n.getNext(),key,val);
		}
	}
	
	public Node get(int pos) 
	{
		return this.get(this.head,pos);
	}
	
	private Node get(Node n,int pos) 
	{
		if(n==null) {return null;}
		if(pos==1) {return n;}
		return(get(n.getNext(),pos-1));
	}
	
	public Node get(Key  key) 
	{
		return this.get(this.head,key);
	}
	
	private Node get(Node n,Key key) 
	{
		if(n == null) {return null;}
		else if(((Comparable<Key>) n.key).compareTo(key)==0) {return n;}
		return get(n.getNext(),key);
	}
	
	private void printList(Node n) 
	{
		if(n.getNext()==null) 
		{
			System.out.println(n.key+" : "+n.val);
			return;
		}
		else
		{
			System.out.println(n.key+" : "+n.val+",");
			printList(n.getNext());
		}
	}
	
	public void printList() 
	{
		
		printList(this.head);
	}
	
	public Node getHead() 
	{
		return this.head;
	}
	
}
