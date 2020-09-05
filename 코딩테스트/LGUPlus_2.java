package 코딩테스트;

//정렬 문제
import java.util.*;

class Solution {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];

		// map 생성
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		for (int i = 0; i < numbers.length; i++) {
			String str = Integer.toString(numbers[i]);
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '0') {
					sb.append("zero");
				} else if (str.charAt(j) == '1') {
					sb.append("one");
				} else if (str.charAt(j) == '2') {
					sb.append("two");
				} else if (str.charAt(j) == '3') {
					sb.append("three");
				} else if (str.charAt(j) == '4') {
					sb.append("four");
				} else if (str.charAt(j) == '5') {
					sb.append("five");
				} else if (str.charAt(j) == '6') {
					sb.append("six");
				} else if (str.charAt(j) == '7') {
					sb.append("seven");
				} else if (str.charAt(j) == '8') {
					sb.append("eight");
				} else if (str.charAt(j) == '9') {
					sb.append("nine");
				}
			}
			hm.put(numbers[i], sb.toString());
		}

		Integer[] numbers2 = new Integer[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			numbers2[i] = numbers[i];

		Arrays.sort(numbers2, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (hm.get(a).compareTo(hm.get(b)) < 0)
					return -1;
				else if (hm.get(a).compareTo(hm.get(b)) > 0)
					return 1;
				else
					return 0;
			}
		});

		for (int i = 0; i < numbers2.length; i++)
			answer[i] = numbers2[i];
		return answer;
	}
}
