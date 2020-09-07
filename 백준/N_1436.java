//백준 1436번 영화감독 숌
//브루트 포스 + 우선순위 큐

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class N_1436 {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			pq.offer((long) 666);
			long max = Long.MIN_VALUE;
			HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // 중복되는 수 제거 위함
			map.put((long)666, 1);

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N - 1; i++) {
				long a = pq.poll();
				String converted = Long.toString(a);
				// 앞에 추가
				for (int j = 0; j <= 9; j++) {
					String str = j + converted;
					if (pq.size() > N && max < Long.parseLong(str))
						continue;
					if (map.get(Long.parseLong(str)) != null)
						continue;

					pq.offer(Long.parseLong(str));
					map.put(Long.parseLong(str), 1);

					if (max < Long.parseLong(str))
						max = Long.parseLong(str);
				}
				
				for (int j = 0; j <= 9; j++) {
					String str = j + converted;
					if (pq.size() > N && max < Long.parseLong(str))
						continue;
					if (map.get(Long.parseLong(str)) != null)
						continue;

					pq.offer(Long.parseLong(str));
					map.put(Long.parseLong(str), 1);

					if (max < Long.parseLong(str))
						max = Long.parseLong(str);
				}
				// 뒤에 추가
				for (int j = 0; j <= 9; j++) {
					String str = converted + j;
					if (pq.size() > N && max < Long.parseLong(str))
						continue;
					if (map.get(Long.parseLong(str)) != null)
						continue;

					pq.offer(Long.parseLong(str));
					map.put(Long.parseLong(str), 1);

					if (max < Long.parseLong(str))
						max = Long.parseLong(str);
				}
			}

			System.out.println(pq.poll());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String [] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			for(long i=1;;i++) {
				String str = Long.toString(i);
				if(str.indexOf("666") != -1)
					cnt++;
				
				if(cnt == N) {
					System.out.println(str);
					break;
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
