//[���� SW �����׽�Ʈ] �ٱ⼼�����
//�ùķ��̼� ����
/*�ٱ⼼�� ��� �ùķ��̼� ���α׷��� ������� �Ѵ�.

�ٱ⼼������ ��� ��⿡ ������ �� ���� �ð� ���� ����� ��Ų �� �ٱ� ������ ������ �� ���� �Ǵ��� ����ϴ� �ùķ��̼� ���α׷��� ������ �Ѵ�.

 

�ϳ��� �ٱ� ������ ����, ���� ũ�Ⱑ 1�� ���簢�� ���·� �����ϸ� ��� ���� ���� �׸���� �����Ǿ� ������ �ϳ��� �׸��� ���� �ٱ� ������ ũ��� ������ ����, ���� ũ�Ⱑ 1�� ���簢���̴�.

 

�� �ٱ� ������ ������̶�� ��ġ�� ������ �ִ�.

�ʱ� ���¿��� �ٱ� �������� ��Ȱ�� �����̸� ����� ��ġ�� X�� �ٱ� ������ ��� X�ð� ���� ��Ȱ�� �����̰� X�ð��� ������ ���� Ȱ�� ���°� �ȴ�.

�ٱ� ������ Ȱ�� ���°� �Ǹ� X�ð� ���� ������� �� ������ X�ð��� ������ ������ �װ� �ȴ�.

������ �״��� �Ҹ�Ǵ� ���� �ƴϰ� ���� ���·� �ش� �׸��� ���� �����ϰ� �ȴ�.

 

Ȱ��ȭ�� �ٱ� ������ ù 1�ð� ���� ��, ��, ��, �� �� �������� ���ÿ� ������ �Ѵ�.

���ĵ� �ٱ� ������ ��Ȱ�� �����̴�.

�ϳ��� �׸��� ������ �ϳ��� �ٱ� ������ ������ �� �ֱ� ������ �����ϴ� ���⿡ �̹� �ٱ� ������ �����ϴ� ��� �ش� �������� �߰������� �������� �ʴ´�.

�� �� �̻��� �ٱ� ������ �ϳ��� �׸��� ���� ���� �����Ϸ��� �ϴ� ��� ����� ��ġ�� ���� �ٱ� ������ �ش� �׸��� ���� ȥ�ڼ� �����ϰ� �ȴ�.

 

�ٱ� ������ ũ�⿡ ���� ��� ����� ũ�Ⱑ �ſ� ũ�� ������ �ùķ��̼ǿ��� ��� ����� ũ��� �����ϴٰ� �����Ѵ�.

 

�Ʒ� [�׸�1]�� [�׸�2]�� �ٱ� ������ �����ϴ� ���� ��Ÿ����.
 

 

                                                           [�׸� 1]
 

 
                                           [�׸� 2]

 

�ٱ� ������ �ʱ� ���� ������ ��� �ð� K�ð��� �־��� ��, K�ð� �� ����ִ� �ٱ� ����(��Ȱ�� ���� + Ȱ�� ����)�� �� ������ ���ϴ� ���α׷��� �ۼ��϶�.

 

[���� ����]
 

�ʱ� ���¿��� �ٱ� ������ ������ ������ ���̴� ���� ũ�� N, ���� ũ�� M�̸� N, M�� ���� 1 �̻� 50 ������ �����̴�. (1��N��50, 1��M��50)
��� �ð��� K�ð����� �־����� K�� 1 �̻� 300 ������ �����̴�. (1��K��300)
��� ����� ũ��� �����ϴ�. ���� �ٱ� ������ ��� ��� �����ڸ��� ��Ƽ� ������ �� ���� ���� ����.
�ٱ� ������ ����� X�� 1 �̻� 10 ������ �����̴�. (1��X��10)
 

[�Է�]
 

�Է��� ���� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T�� �־�����.

�� ���� �ٺ��ʹ� �� �׽�Ʈ ���̽��� �־�����

�� �׽�Ʈ ���̽��� ù° �ٿ��� �ʱ� ���¿����ٱ� ������ ������ ���� ũ�� N, ���� ũ�� M, ��� �ð� K�� ������� �־�����.

���� N �ٿ��� �� �ٸ��� M���� �׸��� ���� ������ �־�����.

1~10������ ���ڴ� �ش� �׸��� ���� ��ġ�� �ٱ� ������ ������� �ǹ��ϸ�,

0�� ��� �ٱ� ������ �������� �ʴ� �׸����̴�.

 

[���]
 

�׽�Ʈ ���̽� T�� ���� ����� ��#T���� ���,

����� K�ð� ��Ų �� ��� ��⿡ �ִ� ����ִ� �ٱ� ����(��Ȱ�� ���� + Ȱ�� ����)�� ������ ����Ѵ�. (T�� �׽�Ʈ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�. )*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;
import java.io.*;

class Cell {
	int i;
	int j;
	int status; // 0: active, 1: inactive, 2: dead
	int time;
	int inTime;

	Cell(int i, int j, int status, int time, int inTime) {
		this.i = i;
		this.j = j;
		this.status = status;
		this.time = time;
		this.inTime = inTime;
	}
}

class Visit {
	int time;
	int amount;

	Visit(int time, int amount) {
		this.time = time;
		this.amount = amount;
	}
}

public class SWEA_5653 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int N = Integer.parseInt(arr[0]);
				int M = Integer.parseInt(arr[1]);
				int K = Integer.parseInt(arr[2]);

				Visit[][] c = new Visit[1000][1000]; // �湮 time ����
				for (int j = 0; j < c.length; j++) {
					for (int k = 0; k < c[0].length; k++)
						c[j][k] = new Visit(-1, 0);
				}
				LinkedList<Cell> active = new LinkedList<Cell>();
				LinkedList<Cell> inactive = new LinkedList<Cell>();

				for (int j = 0; j < N; j++) {
					String[] arr1 = br.readLine().split(" ");
					for (int k = 0; k < M; k++) {
						if (Integer.parseInt(arr1[k]) != 0) {
							inactive.offer(new Cell(j + 150, k + 150, 1, Integer.parseInt(arr1[k]), 0));
							c[j + 150][k + 150].time = 0;
							c[j + 150][k + 150].amount = Integer.parseInt(arr1[k]);
						}
					}
				}

				int time = 0;
				while (time != K) {
					time++;

					// Ȱ�� ���� ó��
					int activeSize = active.size();
					int cnt = 0;
					while (cnt != activeSize) {
						cnt++;
						// Ȯ��
						Cell cell = active.remove(0);
						for (int k = 0; k < dx.length; k++) {
							if (c[cell.i + dx[k]][cell.j + dy[k]].time == -1) {
								c[cell.i + dx[k]][cell.j + dy[k]].time = time;
								c[cell.i + dx[k]][cell.j + dy[k]].amount = cell.time;
								inactive.offer(new Cell(cell.i + dx[k], cell.j + dy[k], 1, cell.time, time));
							} else if (c[cell.i + dx[k]][cell.j + dy[k]].time == time
									&& cell.time > c[cell.i + dx[k]][cell.j + dy[k]].amount) {
								c[cell.i + dx[k]][cell.j + dy[k]].amount = cell.time;
								inactive.offer(new Cell(cell.i + dx[k], cell.j + dy[k], 1, cell.time, time));
							}
						}
						if (cell.inTime + cell.time * 2 == time) {
							continue;
						} else {
							active.offer(new Cell(cell.i, cell.j, 0, cell.time, cell.inTime));
						}
					}

					// ��Ȱ�� ���� ó��
					int inactiveSize = inactive.size();
					cnt = 0;
					while (cnt != inactiveSize) {
						cnt++;

						Cell cell = inactive.remove(0);
						if (c[cell.i][cell.j].time != cell.inTime)
							continue;

						if (cell.inTime + cell.time == time) {
							active.offer(new Cell(cell.i, cell.j, 0, cell.time, cell.inTime));
						} else {
							inactive.offer(new Cell(cell.i, cell.j, 1, cell.time, cell.inTime));
						}
					}
				}
				System.out.println("#" + (i + 1) + " " + (inactive.size() + active.size()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
