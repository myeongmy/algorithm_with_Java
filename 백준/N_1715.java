//백준 1715번 카드 정렬하기
//min heap 이용

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1715 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

			for (int i = 0; i < N; i++) {
				pq.offer(Integer.parseInt(br.readLine()));
			}

			int comparisonNum = 0;

			while (pq.size() > 1) {
				int a = pq.poll();
				int b = pq.poll();

				comparisonNum += (a + b);
				pq.offer(a + b);
			}
			System.out.println(comparisonNum);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
