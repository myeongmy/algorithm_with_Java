//백준 14425번 문자열 집합
//문자열 처리

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_14425 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < N; i++) {
				list.add(br.readLine());
			}

			int result = 0;
			for (int i = 0; i < M; i++) {
				String str = br.readLine();

				if (list.contains(str))
					result++;
			}

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
