package 프로그래머스;

class Solution18 {
	static StringBuilder sb = new StringBuilder();

	static void ternary(int n) {
		if (n == 0)
			return;
		if (n % 3 == 0)
			ternary(n / 3 - 1);
		else
			ternary(n / 3);
		if (n % 3 == 0)
			sb.append(4);
		else
			sb.append(n % 3);
	}

	public String solution(int n) {
		String answer = "";
		ternary(n);
		answer = sb.toString();
		return answer;
	}
}

public class Number124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		System.out.println(new Solution18().solution(n));
	}

}
