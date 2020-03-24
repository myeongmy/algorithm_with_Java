//[모의 SW 역량테스트] 숫자 만들기
//브루트 포스 문제(next_permutation 이용)
/*선표는 게임을 통해 사칙 연산을 공부하고 있다.

N개의 숫자가 적혀 있는 게임 판이 있고, +, -, x, / 의 연산자 카드를 숫자 사이에 끼워 넣어 다양한 결과 값을 구해보기로 했다.

수식을 계산할 때 연산자의 우선 순위는 고려하지 않고 왼쪽에서 오른쪽으로 차례대로 계산한다.

예를 들어 1, 2, 3 이 적힌 게임 판에 +와 x를 넣어 1 + 2 * 3을 만들면 1 + 2를 먼저 계산하고 그 뒤에 * 를 계산한다.

즉 1+2*3의 결과는 9이다.
 

주어진 연산자 카드를 사용하여 수식을 계산했을 때 그 결과가 최대가 되는 수식과 최소가 되는 수식을 찾고, 두 값의 차이를 출력하시오.


[예시]

[Figure 1] 과 같이 [3,5,3,7,9]가 적힌 숫자판과 [‘+’ 2개, ‘-‘ 1개, ‘/’ 1개]의 연산자 카드가 주어진 경우를 생각해보자.


[Figure 1]

 

아래 [Table 1]은 만들 수 있는 수식과 계산 결과이다.

                   

수식

수식의 계산 결과

3 + 5 + 3 - 7 / 9

0

3 + 5 + 3 / 7 - 9

-8

3 + 5 - 3 + 7 / 9

1

3 + 5 - 3 / 7 + 9

9

3 + 5 / 3 + 7 - 9

0

3 + 5 / 3 - 7 + 9

4

3 / 5 + 3 + 7 - 9

1

3 / 5 + 3 - 7 + 9

5

3 / 5 - 3 + 7 + 9

13

3 - 5 + 3 + 7 / 9

0

3 - 5 + 3 / 7 + 9

9

3 - 5 / 3 + 7 + 9

16

                                   [Table 1]
 

이 경우 최댓값은 3 - 5 / 3 + 7 + 9 = 16, 최솟값은 3 + 5 + 3 / 7 - 9 = -8 이다.

즉 결과는 최댓값과 최솟값의 차이 ( 16 - ( -8 ) ) 로 24 가 답이 된다.

 

[제약사항]

1. 시간 제한 : 최대 50 개 테스트 케이스를 모두 통과하는 데 C / C++ / Java 모두 3 초

2. 게임 판에 적힌 숫자의 개수 N 은 3 이상 12 이하의 정수이다. ( 3 ≤ N ≤ 12 )

3. 연산자 카드 개수의 총 합은 항상 N - 1 이다.

4. 게임 판에 적힌 숫자는 1 이상 9 이하의 정수이다.

5. 수식을 완성할 때 각 연산자 카드를 모두 사용해야 한다..

6. 숫자와 숫자 사이에는 연산자가 1 개만 들어가야 한다.

7. 완성된 수식을 계산할 때 연산자의 우선 순위는 고려하지 않고, 왼쪽에서 오른쪽으로 차례대로 계산한다.

8. 나눗셈을 계산 할 때 소수점 이하는 버린다.

9. 입력으로 주어지는 숫자의 순서는 변경할 수 없다.

10. 연산 중의 값은 -100,000,000 이상 100,000,000 이하임이 보장된다.

 

[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T 가 주어지고,

그 다음 줄부터 T 개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 숫자의 개수 N 이 주어진다.

다음 줄에는 '+', '-', '*', '/' 순서대로 연산자 카드의 개수가 공백을 사이에 두고 주어진다.

다음 줄에는 수식에 들어가는 N 개의 숫자가 순서대로 공백을 사이에 두고 주어진다.
 

[출력]

테스트 케이스 개수만큼 T 개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.

각 줄은 "#t" 로 시작하고 공백을 하나 둔 다음 정답을 출력한다. ( t 는 1 부터 시작하는 테스트 케이스의 번호이다. )

정답은 연산자 카드를 사용하여 만들 수 있는 수식으로 얻은 결과값 중 최댓값과 최솟값의 차이이다.*/

package 삼성SW역량테스트기출;

import java.io.*;
import java.util.*;

public class SWEA_4008 {
	static boolean next_permutation(int[] result) {
		// 내림차순 찾기
		int i;
		for (i = result.length - 2; i >= 0; i--) {
			if (result[i] < result[i + 1])
				break;
		}
		if (i == -1)
			return false;
		int idx = 0; // 바꿀 인덱스 위치
		int j;
		for (j = i + 1; j < result.length; j++) {
			if (result[i] < result[j])
				idx = j;
		}
		int temp = result[i];
		result[i] = result[idx];
		result[idx] = temp;
		// 오름차순 정렬
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int k = i + 1; k < result.length; k++)
			list.add(result[k]);

		Collections.sort(list);
		for (int k = i + 1; k < result.length; k++)
			result[k] = list.remove(0);
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				int[] operator = new int[4];
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < 4; j++)
					operator[j] = Integer.parseInt(arr[j]);

				int[] A = new int[N];
				String[] arr1 = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
					A[j] = Integer.parseInt(arr1[j]);

				int[] result = new int[N - 1];
				int idx = 0;
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < operator[j]; k++) {
						result[idx] = j; // 0: +, 1: -, *: 2, / : 3
						idx++;
					}
				}
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;

				do {
					int total = A[0];
					for (int j = 1; j < N; j++) {
						if (result[j - 1] == 0) {
							total += A[j];
						} else if (result[j - 1] == 1) {
							total -= A[j];
						} else if (result[j - 1] == 2) {
							total *= A[j];
						} else if (result[j - 1] == 3) {
							total /= A[j];
						}
					}
					if (min > total)
						min = total;
					if (max < total)
						max = total;

				} while (next_permutation(result));
				System.out.println("#" + (i + 1) + " " + (max - min));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
