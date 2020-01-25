//백준 10972번
/*문제
1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.

사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.

N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.

1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
입력
첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.

출력
첫째 줄에 입력으로 주어진 순열의 다음에 오는 순열을 출력한다. 만약, 사전순으로 마지막에 오는 순열인 경우에는 -1을 출력한다.*/

package 백준;

import java.util.Scanner;

public class N_10972 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();

		// 마지막 내림차순 구하기
		int index;
		for (index = A.length-1; index >= 0; index--) {
			if (index == 0) {
				System.out.println(-1);
				System.exit(0);
			}
			if (A[index] < A[index - 1])
				continue;
			break;
		}

		// 자리 바꿀 요소 정하기
		int i;
		for (i = index; i < A.length; i++) {
			if (A[index - 1] > A[i])
				break;
		}

		// 자리 바꾸기
		int temp = A[index - 1];
		A[index - 1] = A[i - 1];
		A[i - 1] = temp;

		for (int j = 0; j <= index - 1; j++) {
			System.out.print(A[j] + " ");
		}
		for (int j = A.length-1; j >= index; j--) {
			System.out.print(A[j] + " ");
		}
	}

}
