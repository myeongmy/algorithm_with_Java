//백준 10820번
/*문제
문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.

각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.

입력
첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.

출력
첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_10820 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String sentence = s.nextLine();
			int[] num = new int[4];
			for (int i = 0; i < sentence.length(); i++) {
				if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z')
					num[0]++;
				else if (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z')
					num[1]++;
				else if (sentence.charAt(i) >= '0' && sentence.charAt(i) <= '9')
					num[2]++;
				else
					num[3]++;
			}
			for (int i = 0; i < num.length; i++) {
				if (i == num.length - 1)
					System.out.println(num[i]);
				else
					System.out.print(num[i] + " ");
			}
		}
	}

}
