//[모의 SW 역량테스트] 벌꿀채취
//브루트 포스 문제
/*N*N 개의 벌통이 정사각형 모양으로 배치되어 있다.

각 칸의 숫자는 각각의 벌통에 있는 꿀의 양을 나타내며, 꿀의 양은 서로 다를 수 있다.

아래 [Fig. 1]은 N=4인 16개의 벌통을 나타낸다.

         


[Fig. 1]


각 벌통에 있는 꿀의 양이 주어졌을 때, 다음과 같은 과정으로 벌꿀을 채취하여 최대한 많은 수익을 얻으려고 한다.

   ① 두 명의 일꾼이 있다. 꿀을 채취할 수 있는 벌통의 수 M이 주어질 때, 
       각각의 일꾼은 가로로 연속되도록 M개의 벌통을 선택하고, 선택한 벌통에서 꿀을 채취할 수 있다.
       단, 두 명의 일꾼이 선택한 벌통은 서로 겹치면 안 된다. 

       아래 [Fig. 2]는 M=2일 때, 두 일꾼이 각각 벌통을 선택하는 다양한 예를 보여준다.
 
 

[Fig. 2]


   ② 두 명의 일꾼은 선택한 벌통에서 꿀을 채취하여 용기에 담아야 한다.
       단, 서로 다른 벌통에서 채취한 꿀이 섞이게 되면 상품가치가 떨이지게 되므로, 하나의 벌통에서 채취한 꿀은 하나의 용기에 담아야 한다.
       하나의 벌통에서 꿀을 채취할 때, 일부분만 채취할 수 없고 벌통에 있는 모든 꿀을 한번에 채취해야 한다.
       두 일꾼이 채취할 수 있는 꿀의 최대 양은 C 이다.


예를 들어, 아래 [Fig. 3]에서 C=10이고, 두 명의 일꾼이 선택한 벌통이 그림과 같을 때,

첫 번째 일꾼은 꿀의 양이 6과 1인 두 개의 벌통에서 모두 꿀을 채취할 수 있다.

하지만 두 번째 일꾼은 꿀의 양이 8과 5인 두 개의 벌통에서 모두 꿀을 채취할 경우,

채취한 꿀의 양이 13이 되어 C=10을 초과하기 때문에 두 개의 벌통에서 모두 꿀을 채취할 수 없다.

따라서 두 번째 일꾼은 꿀의 양이 8과 5인 벌통 중 하나를 선택하여 꿀을 채취해야 한다.

[Fig. 3]은 그 중 한 예를 보여주고 있다.
 
 

[Fig. 3]


   ③ 채취한 꿀은 시장에서 팔리게 된다. 이때 하나의 용기에 있는 꿀의 양이 많을수록 상품가치가 높아, 각 용기에 있는 꿀의 양의 제곱만큼의 수익이 생긴다.
       예를 들어 위 [Fig. 3]과 같이 꿀을 채취할 경우, 꿀의 양이 6, 1, 8인 세 개의 용기가 얻어지며 이때 수익의 합은, (6*6) + (1*1) + (8*8) = 36 + 1 + 64 = 101 이 된다.


벌통들의 크기 N과 벌통에 있는 꿀의 양에 대한 정보, 선택할 수 있는 벌통의 개수 M, 꿀을 채취할 수 있는 최대 양 C가 주어진다.

이때 두 일꾼이 꿀을 채취하여 얻을 수 있는 수익의 합이 최대가 되는 경우를 찾고, 그 때의 최대 수익을 출력하는 프로그램을 작성하라.


[예시 1]

벌통들의 크기 N=4, 선택할 수 있는 벌통의 개수 M=2, 채취할 수 있는 꿀의 최대 양 C=13 이고,

아래 [Fig. 4]와 같이 벌통에 있는 꿀의 양의 정보가 주어진 경우를 보자.

최대 수익을 얻을 수 있는 경우 중 하나로 [Fig. 4]와 같이 벌통을 선택하여 선택하여 꿀을 채취하게 되면, 총 수익이 174가 되어 최대가 된다.

따라서 이 경우 정답은 174이다.

 

[Fig. 4]


[예시 2]

벌통의 크기 N=3, 선택할 수 있는 벌통의 개수 M=3, 채취할 수 있는 꿀의 최대 양 C=10 이고,

아래 [Fig. 5]와 같이 벌통에 있는 꿀의 양의 정보가 주어진 경우를 보자.

최대 수익을 얻을 수 있는 경우 중 하나로 [Fig. 5]와 같이 벌통을 선택하여 꿀을 채취하게 되면, 총 수익이 131이 되어 최대가 된다.

따라서 이 경우 정답은 131이다.
 
 

[Fig. 5]


[제약사항]

1. 시간제한 : 최대 50개 테스트 케이스를 모두 통과하는데, C/C++/Java 모두 3초.

2. 벌통들의 크기 N은 3 이상 10 이하의 정수이다. (3 ≤ N ≤ 10)

3. 선택할 수 있는 벌통의 개수 M은 1 이상 5 이하의 정수이다. (1 ≤ M ≤ 5)

4. 선택할 수 있는 벌통의 개수 M은 반드시 N 이하로만 주어진다.

5. 꿀을 채취할 수 있는 최대 양 C는 10 이상 30 이하의 정수이다. (10 ≤ C ≤ 30)

6. 하나의 벌통에서 채취할 수 있는 꿀의 양은 1 이상 9 이하의 정수이다.

7. 하나의 벌통에서 일부분의 꿀만 채취할 수 없고, 벌통에 있는 모든 꿀을 한번에 채취해야 한다.


[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 벌통들의 크기 N, 선택할 수 있는 벌통의 개수 M, 꿀을 채취할 수 있는 최대 양 C가 차례로 주어진다.

그 다음 줄부터 N*N 개의 벌통에서 채취할 수 있는 꿀의 양에 대한 정보가 주어진다.


[출력]

테스트 케이스의 개수만큼 T줄에 T개의 테스트 케이스 각각에 대한 답을 출력한다.

각 줄은 "#x"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (x는 1부터 시작하는 테스트 케이스의 번호이다)

출력해야 할 정답은 두 일꾼이 꿀을 채취하여 얻을 수 있는 최대 수익이다.*/

