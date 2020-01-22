//백준 15666번
/*문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.*/

package 백준;

import java.io.*;
import java.util.*;

public class N_15666 {
	static int[] result = new int[10];
	static LinkedHashSet<String> hs = new LinkedHashSet<String>();
	static StringBuilder sb = new StringBuilder();

	static void go(int index, int start, int[] A, int N, int M) {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			hs.add(sb.toString());
			return;
		}
		for (int i = start; i < N; i++) {
			result[index] = A[i];
			go(index + 1, i, A, N, M);
			result[index] = 0;
			sb.setLength(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			arr = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i = 0; i < arr.length; i++)
				A[i] = Integer.parseInt(arr[i]);

			Arrays.sort(A);
			go(0, 0, A, N, M);
			Iterator<String> it = hs.iterator();
			while (it.hasNext())
				System.out.println(it.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
