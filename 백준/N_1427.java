//���� 1427��
//���� ���� Ǯ��
/*����
�迭�� �����ϴ� ���� ����. ���� �־�����, �� ���� �� �ڸ����� ������������ �����غ���.

�Է�
ù° �ٿ� �����ϰ����ϴ� �� N�� �־�����. N�� 1,000,000,000���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� �ڸ����� ������������ ������ ���� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int[] A = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			A[i] = str.charAt(i) - 48;
		}
		Arrays.sort(A);
		for (int i = A.length - 1; i >= 0; i--) {
			System.out.print(A[i]);
		}
	}

}
