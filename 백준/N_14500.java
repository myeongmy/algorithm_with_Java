//백준 14500번
/*문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.*/

package 백준;

import java.util.Scanner;

public class N_14500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		int result = 0;
		// 1번째 블록
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 3; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
				if (result < num)
					result = num;
			}
		}

		// 2번째 블록
		for (int i = 0; i < N - 3; i++) {
			for (int j = 0; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
				if (result < num)
					result = num;
			}
		}

		// 3번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 4번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 2][j];
				if (result < num)
					result = num;
			}
		}

		// 5번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 6번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j - 1];
				if (result < num)
					result = num;
			}
		}

		// 7번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j];
				if (result < num)
					result = num;
			}
		}

		// 8번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2];
				if (result < num)
					result = num;
			}
		}

		// 9번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 10번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 2; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 1][j - 2];
				if (result < num)
					result = num;
			}
		}

		// 11번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
				if (result < num)
					result = num;
			}
		}

		// 12번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 13번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j - 1];
				if (result < num)
					result = num;
			}
		}

		// 14번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 2; j < M; j++) {
				int num = arr[i][j] + arr[i][j - 1] + arr[i + 1][j - 1] + arr[i + 1][j - 2];
				if (result < num)
					result = num;
			}
		}

		// 15번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
				if (result < num)
					result = num;
			}
		}

		// 16번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 17번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j];
				if (result < num)
					result = num;
			}
		}

		// 18번째 블록
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 19번째 블록
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j];
				if (result < num)
					result = num;
			}
		}
		System.out.println(result);
	}

}
