//백준 2014번 소수의 곱
//우선순위 큐 이용

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class N_2014 {
	static PriorityQueue<Long> pq = new PriorityQueue<Long>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int K = Integer.parseInt(input[0]);
			int N = Integer.parseInt(input[1]);
			long max = Long.MIN_VALUE;

			String[] arr = br.readLine().split(" ");
			int[] A = new int[K];
			for (int i = 0; i < arr.length; i++) {
				A[i] = Integer.parseInt(arr[i]);
				pq.offer((long) A[i]);
				if (max < (long) A[i])
					max = (long) A[i];
			}

			HashMap<Long, Integer> hm = new HashMap<Long, Integer>(); // 해당 key 값의 등장 여부
			for (int i = 0; i < N - 1; i++) { // N-1번 반복해주면 된다.
				long a = pq.peek();
				pq.poll();
				
				for (int j = 0; j < A.length; j++) {
					if (pq.size() > N && max < a * A[j])
						continue;

					if (hm.get(a * A[j]) == null) {
						pq.offer(a * A[j]);
						hm.put(a * A[j], 1);
						if (max < a * A[j])
							max = a * A[j];
					}
				}
			}

			System.out.println(pq.peek());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
