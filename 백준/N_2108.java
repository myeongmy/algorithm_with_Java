//백준 2108번 통계학
//정렬

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class N_2108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			int sum = 0;

			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(br.readLine());
				sum += A[i];
				hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
			}
			// 산술평균
			double aver = sum / (double) N;
			System.out.println(Math.round(aver));

			// 중앙값
			Arrays.sort(A);
			System.out.println(A[N / 2]);

			// 최빈값
			List<Integer> keyList = new ArrayList<>(hm.keySet());
			Collections.sort(keyList, new Comparator<Integer>() {
				public int compare(Integer a, Integer b) {
					if (hm.get(a) > hm.get(b))
						return -1;
					else if (hm.get(a) < hm.get(b))
						return 1;
					else {
						if (a < b)
							return -1;
						else if (a > b)
							return 1;
						else
							return 0;
					}
				}
			});
			if (keyList.size() >= 2 && hm.get(keyList.get(0)) == hm.get(keyList.get(1)))
				System.out.println(keyList.get(1));
			else
				System.out.println(keyList.get(0));

			// 범위
			System.out.println(A[A.length - 1] - A[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
