package leetcode;

class Solution {
	public String largestTimeFromDigits(int[] A) {
		String answer = "";

		int[] freq = new int[10];
		for (int i = 0; i < 4; i++) {
			freq[A[i]]++;
		}

		Label: for (int i = 2; i >= 0; i--) { // 첫째자리
			int[] freqCopy = freq.clone();
			String answer2 = "";

			if (freqCopy[i] != 0) {
				answer2 += Integer.toString(i);
				freqCopy[i]--;
				if (i == 2) {
					for (int j = 3; j >= 0; j--) { // 둘째자리
						if (freqCopy[j] != 0) {
							freqCopy[j]--;
							answer2 += Integer.toString(j);
							answer2 += ":";
							for (int k = 5; k >= 0; k--) {
								if (freqCopy[k] != 0) {
									freqCopy[k]--;
									answer2 += Integer.toString(k);
									for (int z = 0; z < freqCopy.length; z++) {
										if (freqCopy[z] != 0) {
											answer2 += Integer.toString(z);
											if (answer2.length() == 5) {
												answer = answer2;
												break Label;
											}
										}
									}
								}
							}
						}
					}
				} else {
					for (int j = 9; j >= 0; j--) {
						if (freqCopy[j] != 0) {
							freqCopy[j]--;
							answer2 += Integer.toString(j);
							answer2 += ":";
							for (int k = 5; k >= 0; k--) {
								if (freqCopy[k] != 0) {
									freqCopy[k]--;
									answer2 += Integer.toString(k);
									for (int z = 0; z < freqCopy.length; z++) {
										if (freqCopy[z] != 0) {
											answer2 += Integer.toString(z);
											if (answer2.length() == 5) {
												answer = answer2;
												break Label;
											}
										}
									}
								}
							}
						}
					}
				}
			}

			if (answer2.length() != 5)
				answer = "";

		}

		return answer;
	}
}
