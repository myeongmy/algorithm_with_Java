//BFS 문제
package 프로그래머스;

import java.util.*;

class Status {
	String a;
	int cnt;

	Status(String a, int cnt) {
		this.a = a;
		this.cnt = cnt;
	}
}

class Solution3 {
	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		int[] c = new int[words.length];
		Queue<Status> q = new LinkedList<Status>();
		q.offer(new Status(begin, 0));
		while (!q.isEmpty()) {
			Status s = q.poll();
			if (s.a.equals(target)) {
				answer = s.cnt;
				break;
			}
			for (int i = 0; i < words.length; i++) {
				if (c[i] == 0 && s.a.length() == words[i].length()) {
					int diff = 0;
					for (int j = 0; j < s.a.length(); j++) {
						if (s.a.charAt(j) != words[i].charAt(j))
							diff++;
					}
					if (diff == 1) {
						c[i] = 1;
						q.offer(new Status(words[i], s.cnt + 1));
					}
				}
			}
		}
		return answer;
	}
}

public class WordConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(new Solution3().solution("hit", "cog", words));
	}

}
