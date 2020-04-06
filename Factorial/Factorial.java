public class Factorial{

	public int factIterative(int n){

		if(n == 0 || n == 1){
			return 1;
		}else{
			int factorial = 1;
			for(int i = 2; i <= n; i++){
				factorial = factorial * i;
			}
			return factorial;
		}
	}

	public int factRecursive(int n){

		if(n == 0){
			return 1;
		}else{
			return n * factorial
		}
	}

	public static void main(String[] args){

		Factorial fact = new Factorial();
		int num = 5;
		int n = fact.factIterative(num);
		System.out.println(num +"! = " + n);
	}
}
