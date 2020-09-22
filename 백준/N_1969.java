//백준 1969번 DNA
//브루트 포스 

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class N_1969 {
	static String[] dna;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // dna의 수
		int M = Integer.parseInt(input[1]); // 문자열의 길이

		dna = new String[N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			dna[i] = str;
		}

		StringBuilder result = new StringBuilder();

		// 각 자리마다 빈도수 계산
		for (int i = 0; i < M; i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int j = 0; j < N; j++) {
				map.put(dna[j].charAt(i), map.getOrDefault(dna[j].charAt(i), 0) + 1);
			}

			List<Character> keyList = new ArrayList<>(map.keySet());
			Collections.sort(keyList, new Comparator<Character>() {
				public int compare(Character a, Character b) {
					if (map.get(a) > map.get(b))
						return -1;
					else if (map.get(a) < map.get(b))
						return 1;
					else {
						if(a < b)
							return -1;
						else if(a > b)
							return 1;
						else
							return 0;
					}
				}
			});
			result.append(keyList.get(0));
		}

		System.out.println(result);
		// 해밍 거리 구하기
		int dist = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dna[i].charAt(j) != result.charAt(j))
					dist++;
			}
		}

		System.out.println(dist);
	}

}
