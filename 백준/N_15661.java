//���� 15661��
/*����
������ ��ŸƮ��ũ�� �ٴϴ� ������� �𿩼� �౸�� �غ����� �Ѵ�. �౸�� ���� ���Ŀ� �ϰ� �ǹ� ������ �ƴϴ�. �౸�� �ϱ� ���� ���� ����� �� N���̴�. ���� ��ŸƮ ���� ��ũ ������ ������� ������ �Ѵ�. �� ���� �ο����� ���� �ʾƵ� ������, �� �� �̻��̾�� �Ѵ�.

BOJ�� ��ϴ� ȸ�� ��� ������� ��ȣ�� 1���� N������ �����߰�, �Ʒ��� ���� �ɷ�ġ�� �����ߴ�. �ɷ�ġ Sij�� i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�̴�. ���� �ɷ�ġ�� ���� ���� ��� ���� �ɷ�ġ Sij�� ���̴�. Sij�� Sji�� �ٸ� ���� ������, i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�� Sij�� Sji�̴�.

N=4�̰�, S�� �Ʒ��� ���� ��츦 ���캸��.

i\j	1	2	3	4
1	 	1	2	3
2	4	 	5	6
3	7	1	 	2
4	3	4	5	 
���� ���, 1, 2���� ��ŸƮ ��, 3, 4���� ��ũ ���� ���� ��쿡 �� ���� �ɷ�ġ�� �Ʒ��� ����.

��ŸƮ ��: S12 + S21 = 1 + 4 = 5
��ũ ��: S34 + S43 = 2 + 5 = 7
1, 3���� ��ŸƮ ��, 2, 4���� ��ũ ���� ���ϸ�, �� ���� �ɷ�ġ�� �Ʒ��� ����.

��ŸƮ ��: S13 + S31 = 2 + 7 = 9
��ũ ��: S24 + S42 = 6 + 4 = 10
�౸�� ����ְ� �ϱ� ���ؼ� ��ŸƮ ���� �ɷ�ġ�� ��ũ ���� �ɷ�ġ�� ���̸� �ּҷ� �Ϸ��� �Ѵ�. ���� ������ ���� ��쿡�� 1, 4���� ��ŸƮ ��, 2, 3�� ���� ��ũ ���� ���ϸ� ��ŸƮ ���� �ɷ�ġ�� 6, ��ũ ���� �ɷ�ġ�� 6�� �Ǿ ���̰� 0�� �ǰ� �� ���� �ּ��̴�.

�Է�
ù° �ٿ� N(4 �� N �� 20)�� �־�����. ��° �ٺ��� N���� �ٿ� S�� �־�����. �� ���� N���� ���� �̷���� �ְ�, i�� ���� j��° ���� Sij �̴�. Sii�� �׻� 0�̰�, ������ Sij�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.

���
ù° �ٿ� ��ŸƮ ���� ��ũ ���� �ɷ�ġ�� ������ �ּڰ��� ����Ѵ�.*/

package ����;

import java.io.*;
import java.util.*;

public class N_15661 {
	static boolean[] result = new boolean[21];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> notlist = new ArrayList<Integer>();
	static int min = 1000000;

	static void go(int index, int selected, int N, int M, int[][] A) {
		if (selected == M) {
			for (int i = 0; i < N; i++) {
				if (result[i] == true)
					list.add(i);
				else
					notlist.add(i);
			}
			int sum1 = 0;
			int sum2 = 0;
			Label: for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (list.size() == 1)
						break Label;
					sum1 += A[list.get(i)][list.get(j)];
				}

			}

			Label: for (int i = 0; i < notlist.size(); i++) {
				for (int j = 0; j < notlist.size(); j++) {
					if (notlist.size() == 1)
						break Label;
					sum2 += A[notlist.get(i)][notlist.get(j)];
				}

			}
			if (min > Math.abs(sum1 - sum2)) {
				min = Math.abs(sum1 - sum2);
			}
			list.clear();
			notlist.clear();
			return;
		}
		if (index == N)
			return;
		result[index] = true;
		go(index + 1, selected + 1, N, M, A);
		result[index] = false;
		go(index + 1, selected, N, M, A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] A = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
					A[i][j] = Integer.parseInt(arr[j]);
			}
			for (int M = 1; M < N; M++)
				go(0, 0, N, M, A);
			System.out.println(min);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
