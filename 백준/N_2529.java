//���� 2529��
/*����
�� ������ �ε�ȣ ��ȣ ��<���� ��>���� k�� ������ ������  A�� �ִ�. �츮�� �� �ε�ȣ ��ȣ �յڿ� ���� �ٸ� �� �ڸ��� ���ڸ� �־ ��� �ε�ȣ ���踦 ������Ű���� �Ѵ�. ���� ���, ���õ� �ε�ȣ ������ A�� ������ ���ٰ� ����. 

A =>  < < < > < < > < >

�ε�ȣ ��ȣ �յڿ� ���� �� �ִ� ���ڴ� 0���� 9������ �����̸� ���õ� ���ڴ� ��� �޶�� �Ѵ�. �Ʒ��� �ε�ȣ ������ A�� ������Ű�� �� ���̴�. 

3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0

�� ��Ȳ���� �ε�ȣ ��ȣ�� ������ ��, ���ڸ� ��� ���̸� �ϳ��� ���� ���� �� �ִµ� �� ���� �־��� �ε�ȣ ���踦 ������Ű�� ������� �Ѵ�. �׷��� �־��� �ε�ȣ ���踦 �����ϴ� ������ �ϳ� �̻� �����Ѵ�. ���� ��� 3456128790 �Ӹ� �ƴ϶� 5689023174�� �Ʒ��� ���� �ε�ȣ ���� A�� ������Ų��. 

5 < 6 < 8 < 9 > 0 < 2 < 3 > 1 < 7 > 4

�������� ���õ� k���� �ε�ȣ ������ �����ϴ� (k+1)�ڸ��� ���� �߿��� �ִ񰪰� �ּڰ��� ã�ƾ� �Ѵ�. �ռ� ������ ��� �� �ε�ȣ�� �յڿ� ���� ���ڴ� { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }�߿��� �����ؾ� �ϸ� ���õ� ���ڴ� ��� �޶�� �Ѵ�. 

�Է�
ù �ٿ� �ε�ȣ ������ ������ ��Ÿ���� ���� k�� �־�����. �� ���� �ٿ��� k���� �ε�ȣ ��ȣ�� �ϳ��� ������ �ΰ� �� �ٿ� ��� ���õȴ�. k�� ������ 2 �� k �� 9 �̴�. 

���
�������� ���õ� �ε�ȣ ���踦 �����ϴ� k+1 �ڸ��� �ִ�, �ּ� ������ ù° �ٰ� ��° �ٿ� ���� ����ؾ� �Ѵ�. �� �Ʒ� ��(1)�� ���� ù �ڸ��� 0�� ��쵵 ������ ���ԵǾ�� �Ѵ�. ��� �Է¿� ���� �׻� �����ϸ� ��� ������ �ϳ��� ���ڿ��� �ǵ��� �ؾ� �Ѵ�.*/

package ����;

import java.util.*;

public class N_2529 {
	static boolean[] c = new boolean[10];
	static StringBuilder sb = new StringBuilder();
	static StringBuilder max = new StringBuilder("0");
	static StringBuilder min = new StringBuilder("9999999999");

	static void go(int index, int N, char[] A) {
		if (index == N + 1) {
			for (int i = 0; i < A.length; i++) {
				if (A[i] == '<') {
					if (sb.charAt(i) - 48 > sb.charAt(i + 1) - 48)
						return;
				} else {
					if (sb.charAt(i) - 48 < sb.charAt(i + 1) - 48)
						return;
				}

			}
			if (Long.parseLong(max.toString()) < Long.parseLong(sb.toString())) {
				max.delete(0, max.length());
				max.append(sb);
			}
			if (Long.parseLong(min.toString()) > Long.parseLong(sb.toString())) {
				min.delete(0, min.length());
				min.append(sb);
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (c[i] == true)
				continue;
			c[i] = true;
			sb.append(i);
			go(index + 1, N, A);
			c[i] = false;
			sb.deleteCharAt(sb.length() - 1); // �� �κ��� sb.setLength(0);���� �ϸ� �ȵȴ�.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		char[] A = new char[k];
		for (int i = 0; i < A.length; i++)
			A[i] = s.next().charAt(0);
		go(0, k, A);
		System.out.println(max);
		System.out.println(min);

	}

}
