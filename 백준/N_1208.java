//���� 1208��
//�̺�Ž�� ���� Ǯ��
/*����
N���� ������ �̷���� ������ ���� ��, ũ�Ⱑ ����� �κм��� �߿��� �� ������ ���Ҹ� �� ���� ���� S�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ������ ��Ÿ���� N�� ���� S�� �־�����. (1 �� N �� 40, |S| �� 1,000,000) ��° �ٿ� N���� ������ �� ĭ�� ���̿� �ΰ� �־�����. �־����� ������ ������ 100,000�� ���� �ʴ´�.

���
ù° �ٿ� ���� S�� �Ǵ� �κм����� ������ ����Ѵ�.*/

package ����;

import java.util.*;
import java.io.*;

public class N_1208 {
	static int[] A;
	static int[] result = new int[40];
	static ArrayList<Integer> first = new ArrayList<Integer>();
	static ArrayList<Integer> second = new ArrayList<Integer>();

	static void go(int index, int selected, int last) {
		if (index > last) {
			int sum = 0;
			for (int i = 0; i < selected; i++) {
				sum += result[i];
			}
			first.add(sum);
			return;
		}
		result[selected] = A[index];
		go(index + 1, selected + 1, last);
		result[selected] = 0;

		go(index + 1, selected, last);
	}

	static void go1(int index, int selected, int start) {
		if (start + index == A.length) {
			int sum = 0;
			for (int i = 0; i < selected; i++)
				sum += result[i];
			second.add(sum);
			return;
		}
		result[selected] = A[start + index];
		go1(index + 1, selected + 1, start);
		result[selected] = 0;

		go1(index + 1, selected, start);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int S = Integer.parseInt(arr[1]);

			A = new int[N];
			String[] arr1 = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(arr1[i]);
			}
			go(0, 0, N / 2);
			go1(0, 0, N / 2 + 1);

			Collections.sort(first);
			Collections.sort(second);

			int leftpo = 0;
			int rightpo = second.size() - 1;

			long cnt = 0;
			while (leftpo < first.size() && rightpo >= 0) {
				if (first.get(leftpo) + second.get(rightpo) > S) {
					rightpo--;
				} else if (first.get(leftpo) + second.get(rightpo) == S) {    //�ߺ� �� ó��
					int temp = first.get(leftpo);
					int temp1 = second.get(rightpo);

					long lcnt = 0;
					while (leftpo < first.size() && first.get(leftpo) == temp) {
						leftpo++;
						lcnt++;
					}

					long rcnt = 0;
					while (rightpo >= 0 && second.get(rightpo) == temp1) {
						rightpo--;
						rcnt++;
					}
					cnt += lcnt * rcnt;
				} else if (first.get(leftpo) + second.get(rightpo) < S) {
					leftpo++;
				}
			}
			if (S == 0)
				cnt--;
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
