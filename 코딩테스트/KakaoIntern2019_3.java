//���Ʈ ���� ���� (���� + �ߺ� ����)
//īī�� ���� 2019 �Ϲݱ� ����
//8���ϱ� ���� Ž�� ����
/*���� ����
������ ������ �̺�Ʈ ������ ����ϰ� �ִ� ������ �ֱ� ����� īī���̸�Ƽ�� �̺�Ʈ�� ���������� ������� ��÷�� �õ��� �����ڵ��� �߰��Ͽ����ϴ�. �̷� �����ڵ��� ���� ��� �ҷ� ����ڶ�� �̸����� ����� ���� ��÷ ó�� �� �����ϵ��� �̺�Ʈ ��÷�� ������� ���ε� ���� �����Ϸ��� �մϴ�. �� �� �������� ��ȣ�� ���� ����� ���̵� �� �Ϻ� ���ڸ� '*' ���ڷ� ������ �����߽��ϴ�. �������� �ϴ� ���� �ϳ��� '*' ���� �ϳ��� ����Ͽ��� ���̵� �� �ּ� �ϳ� �̻��� '*' ���ڸ� ����Ͽ����ϴ�.
������ ���ε��� �ҷ� ����� ��Ͽ� ���ε� ������ ���̵� ���� ���̵� ��� �θ���� �Ͽ����ϴ�.

���� ���, �̺�Ʈ�� ������ ��ü ����� ���̵� ����� ������ ���ٸ�

������ ���̵�
frodo
fradi
crodo
abc123
frodoc
������ ���� �ҷ� ����� ���̵� ����� ���޵� ���,

�ҷ� �����
fr*d*
abc1**
�ҷ� ����ڿ� ���εǾ� ��÷���� ���ܵǾ�� �� �� ���� ���̵� ����� ������ ���� �� ���� ��찡 ���� �� �ֽ��ϴ�.

���� ���̵�
frodo
abc123
���� ���̵�
fradi
abc123
�̺�Ʈ ������ ���̵� ����� ��� �迭 user_id�� �ҷ� ����� ���̵� ����� ��� �迭 banned_id�� �Ű������� �־��� ��, ��÷���� ���ܵǾ�� �� ���� ���̵� ����� ��� ����� ���� ������ �� return �ϵ��� solution �Լ��� �ϼ����ּ���.

[���ѻ���]
user_id �迭�� ũ��� 1 �̻� 8 �����Դϴ�.
user_id �迭 �� ���ҵ��� ���� ���̰� 1 �̻� 8 ������ ���ڿ��Դϴ�.
������ ����� ���̵���� ���� �ߺ����� �ʽ��ϴ�.
������ ����� ���̵�� ���ĺ� �ҹ��ڿ� ���ڷθ����� �����Ǿ� �ֽ��ϴ�.
banned_id �迭�� ũ��� 1 �̻� user_id �迭�� ũ�� �����Դϴ�.
banned_id �迭 �� ���ҵ��� ���� ���̰� 1 �̻� 8 ������ ���ڿ��Դϴ�.
�ҷ� ����� ���̵�� ���ĺ� �ҹ��ڿ� ����, ������ ���� ���� '*' �θ� �̷���� �ֽ��ϴ�.
�ҷ� ����� ���̵�� '*' ���ڸ� �ϳ� �̻� �����ϰ� �ֽ��ϴ�.
�ҷ� ����� ���̵� �ϳ��� ������ ���̵� �� �ϳ��� �ش��ϰ� ���� ������ ���̵� �ߺ��ؼ� ���� ���̵� ��Ͽ� ���� ���� �����ϴ�.
���� ���̵� ��ϵ��� ������ �� ���̵���� ������ ������ ������� ���̵� ����� ������ �����ϴٸ� ���� ������ ó���Ͽ� �ϳ��� ���� �˴ϴ�.

[����� ��]
		
user_id	banned_id	result
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3*/

package �ڵ��׽�Ʈ;

import java.util.*;

class Solution2 {
	static int[] result = new int[9];
	static int[][] freq;
	static int[] c = new int[9];
	static int cnt = 0;

	static void go(int index, int N, String[] user_id, String[] banned_id) {
		if (index == N) {
			for (int i = 0; i < N; i++) {
				String str = user_id[result[i]];
				String str1 = banned_id[i];

				if (str.length() != str1.length())
					return;
				for (int j = 0; j < str.length(); j++) {
					if (str1.charAt(j) != '*' && str.charAt(j) != str1.charAt(j)) {
						return;
					}

				}

			}
			int[] arr = new int[user_id.length];
			for (int i = 0; i < N; i++) {
				arr[result[i]]++;
			}
			for (int i = 0; i < cnt; i++) {
				int num = 0;
				for (int j = 0; j < user_id.length; j++) {
					if (freq[i][j] == arr[j])
						num++;
				}
				if (num == user_id.length)
					return;
			}
			for (int i = 0; i < user_id.length; i++)
				freq[cnt][i] = arr[i];
			System.out.println();
			cnt++;

			return;
		}
		for (int i = 0; i < user_id.length; i++) {
			if (c[i] == 1)
				continue;
			c[i] = 1;
			result[index] = i;
			go(index + 1, N, user_id, banned_id);
			c[i] = 0;
			result[index] = 0;
		}
	}

	public int solution(String[] user_id, String[] banned_id) {
		freq = new int[20][user_id.length];
		go(0, banned_id.length, user_id, banned_id);
		return cnt;
	}
}

public class KakaoIntern2019_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "abc1**" };
		System.out.println(new Solution2().solution(user_id, banned_id));
	}

}
