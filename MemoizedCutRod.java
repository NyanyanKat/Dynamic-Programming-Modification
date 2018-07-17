// CECS 328 - Project 3
// Jimmy Chan
// Andrew Duong

// Method to output both max price and optimal cuts
public class MemoizedCutRod {
	public void MemoizedCutRod(int[][] p, int n) {
		int[] r = new int[n+1];	// Initialize array r to store max prices
		int[] s = new int[n+1];	// Initialize array s to store the optimal cuts
		
		for (int i = 0; i < r.length; i++) {	// loop through array r and insert place holder at each position
			r[i] = -1;  		// We use -1 as place holder
		}
		
		int max = MemoizedCutRodAux(p, n, r, s);	// Call method MemoizedCutRodAux to return the max price
		System.out.println("The maximum price for length "+n+" is $"+max);	// Print the max price
		System.out.print("The best cuts of length "+n+" are lengths "+s[n]);	// Print the best cuts
		
		while (n > 0) {		// While n is greater than 0, reduce n by s[n] every time and output cuts at each new s[n]
			n = n-s[n];
			if (s[n] != 0) System.out.print(" and " + s[n]);
		}
		System.out.println();
		System.out.println();
	}
	
	
	
	// Method to store the best price and best cuts into the arrays r and s 
	private int MemoizedCutRodAux(int[][] p, int n, int[] r, int[] s) {
		
		int q1, q0;	// Declare two variables to compare the max price
		
		if (r[n] >= 0) return r[n];	// if the solution has already been encountered, simply return solution
		
		if (n == 0) q1 = 0;	// if length is 0, simply set max price to $0
		else {				// Otherwise, we need to set q1 to placeholder
			q1 = -1;
			for (int i = 0; i < n; i++) {	// loop through the original array p and recursively add up prices into q0
				q0 = p[1][i] + MemoizedCutRodAux(p,n-i-1,r,s);	
				if (q0 > q1) {				// if q0 is greater than q1, set q1 = q0 and store the current best cut into s[n]
					q1 = q0;
					s[n] = i+1;
				}
			}
		}
		r[n] = q1;						// Once loop is done, store the max price into r[n]
		
		return q1;						// Return the max price
	}
	
}


