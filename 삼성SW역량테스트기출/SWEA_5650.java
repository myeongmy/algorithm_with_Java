//[���� SW�����׽�Ʈ] �ɺ� ����
//���Ʈ ���� + �ùķ��̼� ����
/*�α�� �ɺ� ������ ���� �߿� �ִ�. �ɺ������� N x N ũ���� �ɺ� �����ǿ� ���簢�� ��ϰ� 4���� ������ �ﰢ�� ��ϵ��� ���� �ְ�, ���⿡ �߰������� ��Ȧ�� ��Ȧ�� �����Ѵ�. �ɺ������� �������� �ϳ��� ���� �Ʒ� [�׸�1]�� ����.

                
                                                       [�׸�1]

�� ��ϵ��� ������ ��ȣ�� �־����µ�, ��ϵ��� ��ȣ�� ����� �Ʒ� [�׸�2]�� ����.


            
                                                       [�׸�2]


��Ȧ�� ��Ȧ�� ���� �Ʒ� [�׸�3]�� ��ȣ�� �־�����.

              
                        [�׸�3]

 

������ �������� ���� �ɺ� �ϳ��� ��, ��, ��, �� �� �� �������� �����δ�.
 

            
 

�ɺ��� ����̳� ��Ȧ �Ǵ� ��Ȧ�� ������ �ʴ� �� ���� ������ �����ϸ鼭 ��� �����ϸ�,

����� ������̳� �������� ���� ��� ������ �ٲ� �ݴ� �������� ���ƿ���, ������ ���� ��쿡�� �������� ���� ������ ���̰� �ȴ�.

                

 

���� �ɺ��� ���� ���� ��쿡�� �ݴ� �������� ���ƿ´�. �Ʒ��� �׸��� ���� �ɺ��� �������� �����̴� ���� ������ �ݴ� �������� �ٽ� ���ƿ��� �ȴ�.
 

             
 

�ɺ��� ��Ȧ�� ������ ������ ���ڸ� ���� �ٸ� �ݴ��� ��Ȧ�� ���� ������ �Ǹ� ��������� �״�� �����ȴ�. (��Ȧ�� �ݵ�� ������ �־�����, �Է¿����� 6 �̻� 10 ������ ���ڷ� ǥ�õȴ�.)
 


 

�ɺ��� ��Ȧ�� ������, �ɺ��� ������� �Ǿ� ������ ������ �ȴ�.
 


 

������ �ɺ��� ��� ��ġ�� ���ƿ��ų�, ��Ȧ�� ���� �� ������ �Ǹ�, ������ ���̳� ��Ͽ� �ε��� Ƚ���� �ȴ�. (��Ȧ�� ����ϴ� ���� ������ ���Ե��� �ʴ´�.)

��Ȧ�� ������ ������ ��������, ���̳� ��Ͽ� �ε��� ȹ���� ������ �����ְ� �ȴ�.

������ ������ ��� ��ġ�� ���� ������ ���Ƿ� �������� �� ��,

�� ���ӿ��� ���� �� �ִ� ������ �ִ��� ���Ͽ���!

��, ���, ��Ȧ �Ǵ� ��Ȧ�� �ִ� ��ġ������ ����� �� ����.

 

[���� ����]

�������� ũ��� ���簢������ �־�����, �� ���� ���� N �� 5 �̻� 100 �����̴�. (5 �� N �� 100)
��Ȧ�� ������ ������ ���� 6 ~ 10���� �־�����.
��Ȧ�� ������ ������ ���� -1 �� �־�����.
�����ǿ��� ��Ȧ �Ǵ� ��Ȧ�� �������� �ʴ� ��쵵 �ִ�.
��Ȧ�� �ִ� ��� �ݵ�� ��(pair)���� �����ϸ�, ��Ȧ�� �־����� ��� �ִ� 5�� �����Ѵ�.
��Ȧ�� ����� �ɺ��� ������ ���ڸ� ���� �ݴ��� ��Ȧ�� �̵��ϰ� �Ǹ�, �̶� ��������� �״�� �����ȴ�.
��Ȧ�� �ִ� 5���� �־�����.
 

[�Է�]

�Է��� ���� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T�� �־�����, �� ���� �ٺ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù° �ٿ��� N�� �־�����, ���� N�ٿ� ���ļ� �ɺ� �������� ����� �־�����.

�������� ����� -1 �̻� 10 ������ ������ �־�����, �� ���ڴ� �� ĭ�� ������� �־�����.
���ڿ� ���� �ǹ̴� ������ ����

 

-1

0

1 ~ 5

6 ~ 10

��Ȧ

�����

���

��Ȧ

 
[���]

�׽�Ʈ ���̽� t�� ���� ����� "#t"�� ���, �� ĭ ��� ������ ����Ѵ�.

(��, t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)*/

package �ＺSW�����׽�Ʈ����;

import java.io.*;
import java.util.*;

