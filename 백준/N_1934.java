//���� 1934��
/*����
�� �ڿ��� A�� B�� ���ؼ�, A�� ����̸鼭 B�� ����� �ڿ����� A�� B�� �������� �Ѵ�. �̷� ����� �߿��� ���� ���� ���� �ּҰ������� �Ѵ�. ���� ���, 6�� 15�� ������� 30, 60, 90���� ������, �ּ� ������� 30�̴�.

�� �ڿ��� A�� B�� �־����� ��, A�� B�� �ּҰ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T(1 �� T �� 1,000)�� �־�����. ��° �ٺ��� T���� �ٿ� ���ļ� A�� B�� �־�����. (1 �� A, B �� 45,000)

���
ù° �ٺ��� T���� �ٿ� A�� B�� �ּҰ������ �Է¹��� ������� �� �ٿ� �ϳ��� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1934 {
	static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int A = Integer.parseInt(arr[0]);
				int B = Integer.parseInt(arr[1]);
				int G = GCD(A, B);
				int L = A * B / G;
				System.out.println(L);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
