//백준 16929번
/*문제
Two Dots는 Playdots, Inc.에서 만든 게임이다. 게임의 기초 단계는 크기가 N×M인 게임판 위에서 진행된다.



각각의 칸은 색이 칠해진 공이 하나씩 있다. 이 게임의 핵심은 같은 색으로 이루어진 사이클을 찾는 것이다.

다음은 위의 게임판에서 만들 수 있는 사이클의 예시이다.

	
점 k개 d1, d2, ..., dk로 이루어진 사이클의 정의는 아래와 같다.

모든 k개의 점은 서로 다르다. 
k는 4보다 크거나 같다.
모든 점의 색은 같다.
모든 1 ≤ i ≤ k-1에 대해서, di와 di+1은 인접하다. 또, dk와 d1도 인접해야 한다. 두 점이 인접하다는 것은 각각의 점이 들어있는 칸이 변을 공유한다는 의미이다.
게임판의 상태가 주어졌을 때, 사이클이 존재하는지 아닌지 구해보자.

입력
첫째 줄에 게임판의 크기 N, M이 주어진다. 둘째 줄부터 N개의 줄에 게임판의 상태가 주어진다. 게임판은 모두 점으로 가득차 있고, 게임판의 상태는 점의 색을 의미한다. 점의 색은 알파벳 대문자 한 글자이다.

출력
사이클이 존재하는 경우에는 "Yes", 없는 경우에는 "No"를 출력한다.*/

package 백준;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_16929 {
	static int[][] c = new int[50][50]; // 방문 여부 저장
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void dfs(int i, int j, int selected, char[][] A, Point[] result) {
		if (selected >= 4) {
			if (Math.abs(result[selected - 1].i - result[0].i) + Math.abs(result[selected - 1].j - result[0].j) == 1) {
				System.out.println("Yes");
				System.exit(0);
			}
			
		}
		for (int v = 0; v < dx.length; v++) {
			if (i + dx[v] >= 0 && i + dx[v] < A.length && j + dy[v] >= 0 && j + dy[v] < A[0].length) {
				if (A[i + dx[v]][j + dy[v]] == A[i][j] && c[i + dx[v]][j + dy[v]] == 0) {
					result[selected] = new Point(i + dx[v], j + dy[v]);
					c[i + dx[v]][j + dy[v]] = 1;
					dfs(i + dx[v], j + dy[v], selected + 1, A, result);
					c[i + dx[v]][j + dy[v]] = 0;
				}
			}
		}
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		char[][] A = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = s.next();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Point[] result = new Point[3000];  //런타임에러의 원인
				result[0] = new Point(i, j);
				c[i][j] = 1;
				dfs(i, j, 1, A, result);

			}
		}
		System.out.println("No");
	}

}
