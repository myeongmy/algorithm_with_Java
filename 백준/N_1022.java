//���� 1022��
//���� ���� Ǯ��
/*����
ũ�Ⱑ ������ ���簢�� �����̰� �ִ�. �������� �� ���簢���� ��� ���� ������ ǥ���� �� �ִ�.

�� ������ ��ü�� ���� ������ �ҿ뵹�� ������� ä�� ���̴�. �ϴ� ���� 1�� 0�� 0���� ����. �׸��� ���� 0�� 1���� ���� 2�� ����. �ű⼭ ���� �ҿ뵹�̴� �ݽð� �������� ���۵ȴ�. ���� ���ڴ� ������ ���� ä��� �ȴ�.

    -3 -2 -1  0  1  2  3
    --------------------
-3 |37 36 35 34 33 32 31
-2 |38 17 16 15 14 13 30
-1 |39 18  5  4  3 12 29
 0 |40 19  6  1  2 11 28
 1 |41 20  7  8  9 10 27
 2 |42 21 22 23 24 25 26
 3 |43 44 45 46 47 48 49
�� ������ ���� ���� ä�� ���� ���ڰ� ����ϸ� �ȴ�. r1, c1, r2, c2�� �Է����� �־�����. r1, c1�� ���� ���� �� ĭ�̰�, r2, c2�� ���� ������ �Ʒ� ĭ�̴�.

���ڰ� ����Ѵٴ� ���� ������ ���� ����ϴ� ���̴�.

����� r1����� r2����� ���ʴ�� ����Ѵ�.
�� ���Ҵ� �������� �����Ѵ�.
��� ���� ���� ���̸� ������ �Ѵ�.
������ ���̴� �ּҷ� �ؾ� �Ѵ�.
��� ������ ����(�տ� �ٴ� ������ ����)�� ���ƾ� �Ѵ�.
���� ���� ���̰� ���� ���̰� �� ������ �۴ٸ�, ���ʿ������� ������ ������ ���̸� �����.
�Է�
ù° �ٿ� r1, c1, r2, c2�� �־�����. ��� ������ 5000���� �۰ų� ���� �����̰�, r2-r1�� 0���� ũ�ų� ����, 49���� �۰ų� ������, c2-c1�� 0���� ũ�ų� ����, 4���� �۰ų� ����.

���
r2-r1+1���� �ٿ� �ҿ뵹�̸� ���ڰ� ����Ѵ�.*/
//����: ��->��->��>�� (dir: 0��, 1��, 2��, 3��)
//����: 1122334455

package ����;

import java.io.*;
import java.util.*;

public class N_1022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int r1 = Integer.parseInt(input[0]);
			int c1 = Integer.parseInt(input[1]);
			int r2 = Integer.parseInt(input[2]);
			int c2 = Integer.parseInt(input[3]);

			long[][] A = new long[r2 - r1 + 1][c2 - c1 + 1];
			int row = 0;
			int col = 0;
			if (r1 < 0) {
				row = -r1;
			} else if (r1 > 0) {
				row = -r1;
			} else if (r1 == 0) {
				row = 0;
			}

			if (c1 < 0) {
				col = -c1;
			} else if (c1 > 0) {
				col = -c1;
			} else if (c1 == 0) {
				col = 0;
			}

			int increasing = 1;
			int dir = 0;
			int currentX = 0;
			int currentY = 0;
			long num = 1;
			long max = Long.MIN_VALUE; // �迭�� ���� �� �� ���� ū �� ã�� ����

			if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
				A[currentX + row][currentY + col] = num;
				if (max < num)
					max = num;
			}

			while (Math.abs(currentX) <= 5000 && Math.abs(currentY) <= 5000) {     //<5000�̶� �ؼ� Ʋ�Ƚ��ϴ� ����
				if (dir == 0) {
					for (int i = 0; i < increasing; i++) {
						currentY++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 1) {
					for (int i = 0; i < increasing; i++) {
						currentX--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 2) {
					for (int i = 0; i < increasing; i++) {
						currentY--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 3) {
					for (int i = 0; i < increasing; i++) {
						currentX++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				}

				dir = (dir + 1) % 4;

				if (dir == 0) {
					for (int i = 0; i < increasing; i++) {
						currentY++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 1) {
					for (int i = 0; i < increasing; i++) {
						currentX--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 2) {
					for (int i = 0; i < increasing; i++) {
						currentY--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 3) {
					for (int i = 0; i < increasing; i++) {
						currentX++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				}

				dir = (dir + 1) % 4;
				increasing++;
			}
			int cnt = Long.toString(max).length();

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					if(j == A[0].length - 1)
						System.out.printf("%" + cnt + "d", A[i][j]);
					else
						System.out.printf("%" + cnt + "d ", A[i][j]);
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