public class SWEA_5650 {
	static int[] dx = { 0, 0, -1, 1 }; // �������(0: ����, 1: ������, 2: ����, 3: �Ʒ���)
	static int[] dy = { -1, 1, 0, 0 };

	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int hashCode() {
			return (Integer.toString(i) + Integer.toString(j)).hashCode();
		}

		public boolean equals(Object o) {
			Point p = (Point) o;
			return this.i == p.i && this.j == p.j;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] block = new int[6][4];
		block[1][1] = 0;
		block[1][2] = 3;
		block[1][0] = 2;
		block[1][3] = 1;

		block[2][0] = 3;
		block[2][1] = 0;
		block[2][2] = 1;
		block[2][3] = 2;

		block[3][0] = 1;
		block[3][1] = 3;
		block[3][2] = 0;
		block[3][3] = 2;

		block[4][0] = 1;
		block[4][1] = 2;
		block[4][2] = 3;
		block[4][3] = 0;

		block[5][0] = 1;
		block[5][1] = 0;
		block[5][2] = 3;
		block[5][3] = 2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				int[][] A = new int[N][N];
				ArrayList<Point> zero = new ArrayList<Point>(); // �ɺ��� �� �� �ִ� ��ġ ����
				ArrayList<Point>[] hole = (ArrayList<Point>[]) new ArrayList[5]; // ��Ȧ ��ġ(�ε���: ��Ȧ ��ȣ -6)
				for (int j = 0; j < hole.length; j++)
					hole[j] = new ArrayList<Point>();

				for (int j = 0; j < N; j++) {
					String[] arr = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr[k]);
						if (A[j][k] == 0)
							zero.add(new Point(j, k));
						if (A[j][k] >= 6)
							hole[A[j][k] - 6].add(new Point(j, k));
					}
				}

				int max = Integer.MIN_VALUE;

				for (int j = 0; j < zero.size(); j++) {
					Point p = zero.get(j); // �ɺ��� ��ġ

					for (int k = 0; k < 4; k++) {
						int dir = k;
						int score = 0;
						int curi = p.i;
						int curj = p.j;
						int time = 0;

						Label: while (true) {
							if (time != 0 && (curi == p.i && curj == p.j))
								break;
							int nexti = curi;
							int nextj = curj;

							while (true) {
								nexti += dx[dir];
								nextj += dy[dir];

								if (time != 0 && nexti == p.i && nextj == p.j)
									break Label;
								time++;
								if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) { // ���� ���� ���
									score += 1;
									nexti -= dx[dir];
									nextj -= dy[dir];
									curi = nexti;
									curj = nextj;
									
									if (dir == 0) {
										dir = 1;
									} else if (dir == 1) {
										dir = 0;
									} else if (dir == 2) {
										dir = 3;
									} else if (dir == 3) {
										dir = 2;
									}
									if (A[curi][curj] >= 1 && A[curi][curj] <= 5) {
										dir = block[A[curi][curj]][dir];
										score += 1;       // 47/50�� �¾Ҵ� ���� (���⵵ ��Ͽ� �ε��� ����ε� score ++�� ���� �ʾƼ�!!)
										break;
									}
									if (A[curi][curj] >= 6 && A[curi][curj] <= 10) {
										if (hole[A[nexti][nextj] - 6].get(0).i == nexti
												&& hole[A[nexti][nextj] - 6].get(0).j == nextj) {
											curi = hole[A[nexti][nextj] - 6].get(1).i;
											curj = hole[A[nexti][nextj] - 6].get(1).j;
										} else if (hole[A[nexti][nextj] - 6].get(1).i == nexti
												&& hole[A[nexti][nextj] - 6].get(1).j == nextj) {
											curi = hole[A[nexti][nextj] - 6].get(0).i;
											curj = hole[A[nexti][nextj] - 6].get(0).j;
										}
										break;
									}
									break;
								} else if (A[nexti][nextj] >= 1 && A[nexti][nextj] <= 5) { // ����� ���� ���
									score += 1;
									curi = nexti;
									curj = nextj;
									dir = block[A[curi][curj]][dir];
									break;
								} else if (A[nexti][nextj] == -1) { // ��Ȧ�� ���� ���
									break Label;
								} else if (A[nexti][nextj] >= 6 && A[nexti][nextj] <= 10) { // ��Ȧ ���� ���
									if (hole[A[nexti][nextj] - 6].get(0).i == nexti
											&& hole[A[nexti][nextj] - 6].get(0).j == nextj) {
										curi = hole[A[nexti][nextj] - 6].get(1).i;
										curj = hole[A[nexti][nextj] - 6].get(1).j;
									} else if (hole[A[nexti][nextj] - 6].get(1).i == nexti
											&& hole[A[nexti][nextj] - 6].get(1).j == nextj) {
										curi = hole[A[nexti][nextj] - 6].get(0).i;
										curj = hole[A[nexti][nextj] - 6].get(0).j;
									}
									break;
								}

							}

						}
						if (max < score) {
							max = score;
						}
					}
				}
				System.out.println("#" + (i + 1) + " " + max);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
