//sw expert academy 5213
//�׽�Ʈ ���̽��� 1000000�� �̹Ƿ� �̸� ����� �� ����صδ� ����� ����ȭ
// ��� ���� ���� ��ü Ž�� ���� 
package codingtest_study;

import java.util.Scanner;

public class JinsuOddEven {
	public static void Calculate(long[] arr) {
		for (int i = 1; i <= 1000000; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (i == 1) {
					arr[i] += 1;
					break;
				}
				if (i % j == 0) {
					if (j % 2 != 0)
						arr[i] += j;
					if (i / j % 2 != 0 && i / j != j)
						arr[i] += i / j;
				}
			}
			arr[i] += arr[i - 1]; // ���� �� �����ؼ� �����ؾ� ���߿� -������ ���� ��� ����!
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = new long[1000001];
		Calculate(arr);
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int L = s.nextInt();
			int R = s.nextInt();

			System.out.println("#" + (i + 1) + " " + (arr[R] - arr[L - 1]));
		}
	}

}
