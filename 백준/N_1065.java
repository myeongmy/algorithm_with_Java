//���� 1065��
//���Ʈ ���� ����
/*����
� ���� ���� X�� �ڸ����� ���������� �̷�ٸ�, �� ���� �Ѽ���� �Ѵ�. ���������� ���ӵ� �� ���� ���� ���̰� ������ ������ ���Ѵ�. N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�
ù° �ٿ� 1,000���� �۰ų� ���� �ڿ��� N�� �־�����.

���
ù° �ٿ� 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int num = 0;
		Label: for (int i = 1; i <= N; i++) {
			String str = Integer.toString(i);
			if (str.length() <= 2) {
				num++;
				continue;
			}
			int diff = str.charAt(0) - str.charAt(1);
			for (int j = 1; j < str.length() - 1; j++) {
				if (diff != str.charAt(j) - str.charAt(j + 1))
					continue Label;
			}
			num++;
		}
		System.out.println(num);
	}

}
