//백준 10808번
/*문제
알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_10808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String S = s.nextLine();
		int[] freq = new int[26]; // 빈도수 저장
		for (int i = 0; i < S.length(); i++) {
			freq[S.charAt(i) - 97]++;
		}
		for (int i = 0; i < freq.length; i++) {
			if (i == freq.length - 1)
				System.out.println(freq[i]);
			else
				System.out.print(freq[i] + " ");
		}
	}

}
