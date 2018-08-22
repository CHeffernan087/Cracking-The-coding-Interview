package String_Problems;

public class stringPermutation {

	/**
	 * An algorithm to determine if one string is a permutation of another. Similar to isUnique problem, this algorithm 
	 * keeps a count of the number of characters in the first word an decrements this count to determine what characters are in the second 
	 * word. If the two words are permutations of one another then the array should be full of zeros at the end of the algorithm.
	 * 
	 * The time complexity of this algorithm is O(N) where N is the number of characters in the first string
	 * */
	public static void main(String[] args) 
	{
		System.out.println(isPermutation("Conor","onCor"));
		System.out.println(isPermutation("Conor","Marie"));
		System.out.println(isPermutation("Conor","Conor"));
		System.out.println(isPermutation(null,"Football"));
	}
	
	public static boolean isPermutation(String s1, String s2) 
	{
		if(s1==null||s2==null ||(s1.length()!=s2.length())) {return  false;}
		
		int[] chCount = new int[256];
		setToZero(chCount);
		
		//increment counts of chars from s1, decrement chars from s2
		
		for(int i = 0;i<s1.length();i++) 
		{
			char c1 = s1.charAt(i);					
			char c2 = s2.charAt(i);					// if whitespace was not to be considered then we would just not add to index 32 in the array ever
			chCount[c1]++;
			chCount[c2]--;
		}
		
		
		return isAllZero(chCount);
	}
	
	public static void setToZero(int[] a) 
	{
		for(int i = 0;i<a.length;i++) 
		{
			a[i]= 0;
		}
	}
	
	public static boolean isAllZero(int[] a) 
	{
		for(int i = 0;i<a.length;i++) 
		{
			if(a[i]!=0) {return false;}
		}
		return true;
	}
}
