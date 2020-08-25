//백준 10552번 DOM
//시뮬레이션

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class N_10552 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 노인 수
			int M = Integer.parseInt(input[1]); // 채널 수
			int currentChannel = Integer.parseInt(input[2]);

			HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>(); // (key, value) == (싫어하는 채널 번호, [해당채널싫어하는노인번호])
			int[] favorite = new int[N + 1]; // idx: 노인번호(해당 노인이 가장 좋아하는 채널 저장)

			for (int i = 1; i <= N; i++) {
				String[] arr = br.readLine().split(" ");
				int love = Integer.parseInt(arr[0]);
				int hate = Integer.parseInt(arr[1]);

				if (hm.get(hate) == null)
					hm.put(hate, new ArrayList<Integer>());
				hm.get(hate).add(i);
				favorite[i] = love;
			}

			int changeNum = 0;
			while (hm.get(currentChannel) != null) {
				if (changeNum >= M) {
					System.out.println(-1);
					System.exit(0);
				}
				currentChannel = favorite[hm.get(currentChannel).get(0)];
				changeNum++;
			}

			System.out.println(changeNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
