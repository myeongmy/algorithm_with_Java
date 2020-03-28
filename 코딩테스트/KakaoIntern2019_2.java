//시뮬레이션 문제
//카카오 인턴 2019 하반기 문제
//로직
//1. 먼저 문자열 형태로 된 괄호 배열을 int arr에 저장함 (stack을 이용한 괄호 파싱)
//2. 중복되지 않는 다는 점을 활용해 처음부터 answer에 넣기

/*문제 설명
셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다. n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.

(a1, a2, a3, ..., an)
튜플은 다음과 같은 성질을 가지고 있습니다.

중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
튜플의 원소 개수는 유한합니다.
원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수), 이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.

{{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
{{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.

[제한사항]
s의 길이는 5 이상 1,000,000 이하입니다.
s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.
숫자가 0으로 시작하는 경우는 없습니다.
s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.
s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.
return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.
		
[입출력 예]
		
s	result
"{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
"{{20,111},{111}}"	[111, 20]
"{{123}}"	[123]
"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]*/

package 코딩테스트;

import java.util.*;

class Solution1 {
	public int[] solution(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '}')
				cnt++;
		}
		int size = cnt - 1;
		int[][] arr = new int[size][];
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '{' && s.charAt(i) != '}' && s.charAt(i) != ',') {
				StringBuilder sb = new StringBuilder();
				while (s.charAt(i) != ',' && s.charAt(i) != '}') {
					sb.append(s.charAt(i));
					i++;
				}
				i--;
				st.push(Integer.parseInt(sb.toString()));
			} else if (s.charAt(i) == '}') {
				if (st.empty())
					continue;
				int size_st = st.size();

				arr[size_st - 1] = new int[size_st];
				int idx = 0;
				while (!st.empty()) {
					arr[size_st - 1][idx] = st.pop();
					idx++;
				}

			}
		}

		int[] answer = new int[size];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				answer[i] = arr[i][0];
				continue;
			}
			for (int j = 0; j < arr[i].length; j++) {
				int flag = 0;
				for (int k = 0; k < i; k++) {
					if (answer[k] == arr[i][j])
						flag = 1;
				}
				if (flag == 0) {
					answer[i] = arr[i][j];
					break;
				}
			}

		}
		return answer;
	}
}

public class KakaoIntern2019_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		System.out.println(new Solution1().solution(s));
	}

}
