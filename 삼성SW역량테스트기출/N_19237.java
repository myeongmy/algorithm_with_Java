//백준 19237번 어른 상어
//시뮬레이션 문제

package 삼성SW역량테스트기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_19237 {
	static class Relation {
		int sharkNum;
		int remainingK;
		int smellNum;

		Relation(int sharkNum, int remainingK, int smellNum) {
			this.sharkNum = sharkNum;
			this.remainingK = remainingK;
			this.smellNum = smellNum;
		}
	}

	static class Point {
		int i;
		int j;
		int sharkNum;
		int sharkDir;

		Point(int i, int j, int sharkNum, int sharkDir) {
			this.i = i;
			this.j = j;
			this.sharkNum = sharkNum;
			this.sharkDir = sharkDir;
		}
	}

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);

			Relation[][] A = new Relation[N][N];
			for (int i = 0; i < N; i++) { // 초기값 세팅
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(arr[j]) != 0)
						A[i][j] = new Relation(Integer.parseInt(arr[j]), k, Integer.parseInt(arr[j]));
					else
						A[i][j] = new Relation(Integer.parseInt(arr[j]), 0, Integer.parseInt(arr[j]));
				}
			}

			// 상어 정보 저장
			int[] sharkInfo = new int[M + 1];
			String[] arr = br.readLine().split(" ");
			for (int i = 1; i <= M; i++) {
				sharkInfo[i] = Integer.parseInt(arr[i - 1]); // 상어 번호에 해당 하는 방향 저장
			}

			// 우선순위 판단 배열 저장
			ArrayList<Integer>[][] priority = (ArrayList<Integer>[][]) new ArrayList[M + 1][5];
			for (int i = 1; i <= M; i++) {
				for (int j = 1; j <= 4; j++) {
					String[] arr1 = br.readLine().split(" ");
					priority[i][j] = new ArrayList<Integer>();
					for (int m = 0; m < arr1.length; m++)
						priority[i][j].add(Integer.parseInt(arr1[m]));
				}
			}

		
			// 시뮬레이션 시작
			int time = 0;

			while (true) {
				time++;
				if (time > 1000)
					break;

				// 1번부터 모든 상어 이동
				ArrayList<Point> move = new ArrayList<Point>(); // 이동 정보 저장

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (A[i][j].sharkNum != 0) {
							int staticDir = sharkInfo[A[i][j].sharkNum];
							// 인접한 칸들 중 빈 칸이 있는지 조사(우선순위 대로 탐색)
							int flag = 0; // 아무 냄새 없는 칸을 발견했는지 여부

							for (int m = 0; m < 4; m++) {
								int newi = i + dx[priority[A[i][j].sharkNum][staticDir].get(m)];
								int newj = j + dy[priority[A[i][j].sharkNum][staticDir].get(m)];
								
								if (newi >= 0 && newi < N && newj >= 0 && newj < N && A[newi][newj].smellNum == 0) {
									move.add(new Point(newi, newj, A[i][j].sharkNum,
											priority[A[i][j].sharkNum][staticDir].get(m)));
									sharkInfo[A[i][j].sharkNum] = priority[A[i][j].sharkNum][staticDir].get(m);
									A[i][j].sharkNum = 0;
									flag = 1;

									break;
								}
							}
							// 위에서 발견하지 못했다면 자신의 냄새가 있는 칸 조사(우선순위 대로 탐색)
							if (flag == 0) {
								for (int m = 0; m < 4; m++) {
									int newi = i + dx[priority[A[i][j].sharkNum][staticDir].get(m)];
									int newj = j + dy[priority[A[i][j].sharkNum][staticDir].get(m)];
									if (newi >= 0 && newi < N && newj >= 0 && newj < N
											&& A[newi][newj].smellNum == A[i][j].sharkNum) {
										move.add(new Point(newi, newj, A[i][j].sharkNum,
												priority[A[i][j].sharkNum][staticDir].get(m)));
										sharkInfo[A[i][j].sharkNum] = priority[A[i][j].sharkNum][staticDir].get(m);
										A[i][j].sharkNum = 0;

										break;
									}
								}
							}
						}
					}
				}

				// 냄새 남은 시간 update
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (A[i][j].remainingK != 0) {
							A[i][j].remainingK--;
							if (A[i][j].remainingK == 0) { // 시간 완료 되면 냄새 사라짐
								A[i][j].sharkNum = 0;
								A[i][j].smellNum = 0;
							}
						}

					}
				}

				// move 리스트 내용 릴레이션에 update
				for (int i = 0; i < move.size(); i++) {
					Point p = move.get(i);
					if (A[p.i][p.j].sharkNum == 0) {
						A[p.i][p.j] = new Relation(p.sharkNum, k, p.sharkNum);
					} else {
						if (p.sharkNum < A[p.i][p.j].sharkNum) {
							A[p.i][p.j] = new Relation(p.sharkNum, k, p.sharkNum);
						}
					}
				}

				// 1번 상어만 남았는지 확인
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (A[i][j].sharkNum != 0)
							cnt++;
					}
				}
				if (cnt == 1)
					break;
			}

			if (time > 1000)
				System.out.println(-1);
			else
				System.out.println(time);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
