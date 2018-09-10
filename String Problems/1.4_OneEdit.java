package String_Problems;

public class OneEdit 
{
	public static void main(String[] args) 
	{
		System.out.println(oneEdit("pet","pest"));			// check insertion						=> true
		System.out.println(oneEdit("Giraffe","iraffe"));		// check delete  						=> true
		System.out.println(oneEdit("Knife","Nnife"));			// check character change					=> true
		System.out.println(oneEdit("pet","step"));			// check more than one change					=> false
		System.out.println(oneEdit("Conor","Conor"));			// check same string						=> false
		System.out.println(oneEdit("Conor","Conor "));  		// check same string with one insertion				=> true
		System.out.println(oneEdit("",""));				// check empty string						=> false
		System.out.println(oneEdit("","a"));				// check single char insertion					=> true
		System.out.println(oneEdit("hi",null));				// check invalid input						=> false
		
	}
	
	/**
	 * This function examines two strings and returns if there is a one character edit difference between the two strings
	 * a character edit can be an insertion, replace or delete 
	 *  
	 * 
	 * The time complexity of this algorithm is O(N) where N is the length of the shorter string
	 * The space complexity of this algorithm is O(1)
	 * 
	 * How it works:
	 * this function uses pointers to iterate over the two strings, the two strings should be largely the same.
	 * When a difference is found, if necessary (if one string is longer than the other), one pointer is incremented while the other is not
	 * all other characters are then compared, if more than one difference is found at any stage, we can return false;
	 * if exactly one edit is found at the end of the algorithm, we return true 
	 * */
	public static boolean oneEdit(String s1, String s2) 
	{
		if(s1 == null || s2 == null ||(s1.equals("")&& s2.equals(""))) {return false;}
		
		int difference  = Math.abs(s1.length()-s2.length());						//difference in length between two strings (should be 1 or 0)
		if(difference > 1) {return false;}
		
		String shortString,longString;
		if(s1.length()<s2.length())									// determine which string is longer
		{
			shortString = s1; 
			longString = s2;
		}					
		else 
		{
			shortString = s2; 
			longString = s1;
		}
		
		int shortPointer = 0;
		int longPointer = 0;
		int numberOfDifferences = 0;
		int offset = 1- difference;
		
		for(int i =0; i< shortString.length();i++) 
		{
			if(shortString.charAt(shortPointer)== longString.charAt(longPointer)) 			// if characters are the same, simply advance both pointers and continue to compare chars
			{
				shortPointer++;
				longPointer++;
				continue;
			}
			else 
			{											// if you find chars that are  different, advance longpointer
				numberOfDifferences++;								// only advance short pointer if length of words is the same, else leave short pointer where its pointing to
				shortPointer+=offset;								// all other chars should then be the same if the strings are one edit away
				longPointer++;
			}
			if(numberOfDifferences>1) {return false;}
		}
		return (numberOfDifferences >0 || difference == 1);						// deals with edge cases where words are the same or the same plus an additional char at the end
	}
}
