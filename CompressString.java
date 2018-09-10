package String_Problems;

public class CompressString {

	public static void main(String[] args) {
		
		System.out.println(compressString("aaaaaaaaaaaaaaabbaaa"));			//	a15b2a3
		System.out.println(compressString("Conor"));						//	Conor
		System.out.println(compressString(null));							// ""
		System.out.println(compressString(""));								// ""
		

	}
	/**
	 * This function accepts a string and returns a compressed version of the string using a primitive compression algorithm where the same consecutive character
	 * is replaced by that character followed by the number of occurrences of that character
	 * 
	 * The time complexity of this algorithm is O(N) where N is the number of characters in the string
	 * The space complexity is at most O(N) , precisely Theta(2N) = Theta(N) in the case where the input string is made of all unique characters
	 * 
	 * The function works simply by keeping a count of how many of a consecutive character it has happened upon so far,
	 * when a new char is found the current char as well as the character count is inserted into a strigbuilder.
	 * using a stringbuilder allows for O(1) insertion time. the toString() call at the end of the function is O(N)
	 * 
	 * */
	public static String compressString(String str) 
	{
		if(str==null || str.length()==0) {return "";}
		int strlen = str.length();
		char currentChar = str.charAt(0);
		int charCount = 0;
		StringBuilder newStr = new StringBuilder();
		for(int i =1;i<strlen;i++) 
		{
			char nextChar  = str.charAt(i);
			if(nextChar!= currentChar) 
			{
				++charCount;
				newStr.append(currentChar);
				int countLength = getLengthOfDigits(charCount);
				newStr.append(charCount);
				charCount = 0;
				currentChar = nextChar;
			}
			else 
			{
				charCount++;
			}
		}
		newStr.append(currentChar);
		int countLength = getLengthOfDigits(charCount);
		newStr.append(++charCount);
		String newString = newStr.toString();
		if(newString.length() < strlen) 
		{
			return newString;
		}
		
		return str;
		
	}
	/**
	 * helper function to determine the number of digits in a number, if this is inefficient, could replace with 9 if < statements 
	 * Time complexity a max of O(9) really - for a number in the billions so equivalent to O(1)
	 */
	public static int getLengthOfDigits(int charCount) 
	{
		return (""+ charCount).length();
	
	}

}
