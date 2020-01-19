//���� 11053��
/*����
���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {10, 20, 10, 30, 20, 50} �� ��쿡 ���� �� �����ϴ� �κ� ������ A = {10, 20, 10, 30, 20, 50} �̰�, ���̴� 4�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.

��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� ���� �� �����ϴ� �κ� ������ ���̸� ����Ѵ�.*/

package codingtest_study.����;

import java.io.*;

public class N_11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int[] A = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				A[i] = Integer.parseInt(arr[i]);
			}
			int[] d = new int[A.length];
			d[0] = 1;
			for (int i = 1; i < A.length; i++) {
				d[i] = 1;
				for (int j = i - 1; j >= 0; j--) {
					if (A[j] < A[i] && d[i] < d[j] + 1)
						d[i] = d[j] + 1;
				}
			}
			int max = 0;
			for (int num : d) {
				if (max < num)
					max = num;
			}
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
