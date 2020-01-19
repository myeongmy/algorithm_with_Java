//백준 2745번
/*문제
B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

입력
첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)

B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

출력
첫째 줄에 B진법 수 N을 10진법으로 출력한다.*/

package codingtest_study.백준;

import java.util.HashMap;
import java.util.Scanner;

public class N_2745 {
	static HashMap<Character, Integer> hm = new HashMap<Character, Integer>() {
		{
			put('A', 10);
			put('B', 11);
			put('C', 12);
			put('D', 13);
			put('E', 14);
			put('F', 15);
			put('G', 16);
			put('H', 17);
			put('I', 18);
			put('J', 19);
			put('K', 20);
			put('L', 21);
			put('M', 22);
			put('N', 23);
			put('O', 24);
			put('P', 25);
			put('Q', 26);
			put('R', 27);
			put('S', 28);
			put('T', 29);
			put('U', 30);
			put('V', 31);
			put('W', 32);
			put('X', 33);
			put('Y', 34);
			put('Z', 35);
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String num = s.next();
		int B = s.nextInt();
		int flag = 0;
		long result = 0;
		for (int i = num.length() - 1; i >= 0; i--) {
			if (num.charAt(i) >= '0' && num.charAt(i) <= '9')
				result += (num.charAt(i) - 48) * (long) Math.pow(B, flag);
			else
				result += hm.get(num.charAt(i)) * (long) Math.pow(B, flag);
			flag++;
		}
		System.out.println(result);
	}

}
