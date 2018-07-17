// CECS 328 - Project 3
// Jimmy Chan
// Andrew Duong

public class MemoizedCutRodTester {

	public static void main(String[] args) {
		// Test case using 2D array
		int[][] test = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 5, 8, 9, 10, 17, 17, 20, 24, 30}};
		
		// Declare a new MemoizedCutRod object
		MemoizedCutRod a = new MemoizedCutRod();
		
		// Output the max price and best cuts with length of 4
		a.MemoizedCutRod(test, 4);
		
		// Output the max price and best cuts with length of 5
		a.MemoizedCutRod(test, 5);
		
		// Output the max price and best cuts with length of 6
		a.MemoizedCutRod(test, 6);
	}

}
