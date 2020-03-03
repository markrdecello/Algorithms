public class MatrixMultiplication{

	public int[][] matrixMultiplication(int[][] A, int[][] B, int n, int row, int col){

		int[][] C = new int[row][col];

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				C[i][j] = 0;
				for(int k = 0; k < n; k++){
					C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
				}
			}
		}
		return C;
	}

	public static void printResult(int[][] result, int row, int col){
		System.out.print("\t   [");
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.printf(" %3d ", result[i][j]);
				if(j == col-1){
					System.out.print(" ]");
					System.out.println();
					if(i != row-1){
						System.out.print("\t   [");
					}
				}
			}	
		}
		System.out.println();
	}

	public static void main(String[] args){

		MatrixMultiplication mm = new MatrixMultiplication();
		int[][] A = {
			{4, 7},
			{6, 9}
		};
		int[][] B = {
			{1, 3},
			{6, 4}
		};
		int n = B.length;
		int row = A.length;
		int col = B[0].length;

		System.out.println("\n\t      MATRIX A");
		printResult(A, A.length, A[0].length);
		System.out.println("\t      MATRIX B");
		printResult(B, B.length, B[0].length);
		if(A[0].length != n){
			System.out.println("------------------------------------------");
			System.out.println("\n\tMatrix Multiplaction not possible!\n");
		}else{
			int[][] result = mm.matrixMultiplication(A, B, n, row, col);
			System.out.println("------------------------------------------");
			System.out.println("\n\tMatrix Multiplication");
			printResult(result, row, col);
		}
	}
}
