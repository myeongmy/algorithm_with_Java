//���� 2908��
//���ڿ� ó�� ����
/*����
������� ���� ����� ������ ���� ���Ѵ�. ����� ���ڸ� �дµ� ������ �ִ�. �̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���. ����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.

����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, ����� �� ���� 437�� 398�� �д´�. ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.

�� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ����̰� ĥ�ǿ� ���� �� �� A�� B�� �־�����. �� ���� ���� ���� �� �ڸ� ���̸�, 0�� ���ԵǾ� ���� �ʴ�.

���
ù° �ٿ� ����� ����� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_2908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String[] arr = s.nextLine().split(" ");
		StringBuilder new_a = new StringBuilder();
		StringBuilder new_b = new StringBuilder();
		for (int i = arr[0].length() - 1; i >= 0; i--) {
			new_a.append(arr[0].charAt(i));
		}
		for (int i = arr[1].length() - 1; i >= 0; i--) {
			new_b.append(arr[1].charAt(i));
		}
		if (Integer.parseInt(new_a.toString()) > Integer.parseInt(new_b.toString())) {
			System.out.println(new_a);
		} else {
			System.out.println(new_b);
		}
	}

}
