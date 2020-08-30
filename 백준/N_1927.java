package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1927 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			for(int i=0;i<N;i++) {
				int input = Integer.parseInt(br.readLine());
				
				if(input == 0) {
					if(pq.size() == 0) {
						System.out.println(0);
						continue;
					}
					System.out.println(pq.poll());
				}else {
					pq.offer(input);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
