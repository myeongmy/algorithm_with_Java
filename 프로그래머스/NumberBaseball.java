//���Ʈ ���� ����(�׳� �� �غ��� + ����)
package ���α׷��ӽ�;

class Solution7 {
	static StringBuilder sb = new StringBuilder();
	static int[] c = new int[10];
	static int answer = 0;

	static void go(int index, int[][] baseball) {
		if (index == 3) {
			for (int i = 0; i < baseball.length; i++) {
				String a = Integer.toString(baseball[i][0]);
				// ��Ʈ����ũ �� ����
				int strike = 0;
				for (int j = 0; j < 3; j++) {
					if (sb.charAt(j) == a.charAt(j))
						strike++;
				}
				if (strike != baseball[i][1])
					return;
				// �� �� ����
				int ball = 0;
				for (int j = 0; j < 3; j++) {
					if (sb.charAt(j) != a.charAt(j) && a.indexOf(sb.charAt(j)) != -1)
						ball++;
				}
				if (ball != baseball[i][2])
					return;
			}
			answer++;
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (c[i] == 1)
				continue;
			c[i] = 1;
			sb.append(i);
			go(index + 1, baseball);
			c[i] = 0;
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public int solution(int[][] baseball) {
		go(0, baseball);
		return answer;
	}
}

public class NumberBaseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		System.out.println(new Solution7().solution(baseball));
	}

}
