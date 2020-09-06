//백준 10773번 제로
//스택

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_10773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int K = Integer.parseInt(br.readLine());
			Stack<Integer> st = new Stack<Integer>();

			for (int i = 0; i < K; i++) {
				int N = Integer.parseInt(br.readLine());
				if (N == 0)
					st.pop();
				else
					st.push(N);
			}

			int sum = 0;
			while (!st.empty()) {
				sum += st.pop();
			}

			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
