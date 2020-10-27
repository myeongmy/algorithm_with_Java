//백준 1541번 잃어버린 괄호
//브루트 포스 + 문자열 처리

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), "\\+|-", true);
			ArrayList<Integer> operand = new ArrayList<Integer>();
			ArrayList<String> operator = new ArrayList<String>();

			while (st.hasMoreTokens()) {
				String str = st.nextToken();

				if (str.equals("+") || str.equals("-"))
					operator.add(str);
				else
					operand.add(Integer.parseInt(str));
			}

			for (int i = 0; i < operator.size(); i++) {
				if (operator.get(i).equals("-")) {
					i++;
					while (i < operator.size() && operator.get(i).equals("+")) {
						operator.set(i, "-");
						i++;
					}
					i--;
				}
			}

			int result = operand.get(0);

			for (int i = 0; i < operator.size(); i++) {
				if (operator.get(i).equals("+")) {
					result += operand.get(i + 1);
				} else if (operator.get(i).equals("-")) {
					result -= operand.get(i + 1);
				}
			}

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
