//백준 2696번 중앙값 구하기
//우선순위 큐 이용

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_2696 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int t = 0; t < T; t++) {
				int N = Integer.parseInt(br.readLine());
				int[] A = new int[N]; // 수열 저장
				int cnt = 0;

				for (int i = 0; i < N / 10 + 1; i++) {
					String[] arr = br.readLine().split(" ");
					for (int j = 0; j < arr.length; j++) {
						A[cnt] = Integer.parseInt(arr[j]);
						cnt++;
					}
				}

				ArrayList<Integer> result = new ArrayList<Integer>();
				PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
				PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();

				for (int i = 0; i < A.length; i++) {
					if (maxheap.size() == minheap.size())
						maxheap.offer(A[i]);
					else if (maxheap.size() > minheap.size())
						minheap.offer(A[i]);

					if (!maxheap.isEmpty() && !minheap.isEmpty() && minheap.peek() < maxheap.peek()) {
						int max = maxheap.poll();
						int min = minheap.poll();

						minheap.offer(max);
						maxheap.offer(min);
					}

					if (i % 2 == 0) {
						result.add(maxheap.peek());
					}
				}
				System.out.println(result.size());
				for (int i = 0; i < result.size(); i++) {
					System.out.print(result.get(i) + " ");
					if (i % 10 == 9)
						System.out.println();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
