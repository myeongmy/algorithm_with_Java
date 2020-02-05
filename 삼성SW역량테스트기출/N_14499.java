//���� 14499��(�ֻ��� ������)
//�ܼ� ���� ����
/*����
ũ�Ⱑ N��M�� ������ �����Ѵ�. ������ �������� ����, ������ �����̴�. �� ������ ���� �ֻ����� �ϳ� ������ ������, �ֻ����� �������� �Ʒ��� ����. ������ ��ǥ�� (r, c)�� ��Ÿ����, r�� �������κ��� ������ ĭ�� ����, c�� �������κ��� ������ ĭ�� �����̴�. 

  2
4 1 3
  5
  6
�ֻ����� ���� ���� �� ���� 1�̰�, ������ �ٶ󺸴� ������ 3�� ���·� ������ ������, ������ �ִ� ���� ��ǥ�� (x, y) �̴�. ���� ó���� �ֻ������� ��� �鿡 0�� ������ �ִ�.

������ �� ĭ���� ������ �ϳ��� ������ �ִ�. �ֻ����� ������ ��, �̵��� ĭ�� ���� �ִ� ���� 0�̸�, �ֻ����� �ٴڸ鿡 ���� �ִ� ���� ĭ�� ����ȴ�. 0�� �ƴ� ��쿡�� ĭ�� ���� �ִ� ���� �ֻ����� �ٴڸ����� ����Ǹ�, ĭ�� ���� �ִ� ���� 0�� �ȴ�.

�ֻ����� ���� ���� ��ǥ�� �̵���Ű�� ����� �־����� ��, �ֻ����� �̵����� �� ���� ��ܿ� ���� �ִ� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�ֻ����� ������ �ٱ����� �̵���ų �� ����. ���� �ٱ����� �̵���Ű���� �ϴ� ��쿡�� �ش� ����� �����ؾ� �ϸ�, ��µ� �ϸ� �� �ȴ�.

�Է�
ù° �ٿ� ������ ���� ũ�� N, ���� ũ�� M (1 �� N, M �� 20), �ֻ����� ���� ���� ��ǥ x y(0 �� x �� N-1, 0 �� y �� M-1), �׸��� ����� ���� K (1 �� K �� 1,000)�� �־�����.

��° �ٺ��� N���� �ٿ� ������ ���� �ִ� ���� ���ʺ��� ��������, �� ���� ���ʺ��� ���� ������� �־�����. �ֻ����� ���� ĭ�� ���� �ִ� ���� �׻� 0�̴�. ������ �� ĭ�� ���� �ִ� ���� 10�� ���� �ʴ� �ڿ��� �Ǵ� 0�̴�.

������ �ٿ��� �̵��ϴ� ����� ������� �־�����. ������ 1, ������ 2, ������ 3, ������ 4�� �־�����.

���
�̵��� ������ �ֻ����� �� �鿡 ���� �ִ� ���� ����Ѵ�. ���� �ٱ����� �̵���Ű���� �ϴ� ��쿡�� �ش� ����� �����ؾ� �ϸ�, ��µ� �ϸ� �� �ȴ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

public class N_14499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int x = s.nextInt(); // ���� �ֻ����� ��ġ
		int y = s.nextInt();
		int K = s.nextInt(); // ����� ����

		int[][] A = new int[N][M];
		int[] dice = new int[6]; // ���� ��� ��, �Ʒ�, �� , ��, ��, ��
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				A[i][j] = s.nextInt();
		}
		while (s.hasNext()) {
			int dir = s.nextInt();
			if (dir == 4) { // ���� �̵�
				if (x + 1 >= N)
					continue;
				int lastUp = dice[0];
				int lastDown = dice[1];
				int lastF = dice[2];
				int lastB = dice[3];

				dice[1] = lastF;
				dice[3] = lastDown;
				dice[0] = lastB;
				dice[2] = lastUp;

				if (A[x + 1][y] == 0)
					A[x + 1][y] = dice[1];
				else {
					dice[1] = A[x + 1][y];
					A[x + 1][y] = 0;
				}
				x = x + 1;
				System.out.println(dice[0]);
			} else if (dir == 3) { // ���� �̵�
				if (x - 1 < 0)
					continue;
				int lastUp = dice[0];
				int lastDown = dice[1];
				int lastF = dice[2];
				int lastB = dice[3];

				dice[1] = lastB;
				dice[2] = lastDown;
				dice[0] = lastF;
				dice[3] = lastUp;

				if (A[x - 1][y] == 0)
					A[x - 1][y] = dice[1];
				else {
					dice[1] = A[x - 1][y];
					A[x - 1][y] = 0;
				}
				x = x - 1;
				System.out.println(dice[0]);
			} else if (dir == 1) { // ���� �̵�
				if (y + 1 >= M)
					continue;
				int lastR = dice[5];
				int lastDown = dice[1];
				int lastL = dice[4];
				int lastUp = dice[0];

				dice[1] = lastR;
				dice[4] = lastDown;
				dice[0] = lastL;
				dice[5] = lastUp;

				if (A[x][y + 1] == 0)
					A[x][y + 1] = dice[1];
				else {
					dice[1] = A[x][y + 1];
					A[x][y + 1] = 0;
				}
				y = y + 1;
				System.out.println(dice[0]);
			} else if (dir == 2) { // ���� �̵�
				if (y - 1 < 0)
					continue;
				int lastR = dice[5];
				int lastDown = dice[1];
				int lastL = dice[4];
				int lastUp = dice[0];

				dice[1] = lastL;
				dice[5] = lastDown;
				dice[0] = lastR;
				dice[4] = lastUp;

				if (A[x][y - 1] == 0)
					A[x][y - 1] = dice[1];
				else {
					dice[1] = A[x][y - 1];
					A[x][y - 1] = 0;
				}
				y = y - 1;
				System.out.println(dice[0]);
			}
		}
	}

}
