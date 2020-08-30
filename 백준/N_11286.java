package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_11286 {
	static class Absolute implements Comparable<Absolute> {
		int num;

		Absolute(int num) {
			this.num = num;
		}

		public int compareTo(Absolute a) {
			if (Math.abs(this.num) < Math.abs(a.num))
				return -1;
			else if (Math.abs(this.num) > Math.abs(a.num))
				return 1;
			else {
				if (this.num < a.num)
					return -1;
				else if (this.num > a.num)
					return 1;
				else
					return 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Absolute> pq = new PriorityQueue<Absolute>();

			for (int i = 0; i < N; i++) {
				int input = Integer.parseInt(br.readLine());

				if (input == 0) {
					if (pq.size() == 0) {
						System.out.println(0);
						continue;
					}
					System.out.println(pq.poll().num);
				} else {
					pq.offer(new Absolute(input));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
