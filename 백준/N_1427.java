//백준 1427번
//정렬 문제 풀이
/*문제
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.*/

package 백준;

import java.util.*;

public class N_1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int[] A = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			A[i] = str.charAt(i) - 48;
		}
		Arrays.sort(A);
		for (int i = A.length - 1; i >= 0; i--) {
			System.out.print(A[i]);
		}
	}

}
