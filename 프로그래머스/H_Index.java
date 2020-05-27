//정렬

package 프로그래머스;

import java.util.*;

class Solution30 {
	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);

		for (int i = citations[citations.length - 1]; i >= 0; i--) {
			// 배열 탐색
			int j;
			for (j = 0; j < citations.length; j++) {
				if (citations[j] >= i)
					break;
			}
			if (citations.length - j >= i) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}

public class H_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(new Solution30().solution(citations));
	}

}
