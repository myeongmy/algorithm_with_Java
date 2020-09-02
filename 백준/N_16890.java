//백준 16890번 창업
//우선순위 큐를 이용한 시뮬레이션 문제(그리디)

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_16890 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			PriorityQueue<Character> ku = new PriorityQueue<Character>();
			PriorityQueue<Character> cube = new PriorityQueue<Character>(Collections.reverseOrder());

			String kusagwa = br.readLine();
			String cubelover = br.readLine();

			for (int i = 0; i < kusagwa.length(); i++) {
				ku.offer(kusagwa.charAt(i));
			}
			for (int i = 0; i < cubelover.length(); i++) {
				cube.offer(cubelover.charAt(i));
			}

			StringBuilder result = new StringBuilder();
			int flag = 0;

			while (result.length() != kusagwa.length()) {
				if (flag == 0) {
					result.append(ku.poll());
					flag = 1;
				} else if (flag == 1) {
					result.append(cube.poll());
					flag = 0;
				}
			}

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
