//���� 7453��
//�̺�Ž�� ���� Ǯ��
/*����
������ �̷���� ũ�Ⱑ ���� �迭 A, B, C, D�� �ִ�.

A[a], B[b], C[c], D[d]�� ���� 0�� (a, b, c, d) ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �迭�� ũ�� n (1 �� n �� 4000)�� �־�����. ���� n�� �ٿ��� A, B, C, D�� ���ԵǴ� ������ �������� ���еǾ����� �־�����. �迭�� ����ִ� ������ ������ �ִ� 228�̴�.

���
���� 0�� �Ǵ� ���� ������ ����Ѵ�.*/

package ����;

import java.io.*;
import java.util.*;

public class N_7453 {
	static int[] A;
	static int[] B;
	static int[] C;
	static int[] D;
	static ArrayList<Integer> first = new ArrayList<Integer>(); // �� �� �׷� ������ �� ����
	static ArrayList<Integer> second = new ArrayList<Integer>();
	static int[] result = new int[2];

	static void go(int index) {
		if (index == 2) {
			int sum = result[0] + result[1];

			first.add(sum);
			return;
		}
		if (index == 0) {
			for (int i = 0; i < A.length; i++) {
				result[index] = A[i];
				go(index + 1);
				result[index] = 0;
			}
		} else if (index == 1) {
			for (int i = 0; i < B.length; i++) {
				result[index] = B[i];
				go(index + 1);
				result[index] = 0;
			}
		}
	}

	static void go1(int index) {
		if (index == 2) {
			int sum = result[0] + result[1];

			second.add(sum);
			return;
		}
		if (index == 0) {
			for (int i = 0; i < C.length; i++) {
				result[index] = C[i];
				go1(index + 1);
				result[index] = 0;
			}
		} else if (index == 1) {
			for (int i = 0; i < D.length; i++) {
				result[index] = D[i];
				go1(index + 1);
				result[index] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());

			A = new int[n];
			B = new int[n];
			C = new int[n];
			D = new int[n];

			for (int i = 0; i < n; i++) {
				String[] arr = br.readLine().split(" ");

				A[i] = Integer.parseInt(arr[0]);
				B[i] = Integer.parseInt(arr[1]);
				C[i] = Integer.parseInt(arr[2]);
				D[i] = Integer.parseInt(arr[3]);
			}

			go(0); // A�� B
			go1(0); // C�� D

			Collections.sort(first);
			Collections.sort(second);

			// �� ������
			int leftpo = 0;
			int rightpo = second.size() - 1;
			long cnt = 0;

			while (leftpo < first.size() && rightpo >= 0) {
				if (first.get(leftpo) + second.get(rightpo) > 0) {
					rightpo--;
				} else if (first.get(leftpo) + second.get(rightpo) == 0) { // �ߺ� �� ó��
					int temp = first.get(leftpo);
					int temp1 = second.get(rightpo);

					long lcnt = 0;
					while (leftpo < first.size() && temp == first.get(leftpo)) {
						leftpo++;
						lcnt++;
					}

					long rcnt = 0;
					while (rightpo >= 0 && temp1 == second.get(rightpo)) {
						rightpo--;
						rcnt++;
					}

					cnt += lcnt * rcnt;
				} else if (first.get(leftpo) + second.get(rightpo) < 0) {
					leftpo++;
				}
			}
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
