//백준 2174번 로봇 시뮬레이션
//시뮬레이션

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2174 {
	static class Robot {
		int i;
		int j;
		char dir;

		Robot(int i, int j, char dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}

	static char[] dir = { 'E', 'S', 'W', 'N' };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);

		int[][] ground = new int[B][A];

		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 로봇의 수
		int M = Integer.parseInt(input[1]); // 명령의 수

		Robot[] robotArr = new Robot[N + 1];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			char dir = arr[2].charAt(0);

			robotArr[i + 1] = new Robot(B - y, x - 1, dir);
			ground[B - y][x - 1] = i + 1;
		}

		// 시뮬레이션
		for (int i = 0; i < M; i++) {
			String[] arr = br.readLine().split(" ");
			int num = Integer.parseInt(arr[0]); // 로봇 번호
			char type = arr[1].charAt(0);
			int iter = Integer.parseInt(arr[2]);

			if (type == 'L') {
				char currentDir = robotArr[num].dir;
				int dirIndex = 0;

				for (int j = 0; j < dir.length; j++) {
					if (currentDir == dir[j])
						dirIndex = j;
				}

				for (int j = 0; j < iter; j++) {
					dirIndex--;
					if (dirIndex < 0)
						dirIndex = 3;
				}
				robotArr[num].dir = dir[dirIndex];

			} else if (type == 'R') {
				char currentDir = robotArr[num].dir;
				int dirIndex = 0;

				for (int j = 0; j < dir.length; j++) {
					if (currentDir == dir[j])
						dirIndex = j;
				}

				for (int j = 0; j < iter; j++) {
					dirIndex = (dirIndex + 1) % 4;
				}

				robotArr[num].dir = dir[dirIndex];

			} else if (type == 'F') {
				int nexti = robotArr[num].i;
				int nextj = robotArr[num].j;
				char currentDir = robotArr[num].dir;

				for (int j = 0; j < iter; j++) {
					if (currentDir == 'E') {
						nextj++;
						if (nextj >= A) {
							System.out.println("Robot " + num + " crashes into the wall");
							System.exit(0);
						} else if (ground[nexti][nextj] != 0) {
							System.out.println("Robot " + num + " crashes into robot " + ground[nexti][nextj]);
							System.exit(0);
						}

						// 업데이트
						ground[nexti][nextj] = num;
						ground[robotArr[num].i][robotArr[num].j] = 0;
						robotArr[num].j = nextj;

					} else if (currentDir == 'S') {
						nexti++;
						if (nexti >= B) {
							System.out.println("Robot " + num + " crashes into the wall");
							System.exit(0);
						} else if (ground[nexti][nextj] != 0) {
							System.out.println("Robot " + num + " crashes into robot " + ground[nexti][nextj]);
							System.exit(0);
						}

						// 업데이트
						ground[nexti][nextj] = num;
						ground[robotArr[num].i][robotArr[num].j] = 0;
						robotArr[num].i = nexti;

					} else if (currentDir == 'W') {
						nextj--;
						if (nextj < 0) {
							System.out.println("Robot " + num + " crashes into the wall");
							System.exit(0);
						} else if (ground[nexti][nextj] != 0) {
							System.out.println("Robot " + num + " crashes into robot " + ground[nexti][nextj]);
							System.exit(0);
						}

						// 업데이트
						ground[nexti][nextj] = num;
						ground[robotArr[num].i][robotArr[num].j] = 0;
						robotArr[num].j = nextj;

					} else if (currentDir == 'N') {
						nexti--;
						if (nexti < 0) {
							System.out.println("Robot " + num + " crashes into the wall");
							System.exit(0);
						} else if (ground[nexti][nextj] != 0) {
							System.out.println("Robot " + num + " crashes into robot " + ground[nexti][nextj]);
							System.exit(0);
						}

						// 업데이트
						ground[nexti][nextj] = num;
						ground[robotArr[num].i][robotArr[num].j] = 0;
						robotArr[num].i = nexti;
					}
				}
			}
		}

		System.out.println("OK");
	}

}
