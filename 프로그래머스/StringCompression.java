package 프로그래머스;

//문자열 처리
import java.util.*;

class Solution23 {
	public int solution(String s) {
		int answer = 2000;

		for (int i = 1; i <= s.length(); i++) { // s 길이의 약수만 자르는 단위가 될 수 있다.

			StringBuilder sb = new StringBuilder();
			String[] arr;
			if (s.length() % i == 0)
				arr = new String[s.length() / i];
			else
				arr = new String[s.length() / i + 1];
			int temp = i;

			for (int j = 0; j < arr.length; j++) {
				if (temp <= s.length())
					arr[j] = s.substring(temp - i, temp);
				else
					arr[j] = s.substring(temp - i);
				temp += i;
			}

			Stack<String> st = new Stack<String>();
			st.push(arr[0]);
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].equals(arr[j - 1])) {
					st.push(arr[j]);
				} else {
					if (st.size() != 1)
						sb.append(st.size());
					sb.append(arr[j - 1]);
					st.clear();
					st.push(arr[j]);
				}
			}

			if (!st.empty()) {
				if (st.size() != 1)
					sb.append(st.size());
				sb.append(arr[arr.length - 1]);
			}
			if (answer > sb.length())
				answer = sb.length();

		}
		return answer;
	}
}

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaccc";
		System.out.println(new Solution23().solution(s));
	}

}
