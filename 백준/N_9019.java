//���� 9019��
//BFS ����
//�ð��ʰ��� ��Ÿ�ӿ��� ���� ����
//�ð��ʰ�: L����� R������ string���� �ٲ㼭 ������ ���� ���� �ڸ��� ������ ���� ���ؾ� ������.
//��Ÿ�ӿ���: �迭�� �ε��� ���� (S����)
/*����
�� ���� ��ɾ� D, S, L, R �� �̿��ϴ� ������ ���Ⱑ �ִ�. �� ���⿡�� �������Ͱ� �ϳ� �ִµ�, �� �������Ϳ��� 0 �̻� 10,000 �̸��� �������� ������ �� �ִ�. �� ��ɾ�� �� �������Ϳ� ����� n�� ������ ���� ��ȯ�Ѵ�. n�� �� �ڸ����� d1, d2, d3, d4��� ����(�� n = ((d1 �� 10 + d2) �� 10 + d3) �� 10 + d4��� ����)

D: D �� n�� �� ��� �ٲ۴�. ��� ���� 9999 ���� ū ��쿡�� 10000 ���� ���� �������� ���Ѵ�. �� ��� ��(2n mod 10000)�� �������Ϳ� �����Ѵ�.
S: S �� n���� 1 �� �� ��� n-1�� �������Ϳ� �����Ѵ�. n�� 0 �̶�� 9999 �� ��� �������Ϳ� ����ȴ�.
L: L �� n�� �� �ڸ����� �������� ȸ������ �� ����� �������Ϳ� �����Ѵ�. �� ������ ������ �������Ϳ� ����� �� �ڸ����� ������� d2, d3, d4, d1�� �ȴ�.
R: R �� n�� �� �ڸ����� ���������� ȸ������ �� ����� �������Ϳ� �����Ѵ�. �� ������ ������ �������Ϳ� ����� �� �ڸ����� ������� d4, d1, d2, d3�� �ȴ�.
������ ����� ��ó��, L �� R ��ɾ�� ���� �ڸ����� �����ϰ� ������ �����Ѵ�. ���� �� n = 1234 ��� ���⿡ L �� �����ϸ� 2341 �� �ǰ� R �� �����ϸ� 4123 �� �ȴ�.

�������� �ۼ��� ���α׷��� �־��� ���� �ٸ� �� ���� A�� B(A �� B)�� ���Ͽ� A�� B�� �ٲٴ� �ּ����� ��ɾ �����ϴ� ���α׷��̴�. ���� �� A = 1234, B = 3412 ��� ������ ���� �� ���� ��ɾ �����ϸ� A�� B�� ��ȯ�� �� �ִ�.

1234 ��L 2341 ��L 3412
1234 ��R 4123 ��R 3412

���� �������� ���α׷��� �� ��쿡 LL �̳� RR �� ����ؾ� �Ѵ�.

n�� �ڸ����� 0 �� ���Ե� ��쿡 �����ؾ� �Ѵ�. ���� �� 1000 �� L �� �����ϸ� 0001 �� �ǹǷ� ����� 1 �� �ȴ�. �׷��� R �� �����ϸ� 0100 �� �ǹǷ� ����� 100 �� �ȴ�.

�Է�
���α׷� �Է��� T ���� �׽�Ʈ ���̽��� �����ȴ�. �׽�Ʈ ���̽� ���� T �� �Է��� ù �ٿ� �־�����. �� �׽�Ʈ ���̽��δ� �� ���� ���� A�� B(A �� B)�� �������� �и��Ǿ� ���ʷ� �־����µ� A�� ���������� �ʱ� ���� ��Ÿ���� B�� ���� ���� ��Ÿ����. A �� B�� ��� 0 �̻� 10,000 �̸��̴�.

���
A���� B�� ��ȯ�ϱ� ���� �ʿ��� �ּ����� ��ɾ� ������ ����Ѵ�.*/

package ����;

import java.util.*;
import java.io.*;

class DSLR {
	int n;
	String oper;

	DSLR(int n, String oper) {
		this.n = n;
		this.oper = oper;
	}
}

public class N_9019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int A = Integer.parseInt(arr[0]);
				int B = Integer.parseInt(arr[1]);
				// bfs ������
				int[] c = new int[10005];
				Queue<DSLR> q = new LinkedList<DSLR>();

				c[A] = 1;
				q.offer(new DSLR(A, ""));

				while (!q.isEmpty()) {
					DSLR r = q.poll();
					if (r.n == B) {
						bw.write(r.oper);
						bw.newLine();
						break;
					}
					// D ����
					if (c[(2 * r.n) % 10000] == 0) {
						q.offer(new DSLR((2 * r.n) % 10000, r.oper + "D"));
						c[(2 * r.n) % 10000] = 1;
					}
					// S ����
					if (r.n == 0) {
						if (c[9999] == 0) {    //�̰� ���� r.n == 0 && c[9999] == 0���� ǥ���ؼ� ��Ÿ�� ����
							q.offer(new DSLR(9999, r.oper + "S"));
							c[9999] = 1;
						}
					} else {
						if (c[r.n - 1] == 0) {
							q.offer(new DSLR(r.n - 1, r.oper + "S"));
							c[r.n - 1] = 1;
						}
					}
					// L ����
					/* �ð��ʰ�
					 * StringBuilder str = new StringBuilder(Integer.toString(r.n)); 
					 * char temp = str.charAt(0); 
					 * str.deleteCharAt(0); 
					 * str.append(temp); 
					 * if(c[Integer.parseInt(str.toString())] == 0) {
					 *  q.offer(new DSLR(Integer.parseInt(str.toString()), r.oper + "L"));
					 * c[Integer.parseInt(str.toString())] = 1; 
					 * }
					 */
					if(c[(r.n % 1000)*10 + r.n / 1000] == 0) {
						q.offer(new DSLR((r.n % 1000)*10 + r.n / 1000, r.oper+"L"));
						c[(r.n % 1000)*10 + r.n / 1000] = 1;
					}
					// R ����
					/*
					 * StringBuilder str1 = new StringBuilder(Integer.toString(r.n)); char temp1 =
					 * str1.charAt(str1.length() - 1); str1.deleteCharAt(str1.length() - 1);
					 * str1.insert(0, temp1); if (c[Integer.parseInt(str1.toString())] == 0) {
					 * q.offer(new DSLR(Integer.parseInt(str1.toString()), r.oper + "R"));
					 * c[Integer.parseInt(str1.toString())] = 1; }
					 */
					if(c[r.n / 10 + (r.n / 1000) * 1000] == 0) {
						q.offer(new DSLR(r.n / 10 + (r.n / 1000) * 1000, r.oper+"R"));
						c[r.n / 10 + (r.n / 1000) * 1000] = 1;
					}

				}
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
