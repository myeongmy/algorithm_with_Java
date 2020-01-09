//���� 14002��
/*����
���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {10, 20, 10, 30, 20, 50} �� ��쿡 ���� �� �����ϴ� �κ� ������ A = {10, 20, 10, 30, 20, 50} �̰�, ���̴� 4�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.

��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� ���� �� �����ϴ� �κ� ������ ���̸� ����Ѵ�.

��° �ٿ��� ���� �� �����ϴ� �κ� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_14002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int[] A = new int[arr.length];
			for (int i = 0; i < arr.length; i++)
				A[i] = Integer.parseInt(arr[i]);
			int[] d = new int[A.length];
			int[] prevIdx = new int[A.length];
			for (int i = 0; i < prevIdx.length; i++)
				prevIdx[i] = 1001;

			d[0] = 1;
			for (int i = 1; i < d.length; i++) {
				d[i] = 1;
				for (int j = i - 1; j >= 0; j--) {
					if (A[j] < A[i] && d[i] < d[j] + 1) {
						d[i] = d[j] + 1;
						prevIdx[i] = j;
					}
				}
			}

			int max = 0;
			int maxIdx = 0;
			for (int i = 0; i < d.length; i++) {
				if (max < d[i]) {
					max = d[i];
					maxIdx = i;
				}

			}

			// ��Ʈ��ŷ
			Stack<Integer> st = new Stack<Integer>();
			st.push(A[maxIdx]);
			while (prevIdx[maxIdx] != 1001) {
				st.push(A[prevIdx[maxIdx]]);
				maxIdx = prevIdx[maxIdx];
			}
			System.out.println(max);
			while (!st.empty())
				System.out.print(st.pop() + " ");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
