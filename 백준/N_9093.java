//백준 9093번
/*
 문제
문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다. 단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.
*/

package codingtest_study.백준;

import java.util.Scanner;
import java.util.Stack;

public class N_9093 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();
		int T = s.nextInt();
		s.nextLine();
		for (int i = 0; i < T; i++) {
			String sentence = s.nextLine();
			for (int j = 0; j < sentence.length(); j++) {
				if (sentence.charAt(j) == ' ') {
					while (!st.empty())
						System.out.print(st.pop());
					System.out.print(sentence.charAt(j));
				} else {
					st.push(sentence.charAt(j));
				}
			}

			// nextLine()이 enter를 읽어들이지 않기 때문에 마지막에 push된 거 pop해주기
			while (!st.empty())
				System.out.print(st.pop());
			System.out.println();
		}
	}

}
