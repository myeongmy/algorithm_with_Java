//�ùķ��̼� ����
//īī�� ���� 2019 �Ϲݱ� ����
//����
//1. ���� ���ڿ� ���·� �� ��ȣ �迭�� int arr�� ������ (stack�� �̿��� ��ȣ �Ľ�)
//2. �ߺ����� �ʴ� �ٴ� ���� Ȱ���� ó������ answer�� �ֱ�

/*���� ����
�����ִ� ������ �����ִ� ���� �Ǵ� � ������ ������ ��ҵ��� ������ Ʃ��(tuple)�̶�� �մϴ�. n���� ��Ҹ� ���� Ʃ���� n-Ʃ��(n-tuple)�̶�� �ϸ�, ������ ���� ǥ���� �� �ֽ��ϴ�.

(a1, a2, a3, ..., an)
Ʃ���� ������ ���� ������ ������ �ֽ��ϴ�.

�ߺ��� ���Ұ� ���� �� �ֽ��ϴ�. ex : (2, 3, 1, 2)
���ҿ� ������ ������ ������, ������ ������ �ٸ��� ���� �ٸ� Ʃ���Դϴ�. ex : (1, 2, 3) �� (1, 3, 2)
Ʃ���� ���� ������ �����մϴ�.
������ ������ n���̰�, �ߺ��Ǵ� ���Ұ� ���� Ʃ�� (a1, a2, a3, ..., an)�� �־��� ��(��, a1, a2, ..., an�� �ڿ���), �̴� ������ ���� ���� ��ȣ '{', '}'�� �̿��� ǥ���� �� �ֽ��ϴ�.

{{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
���� ��� Ʃ���� (2, 1, 3, 4)�� ��� �̴�

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
�� ���� ǥ���� �� �ֽ��ϴ�. �̶�, ������ ������ ������ �ٲ� ��������Ƿ�

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
{{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
�� ��� ���� Ʃ�� (2, 1, 3, 4)�� ��Ÿ���ϴ�.

Ư�� Ʃ���� ǥ���ϴ� ������ ��� ���ڿ� s�� �Ű������� �־��� ��, s�� ǥ���ϴ� Ʃ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.

[���ѻ���]
s�� ���̴� 5 �̻� 1,000,000 �����Դϴ�.
s�� ���ڿ� '{', '}', ',' �θ� �̷���� �ֽ��ϴ�.
���ڰ� 0���� �����ϴ� ���� �����ϴ�.
s�� �׻� �ߺ��Ǵ� ���Ұ� ���� Ʃ���� �ùٸ��� ǥ���ϰ� �ֽ��ϴ�.
s�� ǥ���ϴ� Ʃ���� ���Ҵ� 1 �̻� 100,000 ������ �ڿ����Դϴ�.
return �ϴ� �迭�� ���̰� 1 �̻� 500 ������ ��츸 �Է����� �־����ϴ�.
		
[����� ��]
		
s	result
"{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
"{{20,111},{111}}"	[111, 20]
"{{123}}"	[123]
"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]*/

package �ڵ��׽�Ʈ;

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
