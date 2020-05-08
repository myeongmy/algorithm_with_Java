package 프로그래머스;

//브루트 포스 -> 범위 커서 불가
//투 포인터, 이분 탐색, dp, 그리디 -> 그리디!

class Solution27 {
	public String solution(String number, int k) {
		String answer = "";

		StringBuilder sb = new StringBuilder(number);

		/*
		 * 틀린 풀이 while(k > 0){ //최소값과 최소값의 위치 찾기 int min = Integer.MAX_VALUE; int min_i
		 * = -1;
		 * 
		 * for(int i=0;i<sb.length();i++){ if(min > sb.charAt(i) - 48){ min =
		 * sb.charAt(i) - 48; min_i = i; } } sb.deleteCharAt(min_i);
		 * 
		 * k--; } answer = sb.toString();
		 */

		int num = 0; // 삭제한 것 개수
		int index = 0;
		while (num != k && index < sb.length() - 1) {
			if (sb.charAt(index) < sb.charAt(index + 1)) {
				sb.deleteCharAt(index);
				index = 0;
				num++;
				continue;
			}
			index++;
		}

		if (num != k)
			sb.delete(sb.length() - k, sb.length());

		answer = sb.toString();
		return answer;
	}
}

public class MakingBigNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1924";
		int k = 2;
		System.out.println(new Solution27().solution(number, k));
	}

}
