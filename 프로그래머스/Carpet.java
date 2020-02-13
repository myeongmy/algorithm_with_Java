//브루트 포스 문제(그냥 다 해보기)
package 프로그래머스;

class Solution6 {
	public int[] solution(int brown, int red) {
		int[] answer = new int[2];
		for (int i = 1; i <= red; i++) {
			if (red % i == 0) {
				int red_x = i;
				int red_y = red / red_x;
				if (brown == (red_x + red_y) * 2 + 4 && red_x + 2 >= red_y + 2) {
					answer[0] = red_x + 2;
					answer[1] = red_y + 2;
				}
			}
		}
		return answer;
	}
}

public class Carpet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new Solution6().solution(10, 2);
		System.out.println(arr[0] + " " + arr[1]);

	}

}
