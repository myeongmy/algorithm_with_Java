//���� ū ���� (�ڵ����� ������ ���� https://codeforces.com/problemset/problem/1295/A)
// ���� ���� �� Ǭ ����� n���ϰ� �� �� �ִ� ��� ��츦 ���� Ž������ ���ϱ� -> n�� 1000���϶� �ð� �ʰ�

package �ڵ��׽�Ʈ;

import java.util.*;

public class SW_Maestro_Test_1 {
	static int[] result = new int[1004];
	static int[] A = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
	static int sum = 0;
	static int max = Integer.MIN_VALUE;

	// 1. ���� Ž�� ��� -> �ð� �ʰ�
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
	
	// 2. ������ȹ������ �׸���
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		/*String [] d = new String[100003];   //d[n] : n���Ϸ� ǥ���� �� �ִ� ������ �ִ�
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
		
		// append �� ���� str�� �ƴ� ������ stringbuilder ����ϱ�
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
