//백준 11399번 ATM
//정렬하기

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class N_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

			for (int i = 0; i < N; i++)
				pq.offer(Integer.parseInt(arr[i]));

			int result = 0;
			List<Integer> list = new ArrayList<Integer>();
			while (!pq.isEmpty()) {
				result += pq.poll();
				list.add(result);
			}

			int total = 0;
			for (int i = 0; i < list.size(); i++)
				total += list.get(i);

			System.out.println(total);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
