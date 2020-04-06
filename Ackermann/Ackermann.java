public class Ackermann{

	/* Method for Ackermann
	 * Rules are placed in if statements
	 * Rule 1 : if m = 0, then n+1
	 * Rule 2 : if m>0 and n=0, then A(m-1, 1)
	 * Rule 3 : if m>0 and n>0, then A(m-1, A(m, n-1))
	 */
	public int AckRecursive(int m, int n){
		if (m == 0){
			return n + 1;
		}else if(m > 0 && n == 0){
			return AckRecursive(m - 1, 1);
		}else if(m > 0 && n > 0){
			return AckRecursive(m - 1, AckRecursive(m, n - 1));
		}else{
			return n + 1;
		}
	}

	// Main
	public static void main(String[] args){
		Ackermann ack = new Ackermann();
		int m = 3;
		int n = 2;

		int result = ack.AckRecursive(m, n);
		System.out.println("A(" + m + ", " + n + ") = " + result);
	}
}
