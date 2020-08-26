//백준 6580번 쿼드 트리
//문자열 처리 + 재귀

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class N_6580 {
	static StringBuilder sb = new StringBuilder();
	static int[][] A;
	static StringBuilder totalStr = new StringBuilder();

	static void binary(int result) {
		if (result == 0)
			return;

		sb.append(result % 2);
		binary(result / 2);

	}

	static void dfs(int n, int[][] A) {
		// 해당 배열이 지금 모두 같은 색인지 확인
		int whiteNum = 0;
		int blackNum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == 0)
					whiteNum++;
				else if (A[i][j] == 1)
					blackNum++;
			}
		}

		if (whiteNum == n * n || blackNum == n * n) {
			if (whiteNum != 0)
				totalStr.append("W");
			else if (blackNum != 0)
				totalStr.append("B");

			return;
		}

		totalStr.append("Q");
		int[][] B = new int[n / 2][n / 2];

		// 왼쪽 위
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B.length; j++) {
				B[i][j] = A[i][j];
			}
		}
		dfs(n / 2, B);
		// 오른쪽 위
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B.length; j++) {
				B[i][j] = A[i][j + n / 2];
			}
		}
		dfs(n / 2, B);
		// 왼쪽 아래
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B.length; j++) {
				B[i][j] = A[i + n / 2][j];
			}
		}
		dfs(n / 2, B);
		// 오른쪽 아래
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B.length; j++) {
				B[i][j] = A[i + n / 2][j + n / 2];
			}
		}
		dfs(n / 2, B);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int row = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('0', 0);
		hm.put('1', 1);
		hm.put('2', 2);
		hm.put('3', 3);
		hm.put('4', 4);
		hm.put('5', 5);
		hm.put('6', 6);
		hm.put('7', 7);
		hm.put('8', 8);
		hm.put('9', 9);
		hm.put('a', 10);
		hm.put('b', 11);
		hm.put('c', 12);
		hm.put('d', 13);
		hm.put('e', 14);
		hm.put('f', 15);

		try {
			while (true) {
				String str = br.readLine();
				if (str.equals("};"))
					break;

				if (str.startsWith("#define")) { // 가로, 세로 픽셀 수
					String[] arr = str.split(" ");
					n = Integer.parseInt(arr[2]);
					A = new int[n][n];

				} else if (str.startsWith("static")) {
					continue;

				} else {
					int col = 0;

					String[] input = str.split(",");

					for (int i = 0; i < input.length; i++) {
						int result = hm.get(input[i].charAt(2)) * 16 + hm.get(input[i].charAt(3));

						binary(result);
						while (sb.length() != 8)
							sb.append(0);

						for (int j = 0; j < sb.length(); j++) {
							A[row][col] = sb.charAt(j) - 48;
							col++;
						}
						sb.delete(0, sb.length());
					}

					row++;
				}
			}

			dfs(n, A);

			System.out.println(n);
			System.out.println(totalStr.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
