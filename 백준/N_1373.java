//백준 1373번
/*문제
2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_1373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String num = s.nextLine();
		StringBuilder sb = new StringBuilder();
		if (num.length() % 3 == 1) {
			sb.append(num.charAt(0));
		} else if (num.length() % 3 == 2) {
			sb.append(Integer.toString(2 * (num.charAt(0) - 48) + (num.charAt(1) - 48)));
		}
		for (int i = num.length() % 3; i + 3 <= num.length(); i += 3) {
			int a = (num.charAt(i) - 48) * 4 + (num.charAt(i + 1) - 48) * 2 + (num.charAt(i + 2) - 48);
			sb.append(Integer.toString(a));
		}
		System.out.println(sb);
	}

}
