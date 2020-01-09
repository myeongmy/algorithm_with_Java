//���� 1912��
/*����
n���� ������ �̷���� ������ ������ �־�����. �츮�� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� �� �� ���� ū ���� ���Ϸ��� �Ѵ�. ��, ���� �� �� �̻� �����ؾ� �Ѵ�.

���� �� 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 �̶�� ������ �־����ٰ� ����. ���⼭ ������ 12+21�� 33�� ������ �ȴ�.

�Է�
ù° �ٿ� ���� n(1 �� n �� 100,000)�� �־����� ��° �ٿ��� n���� ������ �̷���� ������ �־�����. ���� -1,000���� ũ�ų� ����, 1,000���� �۰ų� ���� �����̴�.

���
ù° �ٿ� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int[] A = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				A[i] = Integer.parseInt(arr[i]);
			}
			long[] d = new long[A.length];
			d[0] = A[0];
			for (int i = 1; i < d.length; i++) {
				d[i] = A[i];
				if (A[i] < d[i - 1] + A[i])
					d[i] = d[i - 1] + A[i];
			}
			long max = d[0];
			for (long num : d) {
				if (max < num)
					max = num;
			}
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
