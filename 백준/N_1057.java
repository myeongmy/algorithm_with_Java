//시뮬레이션 문제

package 백준;

import java.io.*;
import java.util.*;

public class N_1057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int kim = Integer.parseInt(arr[1]);
			int lim = Integer.parseInt(arr[2]);

			int roundNum = 0;
			while (!(kim == 1 && lim == 1)) {
				roundNum++;

				// 김지민
				if (kim % 2 == 0)
					kim /= 2;
				else
					kim = kim / 2 + 1;

				// 임한수
				if (lim % 2 == 0)
					lim /= 2;
				else
					lim = lim / 2 + 1;

				if (kim == lim) {
					System.out.println(roundNum);
					System.exit(0);
				}
			}
			System.out.println(-1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
