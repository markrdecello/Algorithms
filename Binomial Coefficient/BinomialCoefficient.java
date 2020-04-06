public class BinomialCoefficient{

	/*
	 * Binomial Coefficient Recursive Version
	 * Return 1 if k = 0 or k = n
	 */
	public int binRecursive(int n, int k){
		if(k == 0 || k == n){
			return 1;
		}else{
			return binRecursive(n-1, k-1) + binRecursive(n-1, k);
		}
	}

	/*
	 * Binomial Coefficient Dynamic Version
	 * Creates a 2d array with values of B[n+1][k+1]
	 * If j = 0 or j = i, B[i][j] = 1
	 * If not B[i][j] = B[i-1][j-1] + B[i-1][j]
	 * Then return B[i][j]
	 */
	public int binDynamic(int n, int k){
		int i,  j;
		int[][] B = new int[n+1][k+1];

		for(i = 0; i <= n; i++){
			for(j = 0; j <= Math.min(i, k); j++){
				if(j == 0 || j == i){
					B[i][j] = 1;
				}else{
					B[i][j] = B[i-1][j-1] + B[i-1][j];
				}
			}
		}
		return B[n][k];	
	}

	public static void main(String[] args){
		
		BinomialCoefficient bc = new BinomialCoefficient();
		int n = 5;
		int k = 3;

		int binR = bc.binRecursive(n, k);
		int binD = bc.binDynamic(n, k);

		System.out.println("Binomial Coefficient Recursive");
		System.out.println("\tValue of B(" + n +", " + k +") is " + binR);
		System.out.println("Binomial Coefficient Dynamic");
		System.out.println("\tValue of B(" + n +", " + k +") is " + binD);
	}

}
