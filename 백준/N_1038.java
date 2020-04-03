//���� 1038��
//���Ʈ ���� ���� (�����ϴ� �� or �����ϴ� �� = �������� ��� ���� �� �ִ�. 1024���ϱ� �ð� �ʰ� ���� nono)
/*����
���� �ƴ� ���� X�� �ڸ����� ���� ū �ڸ������� ���� �ڸ������� �����Ѵٸ�, �� ���� �����ϴ� ����� �Ѵ�. ���� ���, 321�� 950�� �����ϴ� ������, 322�� 958�� �ƴϴ�. N��° �����ϴ� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 0�� 0��° �����ϴ� ���̰�, 1�� 1��° �����ϴ� ���̴�. ���� N��° �����ϴ� ���� ���ٸ� -1�� ����Ѵ�.

�Է�
ù° �ٿ� N�� �־�����. N�� 1,000,000���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

���
ù° �ٿ� N��° �����ϴ� ���� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1038 {
	static LinkedList<Integer> result = new LinkedList<Integer>();
	static ArrayList<Long> list = new ArrayList<Long>();

	static void go(int index) {
		if (index == 10) {
			if (result.size() == 0)
				return;

			Collections.sort(result);
			StringBuilder sb = new StringBuilder();

			for (int i = result.size() - 1; i >= 0; i--) {
				sb.append(result.get(i));
			}
			list.add(Long.parseLong(sb.toString()));
			return;
		}
		result.add(index);
		go(index + 1);
		result.remove(result.size() - 1);

		go(index + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		go(0);
		Collections.sort(list);

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		if (N >= 1023) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(N));
		}

	}

}
