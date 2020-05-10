//DFS 문제(그런데 섬의 둘레 구하기 - 주변 0의 개수를 구하면 됨)

package 코딩테스트;

class Solution10 {
	static int[][] c;
	static int[][] zero;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int result = 0;

	static void dfs(int i, int j, int[][] maps) {
		c[i][j] = 1;
		// 가장자리
		if (i == 0)
			result++;
		if (i == c.length - 1)
			result++;
		if (j == 0)
			result++;
		if (j == c[0].length - 1)
			result++;
		// 주변 0 표시
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

		c = new int[maps.length][maps[0].length]; // 방문 여부 저장
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
