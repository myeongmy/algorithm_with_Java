//백준 1935번
/*문제
후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.

입력
첫째 줄에 피연산자의 개수(1 ≤ N ≤ 26) 가 주어진다. 그리고 둘째 줄에는 후위 표기식이 주어진다. (여기서 피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다) 그리고 셋째 줄부터 N+2번째 줄까지는 각 피연산자에 대응하는 값이 주어진다. (3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B에 해당하는값 , 5번째 줄에는 C ...이 주어진다, 그리고 피연산자에 대응 하는 값은 정수이다)

출력
계산 결과를 소숫점 둘째 자리까지 출력한다.*/

package codingtest_study.백준;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class N_1935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		Stack<Double> st = new Stack<Double>();
		int N = s.nextInt();
		String sentence = s.next();

		for (int i = 0; i < N; i++) {
			char start = (char) ('A' + i); // 덧셈 연산 시 int보다 작은 타입은 int로 변홛되어 연산됨
			hm.put(start, s.nextInt());
		}
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') {
				st.push((double) hm.get(sentence.charAt(i)));
			} else {
				double first = st.pop();
				double second = st.pop();
				double result = 0;
				switch (sentence.charAt(i)) {
				case '+':
					result = first + second;
					break;
				case '-':
					result = second - first;
					break;
				case '*':
					result = first * second;
					break;
				case '/':
					result = (double) second / first;
				}
				st.push(result);
			}
		}
		System.out.printf("%.2f", st.pop());
	}

}
