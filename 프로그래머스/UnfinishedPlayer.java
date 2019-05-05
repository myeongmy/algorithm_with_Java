package codingtest_study.프로그래머스;

// HashMap  (java.util package)
// map.put(,); map.get(key); map.getOrDefault(key,0); map.keySet();
import java.util.HashMap;

class UnfinishedPlayer {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < participant.length; i++) {
			map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
		}
		for (int i = 0; i < completion.length; i++) {
			map.put(completion[i], map.get(completion[i]) - 1);
		}
		for (String a : map.keySet()) {
			if (map.get(a) == 1)
				answer = a;
		}
		return answer;
	}
}