package String_Problems;

public class Urlify {

	public static void main(String[] args)
	{
		System.out.println(urlify("Conor Heffernan"));
		System.out.println(urlify("Love is blindness"));
		System.out.println(urlify(""));
		System.out.println(urlify(null));
		System.out.println(urlify("Thequickbrownfoxjumpsoverthelazydog"));
	}

	// 

	/**
	 * This function takes a string and replaces all occurences of the space character with %20, making it look like a URL
	 * this algorithm has a time complexity of O(N) and a space complexity of O(N) where N is the number of characters in the string
	 * using a string builder insures O(1) insertion time and an O(N) to string time, which is a lot more efficient that continually making new strings
	 * 
	*/
	public static String urlify(String str)
	{
		if(str==null || str.length()<1) return "";
		StringBuilder newStr = new StringBuilder();
		
		for(int i = 0; i<str.length();i++)
		{
			char currentChar = str.charAt(i);
			if (currentChar == ' ' )
			{
				newStr.append("%20");
				
			}
			else
			{
				newStr.append(currentChar);
			}
		}
		str = newStr.toString();
		return str;
		
	}
	
}
