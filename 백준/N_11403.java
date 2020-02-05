//백준 11403번
//DFS 문제
/*문제
가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.

출력
총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.*/

package 백준;

import java.util.*;

public class N_11403 {

	static void dfs(int v, int parent, ArrayList<Integer> [] adlist, int [] c, int [][] isExist) {
		for(int a : adlist[v]) {
			if(c[a] == 0) {
				c[a] = 1;
				isExist[parent][a] = 1;
				dfs(a, parent, adlist, c, isExist);
				c[a] = 0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N];
		for (int i = 0; i < N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (s.nextInt() == 1) {
					adlist[i].add(j);
				}
			}
		}
		int [][] isExist = new int[N][N];
		for(int i=0;i<N;i++) {
			int [] c = new int[N];
			dfs(i, i, adlist, c, isExist);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(isExist[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
