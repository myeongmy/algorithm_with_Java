//백준 2294번 동전 2
//dp

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2294 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]); // 동전 종류 갯수
			int k = Integer.parseInt(input[1]);

			int[] coin = new int[n];
			for (int i = 0; i < n; i++) {
				coin[i] = Integer.parseInt(br.readLine());
			}

			long[] d = new long[100001]; // d[i] : i원을 만드는 데 필요한 동전의 최소 갯수
			for (int i = 0; i < d.length; i++)
				d[i] = Long.MAX_VALUE;

			d[0] = 0;
			for (int i = 0; i < n; i++)
				d[coin[i]] = 1;

			for (int i = 1; i < d.length; i++) {
				for (int j = 0; j < coin.length; j++) {
					if (i - coin[j] >= 0 && d[i-coin[j]] != Long.MAX_VALUE)
						d[i] = Math.min(d[i], d[i - coin[j]] + 1);
				}
			}
			if (d[k] == Long.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(d[k]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
