public class DynamicFloyd{

	public static int inf = 999999, v = 4;

	/*
	 * Method for Floyd Algorithm using Dynamic Programming
	 * For k = 1, ...., n and for all of i and j
	 * d[i][j] = minimum(d[i][j], d[i][k] + d[k][j])
	 * Repeat till shortest path is found
	 */
	public void floyd(int[][] graph){
		int[][] d = new int[v][v];
		int i, j, k;

		for (i = 0; i < v; i++){
			for (j = 0; j < v; j++){
				d[i][j] = graph[i][j];
			}
		}
		for (k = 0; k < v; k++){
			for (i = 0; i < v; i++){
				for (j = 0; j < v; j++){
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
					if (d[i][j] + d[j][i] < 0){
						System.out.println("Has a negative weight cycle");	
					}
				}
			}
			System.out.println("D(" + k + ") = ");
			printSolution(d);
			System.out.println("---------------------------------");
		}
		System.out.println("D(" + k + ") = ");
		printSolution(d);
	}

	/*
	 * Method to print the solution/2D Array
	 * Prints the table in an organized manner
	 */
	public void printSolution(int[][] d){
		for (int i = 0; i < v; ++i){
			System.out.print("\t{");
			for (int j = 0; j < v; ++j){
				if (d[i][j] == inf || d[i][j] > 899999){
					System.out.printf("%5s", "inf");
				} else{
					System.out.printf("%4d ", d[i][j]);
				}
			}
			System.out.print("  } ");
			System.out.println();
		}
		System.out.println();
	}

	//Main Method
	public static void main(String[] args){
		DynamicFloyd sp = new DynamicFloyd();

		int[][] graph = { {  0, inf,  -2, inf},
				  {  4,   0,   3, inf},
				  {inf, inf,   0,   2},
				  {inf,  -1, inf,   0} 
				};
		sp.floyd(graph);
	}
}
