//���� 15664��
/*����
N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

N���� �ڿ��� �߿��� M���� �� ����
�� ������ �񳻸������̾�� �Ѵ�.
���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
�Է�
ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8)

��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.*/

package ����;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class N_15664 {
	static int[] result = new int[10];
	static LinkedHashSet<String> hs = new LinkedHashSet<String>();
	static StringBuilder sb = new StringBuilder();

	static void go(int index, int selected, int[] A, int N, int M) {
		if (selected == M) {
			for (int i = 0; i < selected; i++) {
				sb.append(result[i] + " ");
			}
			hs.add(sb.toString());
			return;
		}
		if (index == N)
			return;
		result[selected] = A[index];
		go(index + 1, selected + 1, A, N, M);
		result[selected] = 0;
		sb.setLength(0); // �� �κ��� �߿�!!!
		go(index + 1, selected, A, N, M);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();
		Arrays.sort(A);
		go(0, 0, A, N, M);
		Iterator<String> it = hs.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
