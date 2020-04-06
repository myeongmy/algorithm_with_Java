package 코딩테스트;

//완전탐색

class Solution5 {
	static int[] result = new int[2];
	static int total_max = Integer.MIN_VALUE;

	static void go(int index, int selected, String[] sheets, String answer_sheet) {
		if (selected == 2) {
			StringBuilder sb = new StringBuilder();
			int num = 0; // 의심 문항 수

			for (int i = 0; i < sheets[0].length(); i++) {
				if (sheets[result[0]].charAt(i) == sheets[result[1]].charAt(i)
						&& sheets[result[0]].charAt(i) != answer_sheet.charAt(i)) { // 의심 문항인 경우
					num++;
					sb.append(1);
				} else {
					sb.append(0);
				}
			}

			// 가장 긴 연속된 1 찾기
			int cnt = 0;
			int cnt_max = Integer.MIN_VALUE;
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == '1') {
					cnt++;
				} else if (sb.charAt(i) == '0') {
					if (cnt_max < cnt)
						cnt_max = cnt;
					cnt = 0;
				}
			}
			if (cnt_max < cnt)
				cnt_max = cnt;
			if (total_max < num + cnt_max * cnt_max) {
				total_max = num + cnt_max * cnt_max;
			}
			return;
		}

		if (index >= sheets.length)
			return;

		result[selected] = index;
		go(index + 1, selected + 1, sheets, answer_sheet);
		result[selected] = 0;

		go(index + 1, selected, sheets, answer_sheet);
	}

	public int solution(String answer_sheet, String[] sheets) {
		int answer = -1;

		go(0, 0, sheets, answer_sheet);
		answer = total_max;
		return answer;
	}
}

public class LINE_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer_sheet = "4132315142";
		String[] sheets = { "3241523133", "4121314445", "3243523133", "4433325251", "2412313253" };
		System.out.println(new Solution5().solution(answer_sheet, sheets));
	}

}
