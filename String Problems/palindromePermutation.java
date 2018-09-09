package String_Problems;

public class palindromePermutation {
	
	public static void main(String [] args)
	{
		System.out.println(palindromePermutation("aNvan"));		// => true
		System.out.println(palindromePermutation("Conor"));		// => false
		System.out.println(palindromePermutation("raceCAR"));	// => true
		System.out.println(palindromePermutation(""));			// => false
		System.out.println(palindromePermutation(null));		// => false
	}
	
	/**
	 * This function accepts a string and returns a boolean value representing whether or not that string can be rearranged into a palindrome.
	 * This function cycles through each character in the string and flips the corresponding  index of a boolean array to indicate if there is an even or an odd 
	 * number of occurrences of a given character in the string 1 for odd 0 for even. The algorithm works on the premise that a palindrome should 
	 * have an even number of all characters or else a lone occurrence of one single character. if we have more than one odd number of characters,
	 * then the string cannot be rearranged into a palindrome.
	 * 
	 * The time complexity of this algorithm is O(N) where N is the number of characters in the string.
	 * The space complexity of this algorithm is O(256) for the boolean array
	 * 
	 * Optimisation : The space complexity of this algorithm can be optimised to O(26) if we assume that the string is a character in the English alphabet.
	 * Currently the algorithm assumes ascii characters
	 */
	
	public static boolean palindromePermutation(String str)
	{
		if(str==null || str.length()<2) {return false;}
		str = str.toLowerCase();
		boolean[] alphabet = new boolean[256];
		int numberOfOnes = 0;
		for(int i = 0; i< str.length();i++)
		{
			
			alphabet[(int)(str.charAt(i))] = !alphabet[(int)(str.charAt(i))];
			if(alphabet[(int)(str.charAt(i))] == true)
			{
				numberOfOnes++;
			}
			else
			{
				numberOfOnes--;
			}
		}
		
		return numberOfOnes <2;
		

	}
}
