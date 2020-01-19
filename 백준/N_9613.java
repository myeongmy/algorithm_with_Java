//���� 9613��
/*����
���� ���� n���� �־����� ��, ������ ��� ���� GCD�� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� t (1 �� t �� 100)�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. �� �׽�Ʈ ���̽��� ���� ���� n (1 < n �� 100)�� �־�����, �������� n���� ���� �־�����. �Է����� �־����� ���� 1000000�� ���� �ʴ´�.

���
�� �׽�Ʈ ���̽����� ������ ��� ���� GCD�� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9613 {
	static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String[] arr = br.readLine().split(" ");
				int n = Integer.parseInt(arr[0]);
				long result = 0;
				for (int j = 1; j < arr.length - 1; j++) {
					for (int k = j + 1; k < arr.length; k++) {
						result += GCD(Integer.parseInt(arr[j]), Integer.parseInt(arr[k]));
					}
				}
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
