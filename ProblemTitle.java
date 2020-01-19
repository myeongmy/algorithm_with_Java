// sw expert academy 7087 문제 제목 붙이기

package codingtest_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProblemTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayList<Character> list = new ArrayList<Character>();
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int result = 0;
			int N = s.nextInt();
			for (int j = 0; j < N; j++) {
				list.add(s.next().charAt(0)); // 제목의 맨 앞글자만 저장
			}

			for (char c = 'A';; c = (char) (c + 1)) {
				if (list.contains(c))
					result += 1;
				else
					break;
			}
			System.out.println("#" + (i + 1) + " " + result);
			list.clear();
		}

	}

}
