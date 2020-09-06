//백준 11720번 숫자의 합
//문자열 처리

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			long sum = 0;
			for (int i = 0; i < str.length(); i++)
				sum += (str.charAt(i) - 48);

			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
