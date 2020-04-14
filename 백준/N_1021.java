//���� 1021��
//�ùķ��̼� ����

package ����;

import java.io.*;
import java.util.*;

public class N_1021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			int[] A = new int[M];
			String[] arr = br.readLine().split(" ");
			for (int i = 0; i < M; i++)
				A[i] = Integer.parseInt(arr[i]);

			LinkedList<Integer> queue = new LinkedList<Integer>();
			for (int i = 1; i <= N; i++) // ť�� ���� �ֱ�
				queue.add(i);

			int Apointer = 0;
			int operationNum = 0;

			while (Apointer != M) {
				if (A[Apointer] == queue.get(0)) { // ť�� �� �� ���ҿ� �̾ƾ��ϴ� ���� ���� ���
					queue.remove(0);
					Apointer++;
				} else {
					if (queue.size() / 2 < queue.indexOf(A[Apointer])) { // 3�� ������ ȿ����
						while (queue.get(0) != A[Apointer]) {
							queue.add(0, queue.remove(queue.size() - 1));
							operationNum++;
						}
						queue.remove(0);
						Apointer++;
					} else { // 2�� ������ ȿ����
						while (queue.get(0) != A[Apointer]) {
							queue.add(queue.remove(0));
							operationNum++;
						}
						queue.remove(0);
						Apointer++;
					}
				}
			}
			System.out.println(operationNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
