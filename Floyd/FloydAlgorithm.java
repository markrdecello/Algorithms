public class FloydAlgorithm{

	final static int inf = 99999, v = 4;

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
					if (d[i][j] + d[k][j] < d[i][j]){
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		printGraph(d);
	}

	public void printGraph(int d[][]){
		System.out.println("Shortest Distance:");
		for (int i = 0; i < v; ++i){
			for (int j = 0; j < v; ++j){
				if (d[i][j] == inf){
					System.out.print("inf ");
				}else{
					System.out.print(d[i][j] + "   ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		int[][] graph = { {0, 5, inf, 10},
				  {inf, 0, 3, inf},
				  {inf, inf, 0, 1},
				  {inf, inf, inf, 0}
				};
		FloydAlgorithm sp = new FloydAlgorithm();

		sp.floyd(graph);
	}

}
