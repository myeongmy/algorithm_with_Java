//백준 3005번 크로스워드 퍼즐 쳐다보기
//브루트 포스

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N_3005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int R = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);

			char[][] A = new char[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					A[i][j] = str.charAt(j);
				}
			}

			List<String> list = new ArrayList<>(); // 후보리스트 저장
			// 가로 탐색
			int[][] c = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (A[i][j] != '#' && c[i][j] == 0) {
						int nextj = j;
						StringBuilder temp = new StringBuilder();

						while (true) {
							if (nextj >= C || A[i][nextj] == '#')
								break;
							temp.append(A[i][nextj]);
							c[i][nextj] = 1;
							nextj++;
						}
						if (temp.length() >= 2)
							list.add(temp.toString());
					}
				}
			}
			// 세로 탐색
			int[][] c1 = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (A[i][j] != '#' && c1[i][j] == 0) {
						int nexti = i;
						StringBuilder temp = new StringBuilder();

						while (true) {
							if (nexti >= R || A[nexti][j] == '#')
								break;
							temp.append(A[nexti][j]);
							c1[nexti][j] = 1;
							nexti++;
						}
						if (temp.length() >= 2)
							list.add(temp.toString());
					}
				}
			}

			Collections.sort(list);
			System.out.println(list.get(0));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
