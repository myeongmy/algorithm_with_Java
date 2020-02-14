//���� 17140�� (������ �迭�� ����)
//�ùķ��̼� + ���� ����
/*����
ũ�Ⱑ 3��3�� �迭 A�� �ִ�. 1�ʰ� ���������� �迭�� ������ ����ȴ�.

R ����: �迭 A�� ��� �࿡ ���ؼ� ������ �����Ѵ�. ���� ���� �� ���� ������ ��쿡 ����ȴ�.
C ����: �迭 A�� ��� ���� ���ؼ� ������ �����Ѵ�. ���� ���� < ���� ������ ��쿡 ����ȴ�.
�� �� �Ǵ� ���� �ִ� ���� �����Ϸ���, ������ ���� �� �� ���Դ��� �˾ƾ� �Ѵ�. �� ����, ���� ���� Ƚ���� Ŀ���� ������, �׷��� ���� ���������� ���� Ŀ���� ������ �����Ѵ�. �� �������� �迭 A�� ���ĵ� ����� �ٽ� �־�� �Ѵ�. ���ĵ� ����� �迭�� ���� ����, ���� ���� Ƚ���� ��� ������, ������ ���� �����̴�.

���� ���, [3, 1, 1]���� 3�� 1��, 1�� 2�� �����Ѵ�. ����, ���ĵ� ����� [3, 1, 1, 2]�� �ȴ�. �ٽ� �� �迭���� 3�� 1��, 1�� 2��, 2�� 1�� �����Ѵ�. �ٽ� �����ϸ� [2, 1, 3, 1, 1, 2]�� �ȴ�.

���ĵ� ����� �迭�� �ٽ� ������ �� �Ǵ� ���� ũ�Ⱑ Ŀ�� �� �ִ�. R ������ ����� ��쿡�� ���� ũ�Ⱑ ���� ū ���� �������� ��� ���� ũ�Ⱑ Ŀ����, C ������ ����� ��쿡�� ���� ũ�Ⱑ ���� ū ���� �������� ��� ���� ũ�Ⱑ Ŀ����. �� �Ǵ� ���� ũ�Ⱑ Ŀ�� ������ 0�� ä������. ���� ������ �� 0�� �����ؾ� �Ѵ�. ���� ���, [3, 2, 0, 0]�� ������ ����� [3, 2]�� ������ ����� ����.

�� �Ǵ� ���� ũ�Ⱑ 100�� �Ѿ�� ��쿡�� ó�� 100���� ������ �������� ������.

�迭 A�� ����ִ� ���� r, c, k�� �־����� ��, A[r][c]�� ����ִ� ���� k�� �Ǳ� ���� �ּ� �ð��� ���غ���.

�Է�
ù° �ٿ� r, c, k�� �־�����. (1 �� r, c, k �� 100)

��° �ٺ��� 3���� �ٿ� �迭 A�� ����ִ� ���� �־�����. �迭 A�� ����ִ� ���� 100���� �۰ų� ���� �ڿ����̴�.

���
A[r][c]�� ����ִ� ���� k�� �Ǳ� ���� ������ �ּ� �ð��� ����Ѵ�. �� ���� 100�� �Ѿ�� ��쿡�� -1�� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Po implements Comparable<Po> {
	int num;
	int time;

	Po(int num, int time) {
		this.num = num;
		this.time = time;
	}

	public int compareTo(Po p) {
		if (this.time < p.time)
			return -1;
		else if (this.time > p.time)
			return 1;
		else if (this.time == p.time) {
			if (this.num < p.num)
				return -1;
			else if (this.num > p.num)
				return 1;
		}
		return 0;
	}
}

public class N_17140 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int c = s.nextInt();
		int k = s.nextInt();
		int cur_x = 3;
		int cur_y = 3;
		int[][] A = new int[105][105];
		for (int i = 0; i < cur_x; i++) {
			for (int j = 0; j < cur_y; j++) {
				A[i][j] = s.nextInt();
			}
		}

		int time = 0;
		while (true) {
			if (time > 100) {
				System.out.println(-1);
				System.exit(0);
			}
			if (A[r - 1][c - 1] == k)
				break;
			if (cur_x >= cur_y) {
				int new_y = 0;
				for (int i = 0; i < cur_x; i++) {
					HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
					for (int j = 0; j < cur_y; j++) {
						if (A[i][j] == 0)
							continue;
						hm.put(A[i][j], hm.getOrDefault(A[i][j], 0) + 1);
					}
					Set<Integer> set = hm.keySet();
					Iterator<Integer> it = set.iterator();
					PriorityQueue<Po> q = new PriorityQueue<Po>();
					while (it.hasNext()) {
						int a = it.next();
						q.offer(new Po(a, hm.get(a)));
					}
					if (q.size() * 2 > new_y)
						new_y = q.size() * 2;
					int j = 0;
					while (!q.isEmpty()) {
						Po p = q.poll();
						A[i][j] = p.num;
						A[i][j + 1] = p.time;
						j += 2;
					}
					for (int z = j; z < cur_y; z++) { // �� �κ� ó���� �����༭ �� ���� 0�� �ƴ� ���ڰ� ���� �־ ���� ������.
						A[i][z] = 0;
					}

				}
				cur_y = new_y;

			} else if (cur_x < cur_y) {
				int new_x = 0;
				for (int i = 0; i < cur_y; i++) {
					HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
					for (int j = 0; j < cur_x; j++) {
						if (A[j][i] == 0)
							continue;
						hm.put(A[j][i], hm.getOrDefault(A[j][i], 0) + 1);
					}
					Set<Integer> set = hm.keySet();
					Iterator<Integer> it = set.iterator();
					PriorityQueue<Po> q = new PriorityQueue<Po>();
					while (it.hasNext()) {
						int a = it.next();
						q.offer(new Po(a, hm.get(a)));
					}
					if (q.size() * 2 > new_x)
						new_x = q.size() * 2;
					int j = 0;
					while (!q.isEmpty()) {
						Po p = q.poll();
						A[j][i] = p.num;
						A[j + 1][i] = p.time;
						j += 2;
					}
					for (int z = j; z < cur_x; z++) {
						A[z][i] = 0;
					}
				}
				cur_x = new_x;

			}
			time++;
		}
		System.out.println(time);

	}

}
