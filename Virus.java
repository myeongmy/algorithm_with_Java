package codingtest_study;

import java.util.Scanner;

public class Virus {
	static Scanner s = new Scanner(System.in);
	static int numOfComputer = s.nextInt();
	static int[][] edgeArray = new int[numOfComputer + 1][numOfComputer + 1];
	static int[] visited = new int[numOfComputer + 1];
	static int numOfEdge = s.nextInt();
	static int result = 0;

	public static void dfs(int v) {
		if (visited[v] == 1)
			return;
		visited[v] = 1;

		for (int i = 1; i < visited.length; i++) {
			if (edgeArray[v][i] == 1 && visited[i] == 0) {

				result += 1;
				dfs(i);

			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < numOfEdge; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			edgeArray[a][b] = 1;
			edgeArray[b][a] = 1;
		}
		dfs(1);
		System.out.println(result);
	}

}
