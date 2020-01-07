//백준 11005번
/*문제
10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

입력
첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

출력
첫째 줄에 10진법 수 N을 B진법으로 출력한다.*/

package codingtest_study.백준;

import java.util.HashMap;
import java.util.Scanner;

public class N_11005 {
	static HashMap<Integer, Character> hm = new HashMap<Integer, Character>() {
		{
			put(10, 'A');
			put(11, 'B');
			put(12, 'C');
			put(13, 'D');
			put(14, 'E');
			put(15, 'F');
			put(16, 'G');
			put(17, 'H');
			put(18, 'I');
			put(19, 'J');
			put(20, 'K');
			put(21, 'L');
			put(22, 'M');
			put(23, 'N');
			put(24, 'O');
			put(25, 'P');
			put(26, 'Q');
			put(27, 'R');
			put(28, 'S');
			put(29, 'T');
			put(30, 'U');
			put(31, 'V');
			put(32, 'W');
			put(33, 'X');
			put(34, 'Y');
			put(35, 'Z');
		}
	};

	static void func1(long N, int B) {
		if (N == 0)
			return;
		func1(N / B, B);
		if (N % B >= 0 && N % B <= 9)
			System.out.print(N % B);
		else{
			System.out.print(hm.get((int)(N%B)));
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		long N = s.nextLong();
		int B = s.nextInt();
		func1(N, B);
	}

}
