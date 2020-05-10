//구현 - 버스 정류장의 위치가 주어지고, 각 집에서 가장 가까운 버스 정류장까지의 거리
//N = 600이라서 조금 시간초과의 위험이 있긴 함..

package 코딩테스트;

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
