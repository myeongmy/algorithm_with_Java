package 코딩테스트;

//브루트 포스 + 문자열 처리
import java.util.*;

public class KakaoIntern2020_2 {
	static LinkedList<String> stringParsed;
	static ArrayList<String> operator = new ArrayList<String>(); // 수식에 사용된 연산자 저장
	static int[] c = new int[3]; // 사용 여부
	static StringBuilder sb = new StringBuilder(); // 연산자 우선순위대로 저장
	static long max = Long.MIN_VALUE;

	static void go(int index) {
		if (index >= operator.size()) {
			LinkedList<String> tokens = new LinkedList<String>(stringParsed); // 복사해서 지역변수를 사용해야함

			for (int i = 0; i < sb.length(); i++) { // 연산자 순서
				for (int j = 0; j < tokens.size(); j++) {
					if (tokens.get(j).equals(Character.toString(sb.charAt(i)))) {
						long result = 0;
						if (sb.charAt(i) == '+') {
							result = Long.parseLong(tokens.get(j - 1)) + Long.parseLong(tokens.get(j + 1));
						} else if (sb.charAt(i) == '-') {
							result = Long.parseLong(tokens.get(j - 1)) - Long.parseLong(tokens.get(j + 1));
						} else if (sb.charAt(i) == '*') {
							result = Long.parseLong(tokens.get(j - 1)) * Long.parseLong(tokens.get(j + 1));
						}
						tokens.remove(j + 1);
						tokens.remove(j);
						tokens.remove(j - 1);
						tokens.add(j - 1, Long.toString(result));
						j--;
					}
				}
			}
			
			if (max < Math.abs(Long.parseLong(tokens.get(0))))
				max = Math.abs(Long.parseLong(tokens.get(0)));

			return;
		}
		for (int i = 0; i < operator.size(); i++) {
			if (c[i] == 1)
				continue;
			c[i] = 1;
			sb.append(operator.get(i));
			go(index + 1);
			sb.deleteCharAt(sb.length() - 1);
			c[i] = 0;
		}
	}

	public long solution(String expression) {
		StringTokenizer st = new StringTokenizer(expression, "\\+|\\*|-", true);
		stringParsed = new LinkedList<String>();

		// 토큰들 배열에 넣기(문자열을 배열 형태로 변환)
		int idx = 0;
		while (st.hasMoreTokens()) {
			stringParsed.add(st.nextToken());
			if (stringParsed.get(idx).equals("+") || stringParsed.get(idx).equals("-")
					|| stringParsed.get(idx).equals("*")) {
				if (operator.indexOf(stringParsed.get(idx)) == -1)
					operator.add(stringParsed.get(idx));
			}
			idx++;
		}
		go(0);

		return max;
	}

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(new KakaoIntern2020_2().solution(expression));
	}
}
