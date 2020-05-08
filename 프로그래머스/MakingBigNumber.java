package ���α׷��ӽ�;

//���Ʈ ���� -> ���� Ŀ�� �Ұ�
//�� ������, �̺� Ž��, dp, �׸��� -> �׸���!

class Solution27 {
	public String solution(String number, int k) {
		String answer = "";

		StringBuilder sb = new StringBuilder(number);

		/*
		 * Ʋ�� Ǯ�� while(k > 0){ //�ּҰ��� �ּҰ��� ��ġ ã�� int min = Integer.MAX_VALUE; int min_i
		 * = -1;
		 * 
		 * for(int i=0;i<sb.length();i++){ if(min > sb.charAt(i) - 48){ min =
		 * sb.charAt(i) - 48; min_i = i; } } sb.deleteCharAt(min_i);
		 * 
		 * k--; } answer = sb.toString();
		 */

		int num = 0; // ������ �� ����
		int index = 0;
		while (num != k && index < sb.length() - 1) {
			if (sb.charAt(index) < sb.charAt(index + 1)) {
				sb.deleteCharAt(index);
				index = 0;
				num++;
				continue;
			}
			index++;
		}

		if (num != k)
			sb.delete(sb.length() - k, sb.length());

		answer = sb.toString();
		return answer;
	}
}

public class MakingBigNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1924";
		int k = 2;
		System.out.println(new Solution27().solution(number, k));
	}

}
