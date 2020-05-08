//백준 2230번
//투 포인터 알고리즘 문제 풀이

package 백준;

import java.io.*;
import java.util.*;

public class N_2230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			int[] A = new int[N];
			for (int i = 0; i < N; i++)
				A[i] = Integer.parseInt(br.readLine());
			
			Arrays.sort(A);

			int start = 0;
			int end = 0;
			int min = Integer.MAX_VALUE;

			while (start < N) {
				if (end >= N || Math.abs(A[start] - A[end]) >= M) {
					if (end < N) {
						if (min > Math.abs(A[start] - A[end]))
							min = Math.abs(A[start] - A[end]);
					}

					start++;
				} else if (Math.abs(A[start] - A[end]) < M) {
					end++;
				}
			}
			System.out.println(min);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
