//sw expert academy 5213
//테스트 케이스가 1000000개 이므로 미리 약수를 다 계산해두는 방법이 최적화
// 약수 구할 때는 전체 탐색 말고 
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
			arr[i] += arr[i - 1]; // 이전 값 포함해서 저장해야 나중에 -만으로 쉽게 계산 가능!
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
