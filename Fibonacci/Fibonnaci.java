public class Fibonacci{

	public int FibRecursive(int n){
		if(n == 0 || n == 1){
			return n;
		}else{
			return FibRecursive(n - 1) + Fib(n - 2);
		}
	}

	public int FibIterative(int n){

	}

	public static void main(String[] args){

		
	}
}
