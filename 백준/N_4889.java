//백준 4889번 안정적인 문자열
//문자열 처리

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_4889 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = 0;
			while (true) {
				t++;
				String sentence = br.readLine();
				if (sentence.charAt(0) == '-')
					break;

				Stack<Integer> st = new Stack<Integer>();
				int oper = 0;

				for (int i = 0; i < sentence.length(); i++) {
					if (sentence.charAt(i) == '{')
						st.push(i);
					else {
						if (st.empty()) {
							oper++;
							st.push(i);
						} else
							st.pop();
					}
				}
				oper += (st.size() / 2);

				System.out.println(t + ". " + oper);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
