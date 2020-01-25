//���� 10971��
/*����
���ǿ� ��ȸ ������ ����� Traveling Salesman problem (TSP) ��� �Ҹ��� ������ computer science �о߿��� ���� �߿��ϰ� ��޵Ǵ� ���� �� �ϳ��̴�. ���� ���� ���� ������ ������, ���⼭�� ���� �Ϲ����� ������ ������ ���캸��.

1������ N������ ��ȣ�� �Ű��� �ִ� ���õ��� �ְ�, ���õ� ���̿��� ���� �ִ�. (���� ���� ���� �ִ�) ���� �� ���ǿ��� ��� �� ���ÿ��� ����� N���� ���ø� ��� ���� �ٽ� ������ ���÷� ���ƿ��� ��ȸ ���� ��θ� ��ȹ�Ϸ��� �Ѵ�. ��, �� �� ���� ���÷δ� �ٽ� �� �� ����. (�� �������� ������ ����ߴ� ���÷� ���ƿ��� ���� ����) �̷� ���� ��δ� ���� ������ ���� �� �ִµ�, ���� ���� ����� ���̴� ���� ��ȹ�� ������� �Ѵ�.

�� ���ð��� �̵��ϴµ� ��� ����� ��� W[i][j]���·� �־�����. W[i][j]�� ���� i���� ���� j�� ���� ���� ����� ��Ÿ����. ����� ��Ī������ �ʴ�. ��, W[i][j] �� W[j][i]�� �ٸ� �� �ִ�. ��� ���ð��� ����� ���� �����̴�. W[i][i]�� �׻� 0�̴�. ��쿡 ���� ���� i���� ���� j�� �� �� ���� ��쵵 ������ �̷� ��� W[i][j]=0�̶�� ����.

N�� ��� ����� �־����� ��, ���� ���� ����� ���̴� ���ǿ��� ��ȸ ���� ��θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ �� N�� �־�����. (2 �� N �� 10) ���� N���� �ٿ��� ��� ����� �־�����. �� ����� ������ 1,000,000 ������ ���� �����̸�, �� �� ���� ���� 0�� �־�����. W[i][j]�� ���� i���� j�� ���� ���� ����� ��Ÿ����.

�׻� ��ȸ�� �� �ִ� ��츸 �Է����� �־�����.

���
ù° �ٿ� ���ǿ��� ��ȸ�� �ʿ��� �ּ� ����� ����Ѵ�.*/

package ����;
import java.util.Scanner;



public class N_10971 {
	static boolean[] c = new boolean[11];
	static int[] result = new int[11];
	static int[][] A;
	static int min = 1000000*10+1;

	static void go(int index, int N) {
		if (index == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				if (A[result[i]][result[i + 1]] == 0)
					return;
				else sum += A[result[i]][result[i + 1]];
			}
			
			if (A[result[index - 1]][result[0]] == 0)
				return;
			sum += A[result[index - 1]][result[0]];
			
			if (min > sum)
				min = sum;
			return;
		}
		for (int i = 0; i <= N - 1; i++) {
			if (c[i] == true)
				continue;
			c[i] = true;
			result[index] = i;
			go(index + 1, N);
			c[i] = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
			}
		}
		go(0, N);
		System.out.println(min);
	}

}
