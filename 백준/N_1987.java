//백준 1987번 알파벳
//백트래킹

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_1987 {
	static char[][] A;
	static int [] c = new int[26];    //해당 알파벳 방문 여부 체크
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max = Integer.MIN_VALUE;
	static int horseNum = 1;
	
	static void go(int i, int j) {
		if(max < horseNum)
			max = horseNum;
		
		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A[0].length) {
				if (c[A[i+dx[k]][j+dy[k]] - 65] == 0) {
					c[A[i+dx[k]][j+dy[k]] - 65] = 1;
					horseNum++;
					go(i+dx[k], j+dy[k]);
					horseNum--;
					c[A[i+dx[k]][j+dy[k]] - 65] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] input = br.readLine().split(" ");
			int R = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);

			A = new char[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();

				for (int j = 0; j < C; j++) {
					A[i][j] = str.charAt(j);
				}
			}

			c[A[0][0] - 65] = 1;
			go(0, 0);
			System.out.println(max);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