package 삼성SW역량테스트기출;

import java.io.*;
import java.util.*;

class Popo {
	int i;
	int j;

	Popo(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class SWEA_2115 {
	static ArrayList<Popo> list = new ArrayList<Popo>(); // 2개의 시자점 선택
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int max = Integer.MIN_VALUE;
	static int powMax = 0;
	static int total = Integer.MIN_VALUE;

	static void go1(int index, int sum, ArrayList<Integer> first, int C) {
		if (index == first.size()) {
			if (sum > C)
				return;
			int powMax = 0;
			for (int i = 0; i < result.size(); i++)
				powMax += Math.pow(result.get(i), 2);
			if (max < powMax) {
				max = powMax;
			}

			return;
		}
		result.add(first.get(index));
		sum += first.get(index);
		go1(index + 1, sum, first, C);
		result.remove(result.size() - 1);
		sum -= first.get(index);

		go1(index + 1, sum, first, C);
	}

	static void go(int i, int j, int[][] A, int M, int C) {
		if (list.size() == 2) {
			ArrayList<Integer> first = new ArrayList<Integer>();
			ArrayList<Integer> second = new ArrayList<Integer>();

			for (int k = 0; k < M; k++) {
				first.add(A[list.get(0).i][list.get(0).j + k]);
			}
			for (int k = 0; k < M; k++) {
				second.add(A[list.get(1).i][list.get(1).j + k]);
			}
			int sum = 0;
			go1(0, 0, first, C);
			sum += max;
			max = Integer.MIN_VALUE;
			go1(0, 0, second, C);
			sum += max;
			max = Integer.MIN_VALUE;

			if (total < sum) {
				total = sum;
			}
			return;
		}

		if (i >= A.length)
			return;
		if (j + (M - 1) < A.length) {
			list.add(new Popo(i, j));
			go(i, j + M, A, M, C);
			list.remove(list.size() - 1);

			go(i, j + 1, A, M, C);
		} else {
			go(i + 1, 0, A, M, C);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int N = Integer.parseInt(arr[0]); // 배열 크기
				int M = Integer.parseInt(arr[1]); // 각 일꾼이 선택할 수 있는 벌통의 개수
				int C = Integer.parseInt(arr[2]); // 채취할 수 있는 최대 양

				int[][] A = new int[N][N];
				for (int j = 0; j < N; j++) {
					String[] arr1 = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr1[k]);
					}
				}
				go(0, 0, A, M, C);
				System.out.println("#" + (i + 1) + " " + total);
				total = Integer.MIN_VALUE;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
