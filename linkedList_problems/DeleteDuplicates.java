package LinkedList_Problems;

import java.util.HashMap;

public class DeleteDuplicates<Key,Value extends Comparable<Key>> {

	
	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList("head",5);
		list.put("Marie", 1);
		list.put("Fearghal", 2);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Marie",1);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Marie",1);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		list.put("Conor", 3);
		
		//list.printList();
		//System.out.println();
		
		//deleteDuplicates_NRuntime(list);
		deleteDuplicates_spaceOptimised(list);
		list.printList();
		
		
	}
	
	public static void deleteDuplicates_NRuntime(LinkedList list) 
	{
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		Node n = list.getHead();
		while(n!=null)
		{
			if(map.get(n.key)==null) {
				map.put((String)n.key, (Integer)n.val);
			}
			else 
			{
				n.deleteNode();
			}
			n = n.getNext();
		}
		
	}
	
	public static void deleteDuplicates_spaceOptimised(LinkedList list) 
	{
		Node n = list.head;
				while(n!=null) 
				{
					Node next = n.getNext();
					while(next!=null) 
					{
						if(next.key.equals(n.key)) 
						{
							next.deleteNode();
						}
						next= next.getNext();
					}
					n = n.getNext();
				}
				
				return;
	}
	
//	private static void deleteDuplicates(Node n,String targetKey) 
//	{
	
//		if(n==null||n.getNext()==null) {return;}
//		if(n.getNext().key.equals(targetKey)) {
//			n.getNext().deleteNode();
//			deleteDuplicates(n.getNext(),(String)targetKey);
//			return;
//		}
//		deleteDuplicates(n.getNext(),(String)targetKey);
//		if(n.key.equals(targetKey)) {
//			deleteDuplicates(n.getNext(),(String) n.getNext().key); 
//		}
		
//	}
	
	public static boolean alphabeticallyFirst(String s1, String s2) 
	{
		return (s1.compareTo(s2)<0); 
		
	}
	
	
	
}
