//백준 11053번
/*문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.*/

package codingtest_study.백준;

import java.io.*;

public class N_11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int[] A = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				A[i] = Integer.parseInt(arr[i]);
			}
			int[] d = new int[A.length];
			d[0] = 1;
			for (int i = 1; i < A.length; i++) {
				d[i] = 1;
				for (int j = i - 1; j >= 0; j--) {
					if (A[j] < A[i] && d[i] < d[j] + 1)
						d[i] = d[j] + 1;
				}
			}
			int max = 0;
			for (int num : d) {
				if (max < num)
					max = num;
			}
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
