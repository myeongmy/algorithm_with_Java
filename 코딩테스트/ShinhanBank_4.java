//4�� - �ҷ� ���ڿ� Ž�� (īī�� ���ڿ� ����� ���)
//kmp �˰���

package �ڵ��׽�Ʈ;

//�ҷ� ����: ���� n �̻��� ���������� k�� �̻� ���ӵǴ� ���

import java.util.*;

class Solution16 {
	public int[] solution(String[] replies, int n, int k) {
		int[] answer = new int[replies.length];
		for (int i = 0; i < answer.length; i++)
			answer[i] = 1;
		Label: for (int i = 0; i < replies.length; i++) { // �� �������� ����
			for (int j = n; j < replies[i].length(); j++) { // ���� j�� �ڸ�
				for (int z = 0; z < replies[i].length(); z++) { // ���� ��ġ
					int num = 1;
					int flag = 0; // �ҷ��̸� 1
					for (int m = z + j; m < replies[i].length() - j + 1; m += j) {
						if (replies[i].substring(m, m + j).equals(replies[i].substring(m - j, m))) {
							num++;
						} else {
							if (num >= k)
								flag = 1;
							num = 1;
						}
					}
					if (num >= k)
						flag = 1;
					if (flag == 1) {
						answer[i] = 0;
						continue Label;
					}
				}
			}
		}
		return answer;
	}
}

public class ShinhanBank_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] replies = { "FABCABC", "ABABAB" };
		int n = 3;
		int k = 2;
		int[] answer = new Solution16().solution(replies, n, k);
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
