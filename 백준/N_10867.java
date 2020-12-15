package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class N_10867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(arr[i]);

				hm.put(a, hm.getOrDefault(a, 0) + 1);
			}

			List<Integer> list = new ArrayList<Integer>(hm.keySet());
			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
