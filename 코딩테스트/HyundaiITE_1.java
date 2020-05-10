//DFS ����(�׷��� ���� �ѷ� ���ϱ� - �ֺ� 0�� ������ ���ϸ� ��)

package �ڵ��׽�Ʈ;

class Solution10 {
	static int[][] c;
	static int[][] zero;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int result = 0;

	static void dfs(int i, int j, int[][] maps) {
		c[i][j] = 1;
		// �����ڸ�
		if (i == 0)
			result++;
		if (i == c.length - 1)
			result++;
		if (j == 0)
			result++;
		if (j == c[0].length - 1)
			result++;
		// �ֺ� 0 ǥ��
		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < c.length && j + dy[k] >= 0 && j + dy[k] < c[0].length) {
				if (maps[i + dx[k]][j + dy[k]] == 0)
					zero[i + dx[k]][j + dy[k]]++;
			}
		}

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < c.length && j + dy[k] >= 0 && j + dy[k] < c[0].length) {
				if (maps[i + dx[k]][j + dy[k]] == 1 && c[i + dx[k]][j + dy[k]] == 0)
					dfs(i + dx[k], j + dy[k], maps);
			}
		}
	}

	public int solution(int[][] maps) {
		int answer = 24;

		c = new int[maps.length][maps[0].length]; // �湮 ���� ����
		zero = new int[maps.length][maps[0].length];

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				if (maps[i][j] == 1 && c[i][j] == 0) {
					dfs(i, j, maps);
				}
			}
		}

		for (int i = 0; i < zero.length; i++) {
			for (int j = 0; j < zero[0].length; j++) {
				if (zero[i][j] != 0)
					result += zero[i][j];
			}
		}

		answer = result;
		return answer;
	}
}

public class HyundaiITE_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maps = { { 0, 0, 1, 0, 0 }, { 0, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1 } };
		System.out.println(new Solution10().solution(maps));
	}

}
