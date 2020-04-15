package 프로그래머스;

//dfs 풀이

class Solution22 {
	static int size = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void dfs(int i, int j, int[][] picture, int[][] c) {
		c[i][j] = 1;
		size++;

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < picture.length && j + dy[k] >= 0 && j + dy[k] < picture[0].length) {
				if (picture[i][j] == picture[i + dx[k]][j + dy[k]] && c[i + dx[k]][j + dy[k]] == 0)
					dfs(i + dx[k], j + dy[k], picture, c);
			}
		}
	}

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[][] c = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && c[i][j] == 0) {
					dfs(i, j, picture, c);
					numberOfArea++;
					if (maxSizeOfOneArea < size)
						maxSizeOfOneArea = size;
					size = 0;
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}

public class ColoringBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		int[] answer = new Solution22().solution(m, n, picture);
		System.out.println(answer[0] + " " + answer[1]);
	}

}
