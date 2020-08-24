//브루트 포스
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int numPaper = Integer.parseInt(br.readLine());
			int[][] arr = new int[101][101];

			for (int i = 0; i < numPaper; i++) {
				String[] argument = br.readLine().split(" ");

				int si = Integer.parseInt(argument[0]);
				int sj = Integer.parseInt(argument[1]);

				for (int j = si; j < si + 10; j++) {
					for (int k = sj; k < sj + 10; k++) {
						arr[j][k]++;
					}
				}
			}

			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] != 0)
						count++;
				}
			}

			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
