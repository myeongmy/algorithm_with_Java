//그리디 알고리즘

package 프로그래머스;

import java.util.*;

class Solution31 {
	public int solution(int[] people, int limit) {
		int answer = 0;

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < people.length; i++)
			list.add(people[i]);
		Collections.sort(list);

		while (list.size() != 0) {
			if (list.size() == 1)
				list.remove(0);
			else {
				if (list.get(0) + list.get(list.size() - 1) > limit) {
					list.remove(list.size() - 1);
				} else {
					list.remove(list.size() - 1);
					list.remove(0);
				}
			}

			answer++;
		}
		return answer;
	}
}

public class LifeBoat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(new Solution31().solution(people, limit));
	}

}
