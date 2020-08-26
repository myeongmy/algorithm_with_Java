//백준 11279번 최대 힙
//우선순위 큐 문제

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_11279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				int input = Integer.parseInt(br.readLine());

				if (input == 0) {
					int result;
					if (pq.size() == 0)
						result = 0;
					else
						result = pq.poll();

					System.out.println(result);
				} else {
					pq.offer(input);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
