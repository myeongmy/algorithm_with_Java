//백준 15684번(사다리 조작)
//완전탐색과 시뮬레이션 문제
/*문제
사다리 게임은 N개의 세로선과 M개의 가로선으로 이루어져 있다. 인접한 세로선 사이에는 가로선을 놓을 수 있는데, 각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수는 H이고, 모든 세로선이 같은 위치를 갖는다. 아래 그림은 N = 5, H = 6 인 경우의 그림이고, 가로선은 없다.



초록선은 세로선을 나타내고, 초록선과 점선이 교차하는 점은 가로선을 놓을 수 있는 점이다. 가로선은 인접한 두 세로선을 연결해야 한다. 단, 두 가로선이 연속하거나 서로 접하면 안 된다. 또, 가로선은 점선 위에 있어야 한다.



위의 그림에는 가로선이 총 5개 있다. 가로선은 위의 그림과 같이 인접한 두 세로선을 연결해야 하고, 가로선을 놓을 수 있는 위치를 연결해야 한다.

사다리 게임은 각각의 세로선마다 게임을 진행하고, 세로선의 가장 위에서부터 아래 방향으로 내려가야 한다. 이때, 가로선을 만나면 가로선을 이용해 옆 세로선으로 이동한 다음, 이동한 세로선에서 아래 방향으로 이동해야 한다.

위의 그림에서 1번은 3번으로, 2번은 2번으로, 3번은 5번으로, 4번은 1번으로, 5번은 4번으로 도착하게 된다. 아래 두 그림은 1번과 2번이 어떻게 이동했는지 나타내는 그림이다.

	
1번 세로선	2번 세로선
사다리에 가로선을 추가해서, 사다리 게임의 결과를 조작하려고 한다. 이때, i번 세로선의 결과가 i번이 나와야 한다. 그렇게 하기 위해서 추가해야 하는 가로선 개수의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선을 놓을 수 있는 위치의 개수 H가 주어진다. (2 ≤ N ≤ 10, 1 ≤ H ≤ 30, 0 ≤ M ≤ (N-1)×H)

둘째 줄부터 M개의 줄에는 가로선의 정보가 한 줄에 하나씩 주어진다.

가로선의 정보는 두 정수 a과 b로 나타낸다. (1 ≤ a ≤ H, 1 ≤ b ≤ N-1) b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미이다.

가장 위에 있는 점선의 번호는 1번이고, 아래로 내려갈 때마다 1이 증가한다. 세로선은 가장 왼쪽에 있는 것의 번호가 1번이고, 오른쪽으로 갈 때마다 1이 증가한다.

입력으로 주어지는 가로선이 서로 연속하는 경우는 없다.

출력
i번 세로선의 결과가 i번이 나오도록 사다리 게임을 조작하려면, 추가해야 하는 가로선 개수의 최솟값을 출력한다. 만약, 정답이 3보다 큰 값이면 -1을 출력한다. 또, 불가능한 경우에도 -1을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_15684 {
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int[][] A;
	static int find = 0;

	static int calc(int[][] A) { // 올바른 사다리인지 검사하는 코드
		for (int i = 1; i <= A[0].length - 1; i++) {
			int h = 0; // 현재 높이
			int line = i; // 현재 라인 번호

			while (h < A.length - 1) {
				h += 1;
				if (A[h][line - 1] == 1) {
					line -= 1;
				} else if (A[h][line] == 1) {
					line += 1;
				}
			}
			if (i != line)
				return -1;
		}
		return 1;
	}

	static void go(int index, int selected, ArrayList<Point> list, int count, int[] c) {
		if (selected == count) {

			if (result.size() >= 2) {
				if (list.get(result.get(0)).i == list.get(result.get(1)).i
						&& Math.abs(list.get(result.get(0)).i - list.get(result.get(1)).j) == 1)
					return;
			}

			int[][] test = new int[A.length][A[0].length];
			for (int i = 0; i < test.length; i++)
				test[i] = A[i].clone();
			for (int i = 0; i < result.size(); i++) {
				test[list.get(result.get(i)).i][list.get(result.get(i)).j] = 1;
			}
			if (calc(test) == 1)
				find = 1;
			return;
		}
		if(index >= list.size()) return;
		result.add(index);
		go(index+1, selected+1, list, count, c);
		result.remove(result.size()-1);
		
		go(index+1, selected, list, count, c);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int H = s.nextInt();
		A = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			A[s.nextInt()][s.nextInt()] = 1;
		}
		ArrayList<Point> list = new ArrayList<Point>(); // 추가 가능한 사다리 위치 저장
		// 사다리 0개 추가했을 때
		if (calc(A) == 1) {
			System.out.println(0);
			System.exit(0);
		}

		// 추가 가능한 사다리 탐색
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N - 1; j++) {
				if (A[i][j] != 1 && A[i][j - 1] != 1 && A[i][j + 1] != 1)
					list.add(new Point(i, j));
			}
		}
		// 사다리 1개 추가하기
		int[] c = new int[list.size()];
		go(0, 0, list, 1, c);
		if (find == 1) {
			System.out.println(1);
			System.exit(0);
		}

		// 사다리 2개 추가하기
		find = 0;
		int[] c1 = new int[list.size()];
		go(0, 0, list, 2, c1);
		if (find == 1) {
			System.out.println(2);
			System.exit(0);
		}
		// 사다리 3개 추가하기
		find = 0;
		int[] c2 = new int[list.size()];
		go(0, 0, list, 3, c1);
		if (find == 1) {
			System.out.println(3);
			System.exit(0);
		}
		System.out.println(-1);

	}

}
