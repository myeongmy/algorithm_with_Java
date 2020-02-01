//���� 13458�� (���� ����)
// �ܼ� ��������? ���� ������ �ش��ϴ� ���ϴ�.
/*����
�� N���� �������� �ְ�, ������ �����帶�� �����ڵ��� �ִ�. i�� �����忡 �ִ� �������� ���� Ai���̴�.

�������� �Ѱ������� �ΰ��������� �� ������ �ִ�. �Ѱ������� �� �濡�� ������ �� �ִ� �������� ���� B���̰�, �ΰ������� �� �濡�� ������ �� �ִ� �������� ���� C���̴�.

������ �����忡 �Ѱ������� ���� 1�� �־�� �ϰ�, �ΰ������� ���� �� �־ �ȴ�.

�� �����帶�� ���û����� ��� �����ؾ� �Ѵ�. �̶�, �ʿ��� ������ ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �������� ���� N(1 �� N �� 1,000,000)�� �־�����.

��° �ٿ��� �� �����忡 �ִ� �������� �� Ai (1 �� Ai �� 1,000,000)�� �־�����.

��° �ٿ��� B�� C�� �־�����. (1 �� B, C �� 1,000,000)

���
�� �����帶�� ���û��� ��� �����ϱ� ���� �ʿ��� �������� �ּ� ���� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.io.*;

public class N_13458 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			String[] arr = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(arr[i]);
			}
			arr = br.readLine().split(" ");
			int B = Integer.parseInt(arr[0]); // �� �������� ������ �� �ִ� ���û� ��
			int C = Integer.parseInt(arr[1]); // �� �������� ������ �� �ִ� ���û� ��

			long primeNum = 0; // �ʿ��� �� ������ ��
			long subNum = 0;
			// �� �������� �����ϴ� �л� ���� �����ϰ� ���� �л� ��
			for (int i = 0; i < N; i++) {
				A[i] = A[i] - B;
				primeNum++;
			}
			// �� ������ �� ���
			for (int i = 0; i < N; i++) {
				if(A[i] <=0 ) continue;
				subNum += A[i] / C;
				if (A[i] % C != 0)
					subNum += 1;
			}
			System.out.println(subNum + primeNum);
			System.out.println(5%-2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
