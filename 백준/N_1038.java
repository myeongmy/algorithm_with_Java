//백준 1038번
//브루트 포스 문제 (감소하는 수 or 증가하는 수 = 조합으로 모두 구할 수 있다. 1024개니까 시간 초과 걱정 nono)
/*문제
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 N번째 감소하는 수를 출력한다.*/

package 백준;

import java.util.*;

public class N_1038 {
	static LinkedList<Integer> result = new LinkedList<Integer>();
	static ArrayList<Long> list = new ArrayList<Long>();

	static void go(int index) {
		if (index == 10) {
			if (result.size() == 0)
				return;

			Collections.sort(result);
			StringBuilder sb = new StringBuilder();

			for (int i = result.size() - 1; i >= 0; i--) {
				sb.append(result.get(i));
			}
			list.add(Long.parseLong(sb.toString()));
			return;
		}
		result.add(index);
		go(index + 1);
		result.remove(result.size() - 1);

		go(index + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		go(0);
		Collections.sort(list);

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		if (N >= 1023) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(N));
		}

	}

}
