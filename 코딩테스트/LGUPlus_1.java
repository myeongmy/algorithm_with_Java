package 코딩테스트;

import java.util.*;

class Solution {
	public String solution(int n, String text, int second) {
		String answer = "";

		HashMap<Integer, String> hm = new HashMap<Integer, String>(); // (시간, 문자열)
		StringBuilder sb = new StringBuilder();
		int time = 0;
		int idx = 0;
		while (time <= text.length() * 2) {
			if (time == 0) {
				hm.put(0, sb.toString());
				time++;
				continue;
			}
			// 삽입
			if (time <= text.length()) {
				sb.append(text.charAt(idx));
				idx++;
				hm.put(time, sb.toString());
			}
			// 삭제
			if (time > text.length()) {
				sb.deleteCharAt(0);
				hm.put(time, sb.toString());
			}
			time++;
		}
		int sec = second % (text.length() * 2);
		StringBuilder answer2 = new StringBuilder(hm.get(sec));
		if (answer2.length() < text.length() && sec < text.length()) {
			int len = answer2.length();
			for (int i = 0; i < text.length() - len; i++) {
				answer2.insert(0, '_');
			}
		} else if (answer2.length() < text.length() && sec > text.length()) {
			int len = answer2.length();
			for (int i = 0; i < text.length() - len; i++)
				answer2.append("_");
		}

		for (int i = 0; i < answer2.length(); i++) {
			if (answer2.charAt(i) == ' ')
				answer += '_';
			else
				answer += answer2.charAt(i);
		}
		return answer;
	}
}
