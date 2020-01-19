//���� 17299��
/*����
ũ�Ⱑ N�� ���� A = A1, A2, ..., AN�� �ִ�. ������ �� ���� Ai�� ���ؼ� ����ū�� NGF(i)�� ���Ϸ��� �Ѵ�.

Ai�� ���� A���� ������ Ƚ���� F(Ai)��� ���� ��, Ai�� ����ū���� �����ʿ� �����鼭 ���� A���� ������ Ƚ���� F(Ai)���� ū �� �߿��� ���� ���ʿ� �ִ� ���� �ǹ��Ѵ�. �׷��� ���� ���� ��쿡 ����ū���� -1�̴�.

���� ���, A = [1, 1, 2, 3, 4, 2, 1]�� ��� F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1�̴�. A1�� �����ʿ� �����鼭 ������ Ƚ���� 3���� ū ���� ���� ������, NGF(1) = -1�̴�. A3�� ��쿡�� A7�� �����ʿ� �����鼭 F(A3=2) < F(A7=1) �̱� ������, NGF(3) = 1�̴�. NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 �̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000,000)�� �־�����. ��°�� ���� A�� ���� A1, A2, ..., AN (1 �� Ai �� 1,000,000)�� �־�����.

���
�� N���� �� NGF(1), NGF(2), ..., NGF(N)�� �������� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_17299 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] NGF = new int[N];
			int[] freq = new int[1000001]; // �迭 ������ �󵵼��� �����ϴ� �迭
			Stack<Integer> st = new Stack<Integer>();

			String[] arr = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(arr[i]);
				freq[A[i]]++;
			}
			for (int i = 0; i < N; i++) {
				if (st.empty()) {
					st.push(i);
					continue;
				}
				while (freq[A[st.peek()]] < freq[A[i]]) {
					NGF[st.peek()] = A[i];
					st.pop();
					if (st.empty())
						break;
				}
				st.push(i);

			}
			while (!st.empty()) {
				NGF[st.pop()] = -1;
			}
			for (int i = 0; i < NGF.length; i++) {
				if (i == NGF.length - 1)
					System.out.print(NGF[i]);
				else
					System.out.print(NGF[i] + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
