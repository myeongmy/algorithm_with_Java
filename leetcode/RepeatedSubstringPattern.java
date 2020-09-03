package leetcode;

class Solution {
	public boolean repeatedSubstringPattern(String s) {

		Label: for (int i = 1; i < s.length(); i++) {
			String str = s.substring(0, 0 + i);
			int cnt = 0;

			for (int j = i; j + i <= s.length(); j += i) {
				if (str.equals(s.substring(j, j + i)))
					cnt++;
				else
					continue Label;
			}
			if (i == 3)
				System.out.println(cnt);
			if (i * cnt + i == s.length())
				return true;
		}
		return false;
	}
}
