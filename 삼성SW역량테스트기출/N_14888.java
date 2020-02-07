//���� 14888��(������ �����ֱ�)
//���Ʈ ���� ����(next permutation �̿�)
/*����
N���� ���� �̷���� ���� A1, A2, ..., AN�� �־�����. ��, ���� �� ���̿� �������� �� �ִ� N-1���� �����ڰ� �־�����. �����ڴ� ����(+), ����(-), ����(��), ������(��)���θ� �̷���� �ִ�.

�츮�� ���� �� ���̿� �����ڸ� �ϳ��� �־, ������ �ϳ� ���� �� �ִ�. �̶�, �־��� ���� ������ �ٲٸ� �� �ȴ�.

���� ���, 6���� ���� �̷���� ������ 1, 2, 3, 4, 5, 6�̰�, �־��� �����ڰ� ����(+) 2��, ����(-) 1��, ����(��) 1��, ������(��) 1���� ��쿡�� �� 60������ ���� ���� �� �ִ�. ���� ���, �Ʒ��� ���� ���� ���� �� �ִ�.

1+2+3-4��5��6
1��2+3+4-5��6
1+2��3��4-5+6
1��2��3-4+5+6
���� ����� ������ �켱 ������ �����ϰ� �տ������� �����ؾ� �Ѵ�. ��, �������� ���� ���������� �� ���Ѵ�. ������ ����� ���� ���� C++14�� ������ ������. ��, ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. �̿� ����, ���� �� 4���� ����� ����غ��� �Ʒ��� ����.

1+2+3-4��5��6 = 1
1��2+3+4-5��6 = 12
1+2��3��4-5+6 = 5
1��2��3-4+5+6 = 7
N���� ���� N-1���� �����ڰ� �־����� ��, ���� �� �ִ� ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(2 �� N �� 11)�� �־�����. ��° �ٿ��� A1, A2, ..., AN�� �־�����. (1 �� Ai �� 100) ��° �ٿ��� ���� N-1�� 4���� ������ �־����µ�, ���ʴ�� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� �����̴�. 

���
ù° �ٿ� ���� �� �ִ� ���� ����� �ִ���, ��° �ٿ��� �ּڰ��� ����Ѵ�. �ִ񰪰� �ּڰ��� �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ���� ����� ������ �Է¸� �־�����. ����, �տ������� ������� ��, �߰��� ���Ǵ� ���� ����� �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ����.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

public class N_14888 {
	static int next_permutation(StringBuilder sb) {
		int cnt = sb.length() - 1;
		while (cnt != 0) {
			if (sb.charAt(cnt) <= sb.charAt(cnt - 1)) {
				cnt -= 1;
			} else {
				break;
			}
		}
		if (cnt == 0)
			return -1; // ���������� ���
		int change = 0;
		for (int i = cnt; i < sb.length(); i++) {
			if (sb.charAt(cnt - 1) < sb.charAt(i)) {
				change = i;
				continue;
			} else {
				change = i - 1;
				break;
			}
		}
		char temp = sb.charAt(cnt - 1);
		sb.replace(cnt - 1, cnt, Character.toString(sb.charAt(change)));
		sb.replace(change, change + 1, Character.toString(temp));
		String str = sb.substring(cnt);
		sb.delete(cnt, sb.length());
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		int[] oper = new int[4]; // ������ ���� ����(0: ����, 1: ����, 2: ����, 3:������)
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			oper[i] = s.nextInt();
			if (oper[i] != 0) {
				for (int j = 0; j < oper[i]; j++)
					sb.append(i);
			}
		}
		long max = -1000000001;
		long min = 1000000001;
		int fi = 0;
		while (true) {
			int result = A[0];
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == '0') {
					result = result + A[i + 1];
				} else if (sb.charAt(i) == '1') {
					result = result - A[i + 1];
				} else if (sb.charAt(i) == '2') {
					result = result * A[i + 1];
				} else {
					if (result < 0) {
						result = -(-result / A[i + 1]);
					} else {
						result = result / A[i + 1];
					}
				}

			}
			if (max < result)
				max = result;
			if (min > result)
				min = result;
			if (fi == 1)
				break;
			if (next_permutation(sb) == -1)
				fi = 1;
		}
		System.out.println(max);
		System.out.println(min);

	}

}
