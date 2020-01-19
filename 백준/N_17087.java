//백준 17087번
/*문제
수빈이는 동생 N명과 숨바꼭질을 하고 있다. 수빈이는 현재 점 S에 있고, 동생은 A1, A2, ..., AN에 있다.

수빈이는 걸어서 이동을 할 수 있다. 수빈이의 위치가 X일때 걷는다면 1초 후에 X+D나 X-D로 이동할 수 있다. 수빈이의 위치가 동생이 있는 위치와 같으면, 동생을 찾았다고 한다.

모든 동생을 찾기위해 D의 값을 정하려고 한다. 가능한 D의 최댓값을 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 105)과 S(1 ≤ S ≤ 109)가 주어진다. 둘째 줄에 동생의 위치 Ai(1 ≤ Ai ≤ 109)가 주어진다. 동생의 위치는 모두 다르며, 수빈이의 위치와 같지 않다.

출력
가능한 D값의 최댓값을 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;
import java.util.Stack;

public class N_17087 {
	static long GCD(long a, long b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long S = s.nextLong();
		Stack<Long> st = new Stack<Long>();
		for (int i = 0; i < N; i++) {
			st.push((long) Math.abs(s.nextLong() - S));
		}
		long result = 0;
		while (!st.empty()) {
			if (st.size() == 1) {
				System.out.println(st.pop());
				System.exit(0);
			}
			long a = st.pop();
			long b = st.pop();
			result = GCD(a, b);
			if (!st.empty())
				st.push(result);
		}
		System.out.println(result);
	}

}
