package String_Problems;

public class RotateMatrix {
	public static void main (String[] args) 
	{
		// Test one: three by three valid matrix
		int[][] testThreeByThree = {
										{1,2,3},
										{4,5,6},
										{7,8,9}
									};
		rotateMatrix(testThreeByThree);
		print2DArray(testThreeByThree);
		
		
		// Test Two : four by four valid matrix
		int[][] fourByFour = 
									{
										{1,2,3,4},
										{5,6,7,8},
										{9,10,11,12},
										{13,14,15,16}
									};
		rotateMatrix(fourByFour);
		print2DArray(fourByFour);
		
		
		// Test three : five by five valid matrix
		int[][] testFiveByFive = {
										{1,2,3,4,5},
										{6,7,8,9,10},
										{11,12,13,14,15},
										{16,17,18,19,20},
										{21,22,23,24,25}
		
									};
		rotateMatrix(testFiveByFive);
		print2DArray(testFiveByFive);
		
		
		// Test four : empty matrix invalid input
		int[][] empty = new int[0][0];
		rotateMatrix(empty);
		
		// Test five : null. invalid input
		rotateMatrix(null);
		
		// Test six : rectangular array invalid input
		int[][] rectangualarMatrix = {
										{1,2,3,4,5,6,7},
										{6,7,8,9,10,11,12},
										{13,14,15,16,17,18,19}
										
									};
		rotateMatrix(rectangualarMatrix );
		print2DArray(rectangualarMatrix);
		
	}
	
	/**
	 * This function accepts a square matrix and rotates the elements 90 degrees. applications are image rotation. The algorithm could be adopted to rotate rectangular matrices.
	 * this however, could not be done in place (obviously) as a Matrix with new dimensions to the input matrix would have to be instantiated. Currently the algorithm is in place.
	 * 
	 * The algorithm employed has a time complexity of O(N) where N is the number of elements in the 2D array
	 * The space complexity of this algorithm is O(1)- it is in place.
	 * 
	 * This algorithm will work through this matrix in a cyclical fashion, initially swapping the outer-most integers and working its way inwards towards the middle.
	 * I initially store all those integers that I am preparing to swap, though as an optimisation it would be better to only store a back up of the first pixel (pix1)
	 * and just swap all other pixels. For the sake of simplicity and readability, I consider this solution slightly better
	 * */
	
	public static void rotateMatrix(int[][] matrix) 
	{
		if(matrix == null || matrix.length<1|| matrix.length!=matrix[0].length) {return;}
		int rowLength = matrix.length;
		int columnLength = matrix[0].length;
		for(int i = 0;i<rowLength;i++) 
		{
			for(int j=i;j<columnLength-(i+1);j++) 
			{
				int pix1 = matrix[i][j];
				int pix2 = matrix[j][rowLength-(i+1)];
				int pix3 = matrix[columnLength-(i+1)][rowLength-(j+1)];				//Back up all pixels we intend to swap
				int pix4 = matrix[columnLength-(j+1)][i];
				
				matrix[i][j] = pix4;
				matrix[columnLength-(j+1)][i] = pix3;
				matrix[columnLength-(i+1)][rowLength-(j+1)] = pix2;				//swap pixels to new correct place in matrix
				matrix[j][rowLength-(i+1)] = pix1;
				
			}
		}
	}
	
	/**
	 * Helper function to print out a 2d matrix. Used to assist with testing
	 * */
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
