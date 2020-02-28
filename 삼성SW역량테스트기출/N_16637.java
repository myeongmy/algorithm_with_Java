//���� 16637�� (��ȣ �߰��ϱ�)
//���Ʈ ���� ���� (����)
/*����
���̰� N�� ������ �ִ�. ������ 0���� ũ�ų� ����, 9���� �۰ų� ���� ������ ������(+, -, ��)�� �̷���� �ִ�. ������ �켱������ ��� �����ϱ� ������, ������ ����� ���� ���ʿ������� ������� ����ؾ� �Ѵ�. ���� ���, 3+8��7-9��2�� ����� 136�̴�.

���Ŀ� ��ȣ�� �߰��ϸ�, ��ȣ �ȿ� ����ִ� ���� ���� ����ؾ� �Ѵ�. ��, ��ȣ �ȿ��� �����ڰ� �ϳ��� ��� �־�� �Ѵ�. ���� ���, 3+8��7-9��2�� ��ȣ�� 3+(8��7)-(9��2)�� ���� �߰�������, ���� ����� 41�� �ȴ�. ������, ��ø�� ��ȣ�� ����� �� ����. ��, 3+((8��7)-9)��2, 3+((8��7)-(9��2))�� ��� ��ȣ �ȿ� ��ȣ�� �ֱ� ������, �ùٸ� ���� �ƴϴ�.

������ �־����� ��, ��ȣ�� ������ �߰��� ���� �� �ִ� ���� ����� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �߰��ϴ� ��ȣ ������ ������ ������, �߰����� �ʾƵ� �ȴ�.

�Է�
ù° �ٿ� ������ ���� N(1 �� N �� 19)�� �־�����. ��° �ٿ��� ������ �־�����. ���Ŀ� ���Ե� ������ ��� 0���� ũ�ų� ����, 9���� �۰ų� ����. ���ڿ��� ������ �����ϰ�, �����ڿ� ������ �����ư��鼭 ���´�. �����ڴ� +, -, * �� �ϳ��̴�. ���⼭ *�� ���ϱ� ������ ��Ÿ���� �� �����̴�. �׻� �ùٸ� ���ĸ� �־����� ������, N�� Ȧ���̴�.

���
ù° �ٿ� ��ȣ�� ������ �߰��ؼ� ���� �� �ִ� ����� �ִ��� ����Ѵ�. ������ 231���� �۰�, -231���� ũ��.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

public class N_16637 {
	static LinkedList<Integer> result = new LinkedList<Integer>();
	static StringBuilder ex;
	static int max = Integer.MIN_VALUE;

	static void go(int index, LinkedList<Integer> list) {
		if (result.size() >= 0) {
			StringBuilder sb = new StringBuilder(ex);
			for (int i = result.size() - 1; i >= 0; i--) {
				int r = 0;
				if (sb.charAt(result.get(i)) == '+') {
					r = (sb.charAt(result.get(i) - 1) - 48) + (sb.charAt(result.get(i) + 1) - 48);
				} else if (sb.charAt(result.get(i)) == '-') {
					r = (sb.charAt(result.get(i) - 1) - 48) - (sb.charAt(result.get(i) + 1) - 48);
				} else if (sb.charAt(result.get(i)) == '*') {
					r = ((int) sb.charAt(result.get(i) - 1) - 48) * ((int) sb.charAt(result.get(i) + 1) - 48);
				}
				sb.replace(result.get(i) - 1, result.get(i) + 2, Integer.toString(r));
			}
			// ��ȣ ������ ���� ���
			int i = 0;
			int num = 0;
			if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
				if (i + 1 < sb.length() && sb.charAt(i + 1) >= '0' && sb.charAt(i + 1) <= '9') {
					num = Integer.parseInt(Character.toString(sb.charAt(i)) + Character.toString(sb.charAt(i + 1)));
					i++;
				} else
					num = sb.charAt(i) - 48;
			} else {
				num = -(sb.charAt(i + 1) - 48);
				i++;
			}
			i++;
			while (i < sb.length()) {
				if (sb.charAt(i) == '+') {
					if (i + 1 < sb.length() && sb.charAt(i + 1) >= '0' && sb.charAt(i + 1) <= '9') {
						if (i + 2 < sb.length() && sb.charAt(i + 2) >= '0' && sb.charAt(i + 2) <= '9') {
							num += Integer.parseInt(
									Character.toString(sb.charAt(i + 1)) + Character.toString(sb.charAt(i + 2)));
							i++;
						} else
							num += (sb.charAt(i + 1) - 48);
					} else {
						num += -(sb.charAt(i + 2) - 48);
						i++;
					}
				} else if (sb.charAt(i) == '-') {
					if (i + 1 < sb.length() && sb.charAt(i + 1) >= '0' && sb.charAt(i + 1) <= '9') {
						if (i + 2 < sb.length() && sb.charAt(i + 2) >= '0' && sb.charAt(i + 2) <= '9') {
							num -= Integer.parseInt(
									Character.toString(sb.charAt(i + 1)) + Character.toString(sb.charAt(i + 2)));
							i++;
						} else
							num -= (sb.charAt(i + 1) - 48);
					} else {
						num -= -(sb.charAt(i + 2) - 48);
						i++;
					}
				} else if (sb.charAt(i) == '*') {
					if (i + 1 < sb.length() && sb.charAt(i + 1) >= '0' && sb.charAt(i + 1) <= '9') {
						if (i + 2 < sb.length() && sb.charAt(i + 2) >= '0' && sb.charAt(i + 2) <= '9') {
							num *= Integer.parseInt(
									Character.toString(sb.charAt(i + 1)) + Character.toString(sb.charAt(i + 2)));
							i++;
						} else
							num *= (sb.charAt(i + 1) - 48);
					} else {
						num *= -(sb.charAt(i + 2) - 48);
						i++;
					}
				}
				i++;
			}
			if (max < num) {
				max = num;
			}
		}
		if (index >= list.size())
			return;
		result.add(list.get(index));
		go(index + 2, list);
		result.remove(result.size() - 1);

		go(index + 1, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ex = new StringBuilder(s.next());
		LinkedList<Integer> list = new LinkedList<Integer>(); // �������� ��ġ ����
		for (int i = 0; i < ex.length(); i++) {
			if (ex.charAt(i) == '+' || ex.charAt(i) == '-' || ex.charAt(i) == '*') {
				list.add(i);
			}
		}
		go(0, list);
		System.out.println(max);
	}

}
