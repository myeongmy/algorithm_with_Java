//���� 14391��
/*����
�����̴� ���ڰ� ���� �ִ� ���簢�� ���̸� ������ �ִ�. ���̴� 1��1 ũ���� ���簢�� ĭ���� �������� �ְ�, ���ڴ� �� ĭ�� �ϳ��� ���� �ִ�. ���� ���������� �Ʒ����� ��ȣ�� �Ű��� �ְ�, ���� ���ʺ��� �����ʱ��� ��ȣ�� �Ű��� �ִ�.

�����̴� ���簢���� ��ġ�� �ʴ� �������� �ڸ����� �Ѵ�. �� ������ ũ�Ⱑ ���γ� ���� ũ�Ⱑ 1�� ���簢�� ����̴�. ���̰� N�� ������ N�ڸ� ���� ��Ÿ�� �� �ִ�. ���� ������ ���ʺ��� �����ʱ��� ���� �̾� ���� ���̰�, ���� ������ ���������� �Ʒ����� ���� �̾���� ���̴�.

�Ʒ� �׸��� 4��4 ũ���� ���̸� �ڸ� �� ���� ����̴�.



�� ������ ���� 493 + 7160 + 23 + 58 + 9 + 45 + 91 = 7879 �̴�.

���̸� ������ �߶� ������ ���� �ִ�� �ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ������ ���� ũ�� N�� ���� ũ�� M�� �־�����. (1 �� N, M �� 4)

��° �ٺ��� ���� ������ �־�����. �� ĭ�� ���� �ִ� ���ڴ� 0���� 9���� �� �ϳ��̴�.

���
�����̰� ���� �� �ִ� ������ �ִ��� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_14391 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		s.nextLine();
		char[] A = new char[N * M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = s.nextLine();
			for (int j = 0; j < M; j++) {
				A[cnt] = str.charAt(j);
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		long max = 0;
		for (long i = 0; i < (1 << N * M); i++) {
			long sum = 0;
			int count = 0;
			// ���� ���� ���ϱ�
			for (int j = N * M - 1; j >= 0; j--) {
				if (count % M == 0) {
					if (sb.length() != 0) {
						sum += Long.parseLong(sb.toString());
						sb.setLength(0);
					}
				}
				if ((i & (1 << j)) == 0)
					sb.append(A[Math.abs(j - (N * M - 1))]);
				else {
					if (sb.length() != 0)
						sum += Long.parseLong(sb.toString());
					sb.setLength(0);
				}
				count++;
			}
			if (sb.length() != 0) {
				sum += Long.parseLong(sb.toString());
				sb.setLength(0);
			}

			// ���� ���� ���ϱ�
			for (int j = N * M - 1; j >= N * M - 1 - (M - 1); j--) {
				if (sb.length() != 0) {
					sum += Long.parseLong(sb.toString());
					sb.setLength(0);
				}
				for (int k = 0; k < N * M; k += M) {
					if ((i & (1 << (j - k))) != 0)
						sb.append(A[Math.abs((j - k) - (N * M - 1))]);
					else {
						if (sb.length() != 0)
							sum += Long.parseLong(sb.toString());
						sb.setLength(0);
					}
				}
			}
			if (sb.length() != 0) {
				sum += Long.parseLong(sb.toString());
				sb.setLength(0);
			}
			if (max < sum)
				max = sum;
		}
		System.out.println(max);

	}

}
