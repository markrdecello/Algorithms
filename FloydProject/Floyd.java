//Group Name: Error_404
//Group Leader: Mark Decello
//Group Members: Mark Decello, Julius Lopez, Gene Olivia, Hanel Duran, Naglaa Saeid

class Floyd
{
	// Recursive Function to print path of given
	// vertex u from source vertex v
	private static void printPath(int[][] path, int v, int u)
	{
		if (path[v][u] == v)
			return;

		printPath(path, v, path[v][u]);
		System.out.print(path[v][u] + " ");
	}

	// Function to print the shortest cost with path
	// information between all pairs of vertices
	private static void printSolution(int[][] cost, int[][] path, int N)
   {
   System.out.println("Matrix: Floyd's Algorithm Shortest Path\n");
   System.out.println("{ 0, 1, M, 1, 5 }");
   System.out.println("{ 9, 0, 3, 2, M }");
	System.out.println("{ M, M, 0, 4, M }");
   System.out.println("{ M, M, 2, 0, 3 }");
   System.out.println("{ 3, M, M, M, 0 }\n");  
   
		for (int v = 0; v < N; v++)
		{
			for (int u = 0; u < N; u++)
			{
				if (u != v && path[v][u] != -1)
				{
					System.out.print("Shortest Path from vertex " + v +
							" to vertex " + u + " is (" + v + " ");
					printPath(path, v, u);
					System.out.println(+u + ")");
				}
			}
		}
	}

	// Function to run Floyd's algorithm
	public static void Floyd(int[][] adjMatrix, int N)
	{
		// cost[] and parent[] stores shortest-path
		// (shortest-cost/shortest route) information
		int[][] cost = new int[N][N];
		int[][] path = new int[N][N];

		// initialize cost[] and parent[]
		for (int v = 0; v < N; v++)
		{
			for (int u = 0; u < N; u++)
			{
				// initally cost would be same as weight
				// of the edge
				cost[v][u] = adjMatrix[v][u];

				if (v == u)
					path[v][u] = 0;
				else if (cost[v][u] != Integer.MAX_VALUE)
					path[v][u] = v;
				else
					path[v][u] = -1;
			}
		}

		// run Floyd's
		for (int k = 0; k < N; k++)
		{
			for (int v = 0; v < N; v++)
			{
				for (int u = 0; u < N; u++)
				{
					// If vertex k is on the shortest path from v to u,
					// then update the value of cost[v][u], path[v][u]

					if (cost[v][k] != Integer.MAX_VALUE
							&& cost[k][u] != Integer.MAX_VALUE
							&& (cost[v][k] + cost[k][u] < cost[v][u]))
					{
						cost[v][u] = cost[v][k] + cost[k][u];
						path[v][u] = path[k][u];
					}
				}

				// if diagonal elements become negative, the
				// graph contains a negative weight cycle
				if (cost[v][v] < 0)
				{
					System.out.println("Negative Weight Cycle Found!!");
					return;
				}
			}
		}

		// Print the shortest path between all pairs of vertices
		printSolution(cost, path, N);
	}

	public static void main(String[] args)
	{
		// Number of vertices in the adjMatrix
		final int N = 5;
		int M = Integer.MAX_VALUE;

		// given adjacency representation of matrix
		int[][] adjMatrix = new int[][]
		{
			{ 0, 1, M, 1, 5 },
			{ 9, 0, 3, 2, M },
			{ M, M, 0, 4, M },
			{ M, M, 2, 0, 3 },
         { 3, M, M, M, 0 }
		};

		// Run Floyd's algorithm
		Floyd(adjMatrix, N);
	}
}