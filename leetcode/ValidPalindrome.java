package leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder backward = new StringBuilder();

		// alphanumeric character 이외의 문자 제외
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				sb.append((char) (s.charAt(i) + 32));
			} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				sb.append(s.charAt(i));
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sb.append(s.charAt(i));
			}
		}

		// 거꾸로 뒤집기
		for (int i = sb.length() - 1; i >= 0; i--) {
			backward.append(sb.charAt(i));
		}

		if (sb.toString().equals(backward.toString()))
			return true;
		else
			return false;
	}
}
