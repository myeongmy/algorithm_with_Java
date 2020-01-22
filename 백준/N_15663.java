//���� 15663��
/*����
N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

N���� �ڿ��� �߿��� M���� �� ����
�Է�
ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8)

��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.*/

package ����;

import java.util.*;

public class N_15663 {
	static boolean[] c = new boolean[10];
	static int[] result = new int[10];
	static LinkedHashSet<String> set = new LinkedHashSet(); //TreeSet���� �ϴϱ� �ȵǰ� LinkedHashSet���� �ٲٴϱ� ����...HashSet�� Ʋ�Ƚ��ϴ� ��
	static StringBuilder sb = new StringBuilder();

	static void go(int index, int[] A, int N, int M) {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			set.add(sb.toString());
			return;
		}
		for (int i=0;i<A.length;i++) {
			if (c[i] == true)
				continue;
			c[i] = true;
			result[index] = A[i];
			go(index + 1, A, N, M);
			c[i] = false;
			result[index] = 0;
			sb.setLength(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		Arrays.sort(A);
		go(0, A, N, M);
		Iterator<String> it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
