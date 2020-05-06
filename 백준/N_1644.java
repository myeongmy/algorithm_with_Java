//���� 1644��
//�� ������ �˰��� ���� Ǯ��
//�־��� �� N������ �Ҽ��� ��� ���� ��, �� ������ �˰��� �̿�

package ����;

import java.util.*;

public class N_1644 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		// �����佺�׳׽��� ü �̿��ؼ� N ������ �Ҽ� ã��
		boolean[] A = new boolean[N + 1]; // false�� �Ҽ�, true�� �ռ���
		ArrayList<Integer> prime = new ArrayList<Integer>();

		for (int i = 2; i <= N; i++) {
			if (A[i] == false) {
				for (int j = i + i; j <= N; j += i) {
					A[j] = true;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (A[i] == false)
				prime.add(i);
		}

		int start = 0;
		int end = 0;
		int result = 0;
		int sum = 0;

		while (start < prime.size()) {
			if (sum == N) {
				result++;
				start++;
				sum -= prime.get(start - 1);
			} else if (sum > N || end >= prime.size()) {
				start++;
				sum -= prime.get(start - 1);
			} else if (sum < N) {
				end++;
				sum += prime.get(end - 1);
			}
		}
		System.out.println(result);
	}

}
