//���� 17087��
/*����
�����̴� ���� N��� ���ٲ����� �ϰ� �ִ�. �����̴� ���� �� S�� �ְ�, ������ A1, A2, ..., AN�� �ִ�.

�����̴� �ɾ �̵��� �� �� �ִ�. �������� ��ġ�� X�϶� �ȴ´ٸ� 1�� �Ŀ� X+D�� X-D�� �̵��� �� �ִ�. �������� ��ġ�� ������ �ִ� ��ġ�� ������, ������ ã�Ҵٰ� �Ѵ�.

��� ������ ã������ D�� ���� ���Ϸ��� �Ѵ�. ������ D�� �ִ��� ���غ���.

�Է�
ù° �ٿ� N(1 �� N �� 105)�� S(1 �� S �� 109)�� �־�����. ��° �ٿ� ������ ��ġ Ai(1 �� Ai �� 109)�� �־�����. ������ ��ġ�� ��� �ٸ���, �������� ��ġ�� ���� �ʴ�.

���
������ D���� �ִ��� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;
import java.util.Stack;

public class N_17087 {
	static long GCD(long a, long b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long S = s.nextLong();
		Stack<Long> st = new Stack<Long>();
		for (int i = 0; i < N; i++) {
			st.push((long) Math.abs(s.nextLong() - S));
		}
		long result = 0;
		while (!st.empty()) {
			if (st.size() == 1) {
				System.out.println(st.pop());
				System.exit(0);
			}
			long a = st.pop();
			long b = st.pop();
			result = GCD(a, b);
			if (!st.empty())
				st.push(result);
		}
		System.out.println(result);
	}

}
