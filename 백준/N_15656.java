//백준 15656번
/*문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.*/

package 백준;

import java.io.*;
import java.util.Arrays;

public class N_15656 {
	static int[] result = new int[10];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void go(int index, int[] A, int N, int M) throws IOException {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				bw.write(Integer.toString(result[i]) + " ");
			}
			bw.newLine();
			return;
		}
		for (int a : A) {
			result[index] = a;
			go(index + 1, A, N, M);
			result[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int[] A = new int[N];
			arr = br.readLine().split(" ");
			for (int i = 0; i < arr.length; i++) {
				A[i] = Integer.parseInt(arr[i]);
			}
			Arrays.sort(A);
			go(0, A, N, M);

			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
