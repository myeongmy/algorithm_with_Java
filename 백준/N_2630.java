//백준 2630번 색종이 만들기
// 브루트 포스(재귀)

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2630 {
	static int blueCnt = 0;
	static int whiteCnt = 0;

	static void go(int N, int[][] arr) { // N: 정사각형 한 변의 길이
		if (arr.length == 1 && arr[0][0] == 0) {
			whiteCnt++;
			return;
		}
		if (arr.length == 1 && arr[0][0] == 1) {
			blueCnt++;
			return;
		}

		// 정사각형 전체가 같은 색으로 이루어져 있는지 확인
		int whiteNum = 0;
		int blueNum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0)
					whiteNum++;
				else
					blueNum++;
			}
		}

		if (blueNum == arr.length * arr.length) {
			blueCnt++;
			return;
		}
		if (whiteNum == arr.length * arr.length) {
			whiteCnt++;
			return;
		}

		// N/2 크기의 색종이 4개 생성
		int[][] child = new int[arr.length / 2][arr.length / 2];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				child[i][j] = arr[i][j];
			}
		}
		go(N / 2, child);

		for (int i = 0; i < N / 2; i++) {
			for (int j = N / 2; j < N; j++) {
				child[i][j - N / 2] = arr[i][j];
			}
		}
		go(N / 2, child);

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < N / 2; j++) {
				child[i - N / 2][j] = arr[i][j];
			}
		}
		go(N / 2, child);

		for (int i = N / 2; i < N; i++) {
			for (int j = N / 2; j < N; j++) {
				child[i - N / 2][j - N / 2] = arr[i][j];
			}
		}
		go(N / 2, child);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] arg = br.readLine().split(" ");

				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(arg[j]);
				}
			}

			go(N, arr);
			System.out.println(whiteCnt);
			System.out.println(blueCnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
