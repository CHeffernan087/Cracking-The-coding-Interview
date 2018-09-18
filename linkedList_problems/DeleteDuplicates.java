package LinkedList_Problems;

import java.util.HashMap;

public class DeleteDuplicates<Key,Value extends Comparable<Key>> {

	
	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList("head",5);
		list.put("Marie", 1);
		list.put("Fearghal", 2);
		list.put("Conor", 3);
		list.put("Marie",1);
		list.printList();
		System.out.println();
		
		deleteDuplicates_NRuntime(list);
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
	
	
}
