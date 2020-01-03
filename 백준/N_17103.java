//백준 17103번
/*문제
골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.

입력
첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.

출력
각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.*/

package codingtest_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_17103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] check = new boolean[1000001];
		ArrayList<Integer> prime = new ArrayList<Integer>();
		check[0] = true;
		check[1] = true;
		for (int i = 2; i <= 1000000; i++) {
			if (check[i] == false) {
				prime.add(i);
				for (int j = 2; i * j <= 1000000; j++) {
					check[i * j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());
				int resultNum = 0;
				for (int j = 0; j< prime.size() && prime.get(j) < N; j++) {  //런타임 에러난 부분
					if (check[N - prime.get(j)] == false) {
						if (prime.get(j) <= N - prime.get(j))
							resultNum++;
					}
				}
				System.out.println(resultNum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
