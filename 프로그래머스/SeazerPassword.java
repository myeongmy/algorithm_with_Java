package codingtest_study.프로그래머스;

class SeazerPassword {
	public String solution(String s, int n) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				int a = s.charAt(i) + n;
				if (a > 90)           // Z 다음에  A가 나오기 위함
					a = a - 26;
				answer = answer.concat(Character.toString((char) a));
			} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				int a = s.charAt(i) + n;
				if (a > 122)
					a = a - 26;
				answer = answer.concat(Character.toString((char) a));
			} else
				answer = answer.concat(Character.toString(s.charAt(i)));
		}
		return answer;
	}
}
