//���� 15666��
/*����
N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

N���� �ڿ��� �߿��� M���� �� ����
���� ���� ���� �� ��� �ȴ�.
�� ������ �񳻸������̾�� �Ѵ�.
���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
�Է�
ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8)

��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.*/

package ����;

import java.io.*;
import java.util.*;

public class N_15666 {
	static int[] result = new int[10];
	static LinkedHashSet<String> hs = new LinkedHashSet<String>();
	static StringBuilder sb = new StringBuilder();

	static void go(int index, int start, int[] A, int N, int M) {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			hs.add(sb.toString());
			return;
		}
		for (int i = start; i < N; i++) {
			result[index] = A[i];
			go(index + 1, i, A, N, M);
			result[index] = 0;
			sb.setLength(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			arr = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i = 0; i < arr.length; i++)
				A[i] = Integer.parseInt(arr[i]);

			Arrays.sort(A);
			go(0, 0, A, N, M);
			Iterator<String> it = hs.iterator();
			while (it.hasNext())
				System.out.println(it.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
