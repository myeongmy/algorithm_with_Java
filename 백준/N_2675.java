//백준 2675번 문자열 반복
//문자열 처리

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int repeatNum = Integer.parseInt(arr[0]);
				String str = arr[1];
				StringBuilder sb = new StringBuilder();

				for (int j = 0; j < str.length(); j++) {
					for (int k = 0; k < repeatNum; k++)
						sb.append(str.charAt(j));
				}

				System.out.println(sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
