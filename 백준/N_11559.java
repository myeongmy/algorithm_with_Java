//백준 11559번
//DFS 문제
/*문제
뿌요뿌요의 룰은 다음과 같다.

필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.

뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.

뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.

아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.

터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

남규는 최근 뿌요뿌요 게임에 푹 빠졌다. 이 게임은 1:1로 붙는 대전게임이라 잘 쌓는 것도 중요하지만, 상대방이 터뜨린다면 연쇄가 몇 번이 될지 바로 파악할 수 있는 능력도 필요하다. 하지만 아직 실력이 부족하여 남규는 자기 필드에만 신경 쓰기 바쁘다. 상대방의 필드가 주어졌을 때, 연쇄가 몇 번 연속으로 일어날지 계산하여 남규를 도와주자!

입력
12*6의 문자가 주어진다.

이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.

R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.(모두 대문자로 주어진다.)

입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태(즉 뿌요 아래에 빈 칸이 있는 경우는 없음) 이다.

출력
현재 주어진 상황에서 몇연쇄가 되는지 출력하라. (하나도 터지지 않는다면 0을 출력하면 된다.)*/

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

public class N_11559 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int connectedCom = 0;
	static LinkedList<Point> list = new LinkedList<Point>();

	static void dfs(int i, int j, char[][] A, int[][] c) {
		c[i][j] = 1;
		connectedCom++;
		list.add(new Point(i, j));

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A[0].length) {
				if (A[i + dx[k]][j + dy[k]] == A[i][j] && c[i + dx[k]][j + dy[k]] == 0) {
					dfs(i + dx[k], j + dy[k], A, c);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		char[][] A = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = s.next();
			for (int j = 0; j < 6; j++) {
				A[i][j] = str.charAt(j);
			}
		}
		// dfs 풀이
		int result = 0;
		while (true) {
			int[][] c = new int[12][6];
			int flag = 0; // 더 이상 깨뜨릴 것이 있는지 여부
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (A[i][j] != '.' && c[i][j] == 0) {
						connectedCom = 0;
						dfs(i, j, A, c);
						if (connectedCom >= 4) {
							flag = 1;
							for (int k = 0; k < list.size(); k++) {
								A[list.get(k).i][list.get(k).j] = '.';
							}
						}
						list.clear();
					}
				}
			}
			if(flag == 1)
				result++;
			if (flag == 0)
				break;
			// 내리기
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (A[i][j] != '.') {
						int next_i = i;
						while (true) {
							if (next_i + 1 >= 12 || A[next_i + 1][j] != '.')
								break;
							next_i++;
						}
						if (next_i != i) {
							A[next_i][j] = A[i][j];
							A[i][j] = '.';
						}
					}
				}
			}
		}
		System.out.println(result);
	}

}
