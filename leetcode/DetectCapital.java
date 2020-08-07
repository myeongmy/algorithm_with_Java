package leetcode;

public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		// �빮�� ������ �ҹ��� ���� ����
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

		// 1�� ��쿡 �ش��ϸ�
		if (word.length() == upperNum) {
			return true;
		} else if (word.length() == lowerNum) { // 2�� ��쿡 �ش��ϸ�
			return true;
		} else if (upperNum == 1 && upperIdx == 0) { // 3�� ��쿡 �ش��ϸ�
			return true;
		} else {
			return false;
		}
	}
}
