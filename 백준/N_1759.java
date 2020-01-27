//���� 1759��
/*����
�ٷ� ���� �ֹ��� ������ �� ���踦 �ָӴϿ� ���� ä �����ϰ� ����� �� ������ Ȳ���� ��Ȳ�� ������ ��������, 702ȣ�� ���ο� ���� �ý����� ��ġ�ϱ�� �Ͽ���. �� ���� �ý����� ���谡 �ƴ� ��ȣ�� �����ϰ� �Ǿ� �ִ� �ý����̴�.

��ȣ�� ���� �ٸ� L���� ���ĺ� �ҹ��ڵ�� �����Ǹ� �ּ� �� ���� ������ �ּ� �� ���� �������� �����Ǿ� �ִٰ� �˷��� �ִ�. ���� ���ĵ� ���ڿ��� ��ȣ�ϴ� �������� �������� �̷�� ���� ��ȣ�� �̷�� ���ĺ��� ��ȣ���� �����ϴ� ������ �迭�Ǿ��� ���̶�� �����ȴ�. ��, abc�� ���ɼ��� �ִ� ��ȣ������ bac�� �׷��� �ʴ�.

�� ���� �ý��ۿ��� �������� ��ȣ�� ������� ���� ������ ������ C������ �ִٰ� �Ѵ�. �� ���ĺ��� �Լ��� �ν�, ���� ������ �������� �濡 ħ���ϱ� ���� ��ȣ�� ������ ������ �Ѵ�. C���� ���ڵ��� ��� �־����� ��, ���ɼ� �ִ� ��ȣ���� ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �� ���� L, C�� �־�����. (3 �� L �� C �� 15) ���� �ٿ��� C���� ���ڵ��� �������� ���еǾ� �־�����. �־����� ���ڵ��� ���ĺ� �ҹ����̸�, �ߺ��Ǵ� ���� ����.

���
�� �ٿ� �ϳ���, ���������� ���ɼ� �ִ� ��ȣ�� ��� ����Ѵ�.*/

package ����;

import java.util.Arrays;
import java.util.Scanner;

public class N_1759 {
	static char[] result = new char[16];
	static StringBuilder sb = new StringBuilder();

	static void go(int index, int selected, char[] A, int C, int L) {
		if (selected == L) {
			int moeum = 0;
			int jaeum = 0;
			for (int i = 0; i < L; i++) {
				sb.append(result[i]);
				if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u')
					moeum++;
				else
					jaeum++;
			}
			if (moeum >= 1 && jaeum >= 2) {
				System.out.println(sb);
			} 
			return;
		}
		if (index == C) // index == L�� �ؼ� �ڲ� �������� �ſ���.
			return;
		result[selected] = A[index];
		go(index + 1, selected + 1, A, C, L);
		result[selected] = '0';
		sb.setLength(0);
		go(index + 1, selected, A, C, L);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int L = s.nextInt();
		int C = s.nextInt();
		char[] A = new char[C];
		for (int i = 0; i < C; i++) {
			A[i] = s.next().charAt(0);
		}
		Arrays.sort(A);
		go(0, 0, A, C, L);
	}
}
