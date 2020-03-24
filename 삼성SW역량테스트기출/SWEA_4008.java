//[���� SW �����׽�Ʈ] ���� �����
//���Ʈ ���� ����(next_permutation �̿�)
/*��ǥ�� ������ ���� ��Ģ ������ �����ϰ� �ִ�.

N���� ���ڰ� ���� �ִ� ���� ���� �ְ�, +, -, x, / �� ������ ī�带 ���� ���̿� ���� �־� �پ��� ��� ���� ���غ���� �ߴ�.

������ ����� �� �������� �켱 ������ ������� �ʰ� ���ʿ��� ���������� ���ʴ�� ����Ѵ�.

���� ��� 1, 2, 3 �� ���� ���� �ǿ� +�� x�� �־� 1 + 2 * 3�� ����� 1 + 2�� ���� ����ϰ� �� �ڿ� * �� ����Ѵ�.

�� 1+2*3�� ����� 9�̴�.
 

�־��� ������ ī�带 ����Ͽ� ������ ������� �� �� ����� �ִ밡 �Ǵ� ���İ� �ּҰ� �Ǵ� ������ ã��, �� ���� ���̸� ����Ͻÿ�.


[����]

[Figure 1] �� ���� [3,5,3,7,9]�� ���� �����ǰ� [��+�� 2��, ��-�� 1��, ��/�� 1��]�� ������ ī�尡 �־��� ��츦 �����غ���.


[Figure 1]

 

�Ʒ� [Table 1]�� ���� �� �ִ� ���İ� ��� ����̴�.

                   

����

������ ��� ���

3 + 5 + 3 - 7 / 9

0

3 + 5 + 3 / 7 - 9

-8

3 + 5 - 3 + 7 / 9

1

3 + 5 - 3 / 7 + 9

9

3 + 5 / 3 + 7 - 9

0

3 + 5 / 3 - 7 + 9

4

3 / 5 + 3 + 7 - 9

1

3 / 5 + 3 - 7 + 9

5

3 / 5 - 3 + 7 + 9

13

3 - 5 + 3 + 7 / 9

0

3 - 5 + 3 / 7 + 9

9

3 - 5 / 3 + 7 + 9

16

                                   [Table 1]
 

�� ��� �ִ��� 3 - 5 / 3 + 7 + 9 = 16, �ּڰ��� 3 + 5 + 3 / 7 - 9 = -8 �̴�.

�� ����� �ִ񰪰� �ּڰ��� ���� ( 16 - ( -8 ) ) �� 24 �� ���� �ȴ�.

 

[�������]

1. �ð� ���� : �ִ� 50 �� �׽�Ʈ ���̽��� ��� ����ϴ� �� C / C++ / Java ��� 3 ��

2. ���� �ǿ� ���� ������ ���� N �� 3 �̻� 12 ������ �����̴�. ( 3 �� N �� 12 )

3. ������ ī�� ������ �� ���� �׻� N - 1 �̴�.

4. ���� �ǿ� ���� ���ڴ� 1 �̻� 9 ������ �����̴�.

5. ������ �ϼ��� �� �� ������ ī�带 ��� ����ؾ� �Ѵ�..

6. ���ڿ� ���� ���̿��� �����ڰ� 1 ���� ���� �Ѵ�.

7. �ϼ��� ������ ����� �� �������� �켱 ������ ������� �ʰ�, ���ʿ��� ���������� ���ʴ�� ����Ѵ�.

8. �������� ��� �� �� �Ҽ��� ���ϴ� ������.

9. �Է����� �־����� ������ ������ ������ �� ����.

10. ���� ���� ���� -100,000,000 �̻� 100,000,000 �������� ����ȴ�.

 

[�Է�]

�Է��� �� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T �� �־�����,

�� ���� �ٺ��� T ���� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ������ ���� N �� �־�����.

���� �ٿ��� '+', '-', '*', '/' ������� ������ ī���� ������ ������ ���̿� �ΰ� �־�����.

���� �ٿ��� ���Ŀ� ���� N ���� ���ڰ� ������� ������ ���̿� �ΰ� �־�����.
 

[���]

�׽�Ʈ ���̽� ������ŭ T ���� �ٿ� ������ �׽�Ʈ ���̽��� ���� ���� ����Ѵ�.

�� ���� "#t" �� �����ϰ� ������ �ϳ� �� ���� ������ ����Ѵ�. ( t �� 1 ���� �����ϴ� �׽�Ʈ ���̽��� ��ȣ�̴�. )

������ ������ ī�带 ����Ͽ� ���� �� �ִ� �������� ���� ����� �� �ִ񰪰� �ּڰ��� �����̴�.*/

package �ＺSW�����׽�Ʈ����;

import java.io.*;
import java.util.*;

public class SWEA_4008 {
	static boolean next_permutation(int[] result) {
		// �������� ã��
		int i;
		for (i = result.length - 2; i >= 0; i--) {
			if (result[i] < result[i + 1])
				break;
		}
		if (i == -1)
			return false;
		int idx = 0; // �ٲ� �ε��� ��ġ
		int j;
		for (j = i + 1; j < result.length; j++) {
			if (result[i] < result[j])
				idx = j;
		}
		int temp = result[i];
		result[i] = result[idx];
		result[idx] = temp;
		// �������� ����
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int k = i + 1; k < result.length; k++)
			list.add(result[k]);

		Collections.sort(list);
		for (int k = i + 1; k < result.length; k++)
			result[k] = list.remove(0);
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				int[] operator = new int[4];
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < 4; j++)
					operator[j] = Integer.parseInt(arr[j]);

				int[] A = new int[N];
				String[] arr1 = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
					A[j] = Integer.parseInt(arr1[j]);

				int[] result = new int[N - 1];
				int idx = 0;
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < operator[j]; k++) {
						result[idx] = j; // 0: +, 1: -, *: 2, / : 3
						idx++;
					}
				}
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;

				do {
					int total = A[0];
					for (int j = 1; j < N; j++) {
						if (result[j - 1] == 0) {
							total += A[j];
						} else if (result[j - 1] == 1) {
							total -= A[j];
						} else if (result[j - 1] == 2) {
							total *= A[j];
						} else if (result[j - 1] == 3) {
							total /= A[j];
						}
					}
					if (min > total)
						min = total;
					if (max < total)
						max = total;

				} while (next_permutation(result));
				System.out.println("#" + (i + 1) + " " + (max - min));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
