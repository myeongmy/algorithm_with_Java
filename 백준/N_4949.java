//백준 4949번 균형잡힌 세상
//스택

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_4949 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Label: while (true) {
				String str = br.readLine();
				if (str.equals("."))
					break;

				Stack<Integer> st = new Stack<Integer>(); // 0: 소괄호, 1: 대괄호
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						st.push(0);
					} else if (str.charAt(i) == ')') {
						if (st.empty() || st.peek() == 1) {
							System.out.println("no");
							continue Label;
						}
						st.pop();
					} else if (str.charAt(i) == '[') {
						st.push(1);
					} else if (str.charAt(i) == ']') {
						if (st.empty() || st.peek() == 0) {
							System.out.println("no");
							continue Label;
						}
						st.pop();
					}
				}
				if(st.empty())
					System.out.println("yes");
				else
					System.out.println("no");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
