//백준 1065번
//브루트 포스 문제
/*문제
어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.*/

package 백준;

import java.util.*;

public class N_1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int num = 0;
		Label: for (int i = 1; i <= N; i++) {
			String str = Integer.toString(i);
			if (str.length() <= 2) {
				num++;
				continue;
			}
			int diff = str.charAt(0) - str.charAt(1);
			for (int j = 1; j < str.length() - 1; j++) {
				if (diff != str.charAt(j) - str.charAt(j + 1))
					continue Label;
			}
			num++;
		}
		System.out.println(num);
	}

}
