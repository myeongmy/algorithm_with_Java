package 프로그래머스;

//문자열 처리

class Solution16 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		int[] freq = new int[26];
		for (int i = 0; i < skill.length(); i++) {
			freq[skill.charAt(i) - 65]++;
		}

		Label: for (int i = 0; i < skill_trees.length; i++) {
			int skill_pointer = 0;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				if (freq[skill_trees[i].charAt(j) - 65] == 0) {
					continue;
				} else {
					if (skill.charAt(skill_pointer) != skill_trees[i].charAt(j)) {
						continue Label;
					} else { // 같으면
						skill_pointer++;
					}
				}
			}
			answer++;
		}
		return answer;
	}
}

public class SkillTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		System.out.println(new Solution16().solution(skill, skill_trees));
	}

}
