//백준 1766번 문제집
//우선순위 큐

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class N_1766 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			int[] A = new int[N + 1]; // 진입 차수 저장하는 배열
			ArrayList<Integer> [] adlist = (ArrayList<Integer> [])new ArrayList[N+1]; // (key -> value)
			for(int i=1;i<=N;i++)
				adlist[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < M; i++) {
				String[] arr = br.readLine().split(" ");
				adlist[Integer.parseInt(arr[0])].add(Integer.parseInt(arr[1]));
				A[Integer.parseInt(arr[1])]++;
			}

			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // 번호가 작은 순서대로 출력
			// 진입 차수 0인 것 넣기
			for (int i = 1; i <= N; i++) {
				if (A[i] == 0)
					pq.offer(i);
			}

			// 위상 정렬
			while (!pq.isEmpty()) {
				int num = pq.poll();
				System.out.print(num + " ");
				
				for(int a : adlist[num]) {
					A[a] --;
					
					if (A[a] == 0)
					pq.offer(a);
				}

				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
