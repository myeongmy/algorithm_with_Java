//백준 14594번 동방 프로젝트(small)
//유니온 파인드

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_14594 {
	static int[] parent;

	static int find(int v) { // 최상위 부모 찾기
		if (v == parent[v])
			return v;
		return find(parent[v]);
	}

	static void union(int v, int v1) {
		int parent1 = find(v);
		int parent2 = find(v1);

		if (parent1 < parent2)
			parent[parent2] = parent1;
		else
			parent[parent1] = parent2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;

			for (int i = 0; i < M; i++) {
				String[] arr = br.readLine().split(" ");
				int x = Integer.parseInt(arr[0]);
				int y = Integer.parseInt(arr[1]);

				int cur = x;
				while (cur + 1 <= y) {
					int parent1 = find(cur);
					int parent2 = find(cur + 1);

					if (parent1 != parent2) {
						union(cur, cur + 1);
					}
					cur++;
				}
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (parent[i] == i)
					cnt++;
			}
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
