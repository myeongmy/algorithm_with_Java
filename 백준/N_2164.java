//�ùķ��̼� ����(ť �̿�)

package ����;

import java.io.*;
import java.util.*;

public class N_2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>();

			// ť �ʱ�ȭ
			for (int i = 1; i <= N; i++)
				q.offer(i);

			while (q.size() != 1) {
				q.poll();
				q.offer(q.poll());
			}
			System.out.println(q.peek());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
