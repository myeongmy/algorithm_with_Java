package leetcode;

public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		// 대문자 갯수와 소문자 갯수 세기
		int upperNum = 0;
		int lowerNum = 0;
		int upperIdx = -1;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				upperNum++;
				upperIdx = i;
			} else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				lowerNum++;
			}
		}

		// 1번 경우에 해당하면
		if (word.length() == upperNum) {
			return true;
		} else if (word.length() == lowerNum) { // 2번 경우에 해당하면
			return true;
		} else if (upperNum == 1 && upperIdx == 0) { // 3번 경우에 해당하면
			return true;
		} else {
			return false;
		}
	}
}
