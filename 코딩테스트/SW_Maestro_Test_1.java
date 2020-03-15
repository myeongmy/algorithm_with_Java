//가장 큰 숫자 (코드포스 문제와 동일 https://codeforces.com/problemset/problem/1295/A)
// 내가 시험 때 푼 방법은 n이하가 될 수 있는 모든 경우를 완전 탐색으로 구하기 -> n이 1000이하라서 시간 초과

package 코딩테스트;

import java.util.*;

public class SW_Maestro_Test_1 {
	static int[] result = new int[1004];
	static int[] A = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
	static int sum = 0;
	static int max = Integer.MIN_VALUE;

	// 1. 완전 탐색 방법 -> 시간 초과
	/*static void go(int index, int n) {
		if (sum != 0) {
			int idx = 0;
			StringBuilder sb = new StringBuilder();
			while (result[idx] != -1) {
				sb.append(result[idx]);
				idx++;
			}
			if (max < Integer.parseInt(sb.toString()))
				max = Integer.parseInt(sb.toString());
		}
		for (int i = 0; i < 10; i++) {
			if (sum + A[i] <= n) {
				result[index] = i;
				sum += A[i];
				go(index + 1, n);
				sum -= A[i];
				result[index] = -1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < 1004; i++)
			result[i] = -1;
		for (int i = 0; i < T; i++) {
			int n = s.nextInt();
			go(0, n);
			System.out.println(max);
			max = Integer.MIN_VALUE;
		}
	}*/
	
	// 2. 동적계획법이자 그리디
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		/*String [] d = new String[100003];   //d[n] : n이하로 표현할 수 있는 숫자의 최댓값
		d[2] = "1";
		d[3] = "7";
		d[4] = "11";
		for(int i=5;i<=100000;i++) {
			d[i] = d[i-2] + d[2];
		}
		for(int i=0;i<T;i++) {
			int n = s.nextInt();
			System.out.println(d[n]);
		}*/
		
		// append 할 때는 str이 아닌 무조건 stringbuilder 사용하기
		for(int i=0;i<T;i++) {
			int n = s.nextInt();
			StringBuilder sb= new StringBuilder();
			if(n%2 == 0) {
				for(int j=0;j<n/2;j++) {
					sb.append(1);
				}
			}else {
				sb.append(7);
				for(int j=0;j<(n-3)/2;j++) {
					sb.append(1);
				}
			}
			System.out.println(sb);
		}
	}

}
