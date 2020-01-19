//백준 2089번
/*문제
-2진법은 부호 없는 2진수로 표현이 된다. 2진법에서는 20, 21, 22, 23이 표현 되지만 -2진법에서는 (-2)0 = 1, (-2)1 = -2, (-2)2 = 4, (-2)3 = -8을 표현한다. 10진수로 1부터 표현하자면 1, 110, 111, 100, 101, 11010, 11011, 11000, 11001 등이다.

10진법의 수를 입력 받아서 -2진수를 출력하는 프로그램을 작성하시오.

입력
첫 줄에 10진법으로 표현된 수 N(-2,000,000,000≤N≤2,000,000,000)이 주어진다.

출력
-2진법 수를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;


public class N_2089 {
	static StringBuilder result = new StringBuilder();

	static void func1(long num) {
		if (num == 0)
			return;
		if (num < 0 && (long) Math.abs(num) % 2 == 1) {
			func1(((long) Math.abs(num) + 1) / 2);
			result.append(1);
		} else {
			func1(num / -2);
			result.append(num % -2);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long num = s.nextLong();
		if (num == 0)
			System.out.println(0);
		else {
			func1(num);
			System.out.println(result);
		}

	}

}
