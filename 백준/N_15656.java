//���� 15656��
/*����
N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. N���� �ڿ����� ��� �ٸ� ���̴�.

N���� �ڿ��� �߿��� M���� �� ����
���� ���� ���� �� ��� �ȴ�.
�Է�
ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 7)

��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.*/

package ����;

import java.io.*;
import java.util.Arrays;

public class N_15656 {
	static int[] result = new int[10];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void go(int index, int[] A, int N, int M) throws IOException {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				bw.write(Integer.toString(result[i]) + " ");
			}
			bw.newLine();
			return;
		}
		for (int a : A) {
			result[index] = a;
			go(index + 1, A, N, M);
			result[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int[] A = new int[N];
			arr = br.readLine().split(" ");
			for (int i = 0; i < arr.length; i++) {
				A[i] = Integer.parseInt(arr[i]);
			}
			Arrays.sort(A);
			go(0, A, N, M);

			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
