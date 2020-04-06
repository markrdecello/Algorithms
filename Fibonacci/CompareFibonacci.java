import java.util.Scanner;

public class CompareFibonacci {
	
	// Main method
	public static void main(String[] args) {
		
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci number: ");
		int index = input.nextInt();
		long start = System.currentTimeMillis();
		
		// Find and display the Fibonacci number
		System.out.println("The Computed Fibonacci number at index " + index + " is " + fib(index));
		System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);

		long impstart = System.currentTimeMillis();
		System.out.println("The Improved Fibonacci number at index " + index + " is " + impfib(index));
		System.out.printf("Time: %d ms\n", System.currentTimeMillis() - impstart);
	}

	//The method for finding the Fibonacci number
	public static long impfib(long index) {
		
		if (index == 0){ // Base case
			return 0;
		}else if (index == 1){ // Base case
			return 1;
		}else{ // Reduction and recursive calls
			return fib(index - 1) + impfib(index - 2);
		}
	}

	public static long fib(long n) {
		
		long f0 = 0; // For fib(0)
		long f1 = 1; // For fib(1)
		long f2 = 1; // For fib(2)

		if (n == 0){
			return f0;
		}else if (n == 1){
			return f1;
		}else if (n == 2){
			return f2;
		}

		for(int i = 3; i <= n; i++) {
			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
		}

		return f2;
	}
}
