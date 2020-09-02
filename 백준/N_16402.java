//백준 16402번 제국
//union 이용

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class N_16402 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 왕국의 수
			int M = Integer.parseInt(input[1]); // 전쟁의 수

			int[] parent = new int[N]; // parent[i]: i왕국의 종주국
			for (int i = 0; i < parent.length; i++)
				parent[i] = i;

			HashMap<String, Integer> map = new HashMap<String, Integer>(); // 왕국이름과 번호 일대일 매칭
			HashMap<Integer, String> map1 = new HashMap<Integer, String>(); // 번호와 왕국이름 매핑

			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().split(" ");
				map.put(arr[2], i);
				map1.put(i, arr[2]);
			}
			for (int i = 0; i < M; i++) {
				String[] arr = br.readLine().split(" |,");
				int parent1 = parent[map.get(arr[2])];
				int parent2 = parent[map.get(arr[5])];

				if (parent1 == parent2) {
					if (arr[6].equals("1") && parent1 != map.get(arr[2])) { // 자식이 이기는 경우
						for (int j = 0; j < parent.length; j++) {
							if (parent[j] == parent1) {
								parent[j] = map.get(arr[2]);
							}
						}
					} else if (arr[6].equals("2") && parent2 != map.get(arr[5])) {
						for (int j = 0; j < parent.length; j++) {
							if (parent[j] == parent2) {
								parent[j] = map.get(arr[5]);
							}
						}
					}

					continue;
				}
				if (arr[6].equals("1")) { // 앞 사람이 이김
					for (int j = 0; j < parent.length; j++) {
						if (parent[j] == parent2) {
							parent[j] = parent1;
						}
					}
				} else if (arr[6].equals("2")) { // 뒷 사람이 이김
					for (int j = 0; j < parent.length; j++) {
						if (parent[j] == parent1) {
							parent[j] = parent2;
						}
					}
				}
			}

			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < parent.length; i++) {
				if (parent[i] == i)
					list.add(map1.get(i));
			}
			Collections.sort(list);

			System.out.println(list.size());
			for (String a : list) {
				System.out.println("Kingdom of " + a);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
