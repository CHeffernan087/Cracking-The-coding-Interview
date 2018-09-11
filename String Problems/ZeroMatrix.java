package String_Problems;

public class ZeroMatrix {

	public static void main(String[] args) {
		
		//******test one : check for valid output
		int[][] middleZeroTest = {
								{1,2,3},
								{4,0,6},
								{7,8,9}
							};
		zeroMatrix(middleZeroTest);
		print2DArray(middleZeroTest);
		
		//********test two: should have no effect on array
		int[][] noEffect = 
							{
									{1,2,3},
									{4,5,6},
									{7,8,9}
							};
		zeroMatrix(noEffect);
		print2DArray(noEffect);
		
		//*********test three: array should be completely zeros
		int[][] allZeros = 
							{
									{0,1,3},
									{4,0,5},
									{0,8,7}
							};
		
		zeroMatrix(allZeros);
		print2DArray(allZeros);
		
		//**********test four : see that function handles empty array properly
		int[][] emptyArray = null;
		zeroMatrix(emptyArray);
		print2DArray(emptyArray);

	}
	
	/**
	 * This function accepts a matrix of values and 0's out all rows or columns in that array that contain a zero already.
	 * 
	 * The time complexity of the algorithm is O(N), where N is the total number of elements in the 2D array
	 * The space complexity is also O(N) but this is necessary to insure an optimal time complexity.
	 * 
	 * The function works by initially cycling through all the elements in the 2D array, any time a zero is encountered we mark this in 
	 * a helper row / column array. After first iteration we then cycle through the elements again, this time checking if the value in the row / column
	 * arrays is indicating that the current value should be set to zero. If it is, we set the current value to 0
	 * */
	
	public static void zeroMatrix(int[][] a) 
	{
		if(a==null) {a =  new int[0][0];return;}
		boolean[] rowBool = new boolean[a.length];
		boolean[] columnBool = new boolean[a[0].length];
		
		for(int i = 0;i<a.length;i++) 
		{
			for(int j =0;j<a[0].length;j++) 
			{
				if(a[i][j]==0) 
				{
					rowBool[i]=true;										//every time we find zero, update row/column arrays to reflect this
					columnBool[j]=true;
				}
			}
		}
		
		for(int i = 0;i<a.length;i++) 
		{
			for(int j =0;j<a[0].length;j++) 
			{
				if(rowBool[i]==true || columnBool[j]==true) 
				{
					a[i][j] = 0;											//check row/column arrays, if indicated, set current element to 0
				}
			}
		}
		
	}
	
	// a helper function to print out the elements of a 2D array. Only used for testing O(N) complexity
	public static void print2DArray(int[][] a) 
	{
		System.out.println("");
		if(a==null || a.length==0) {System.out.println("Array is empty");return;}
		for(int[] i:a) {
			for(int j:i) 
			{
				System.out.print(j+",");
			}
			System.out.println("");
		}
	}

}
