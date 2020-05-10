//���� - ���� �������� ��ġ�� �־�����, �� ������ ���� ����� ���� ����������� �Ÿ�
//N = 600�̶� ���� �ð��ʰ��� ������ �ֱ� ��..

package �ڵ��׽�Ʈ;

class Solution11 {
	public int[][] solution(int N, int[][] bus_stop) {
		int[][] answer = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < bus_stop.length; k++) {
					if (min > Math.abs(i - (bus_stop[k][0] - 1)) + Math.abs(j - (bus_stop[k][1] - 1)))
						min = Math.abs(i - (bus_stop[k][0] - 1)) + Math.abs(j - (bus_stop[k][1] - 1));
				}
				answer[i][j] = min;

			}
		}
		return answer;
	}
}

public class HyundaiITE_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;
		int[][] bus_stop = { { 1, 2 } };
		int[][] result = new Solution11().solution(N, bus_stop);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}

}
