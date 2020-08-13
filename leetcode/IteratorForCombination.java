package leetcode;

import java.util.*;

//브루트포스 구현
class CombinationIterator {
	static List<String> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static int index = 0;

	static void go(int idx, int selected, String characters, int combinationLength) {
		if (selected == combinationLength) {
			list.add(sb.toString());
			return;
		}
		if (idx >= characters.length())
			return;

		sb.append(characters.charAt(idx));
		go(idx + 1, selected + 1, characters, combinationLength);
		sb.deleteCharAt(sb.length() - 1);

		go(idx + 1, selected, characters, combinationLength);
	}

	public CombinationIterator(String characters, int combinationLength) {
		list.clear(); // 초기화가 중요하다.
		index = 0;
		go(0, 0, characters, combinationLength);
	}

	public String next() {
		index++;
		return list.get(index - 1);
	}

	public boolean hasNext() {
		if (index < list.size())
			return true;
		else
			return false;
	}
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters,
 * combinationLength); String param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
