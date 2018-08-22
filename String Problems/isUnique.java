package String_Problems;

public class isUnique {
	
	public static final int NUMBER_OF_ASCII_CHARS = 256;
	public static void main(String[] args) 
	{
		System.out.println(isUnique("ConOr"));
		System.out.println(isUnique("Marie"));
		System.out.println(isUnique("The quick brown fox jumps over the lazy dog"));
		System.out.println(isUnique(""));
		System.out.println(isUnique(null));
	}

	// this method checks if a string is composed of all unique characters or not
	// uses a boolean array where every ascii characters are represented by a single boolen value
	// as I iterate over every char in the string I set the corresponding boolean to true
	// if at any stage, I attempt to set the boolean to true and it is already true, then a duplicate character has been found. Return false
	
	public static boolean isUnique(String str) 
	{
		if(str ==null ) {return false;}
		
		Boolean[] alpha  = new Boolean[NUMBER_OF_ASCII_CHARS];		// instanciate alphabet array
		setToFalse(alpha);											// set all alphabet values to false
		str.toLowerCase();											// insure that a string with duplicate capital and small chars returns false
		
		for(int i=0;i<str.length();i++) 
		{
			char currentChar = str.charAt(i);
			if(alpha[(int)(currentChar)] == false) 
			{
				alpha[currentChar] = true;
			}
			else 
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void setToFalse(Boolean[] a) 
	{
		for(int i = 0;i<a.length;i++) 
		{
			a[i]= false;
		}
	}
}




