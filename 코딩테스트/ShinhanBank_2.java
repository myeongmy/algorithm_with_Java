//2번 - 정렬 문제
//정렬의 기준을 세워서 정렬해야하는 문제

package 코딩테스트;

import java.util.*;

class House {
	int index; // 신청순서 저장
	int region;
	int score;

	House(int index, int region, int score) {
		this.index = index;
		this.region = region;
		this.score = score;
	}
}

class Solution14 {
	public int[] solution(int region, int num, int[][] info) {
		int[] answer = new int[info.length];
		for (int i = 0; i < answer.length; i++)
			answer[i] = -1;

		ArrayList<House> listsame = new ArrayList<House>(); // 동일 지역 거주 사람들
		ArrayList<House> listdiff = new ArrayList<House>(); // 그 외 지역 거주 사람들

		for (int i = 0; i < info.length; i++) {
			int score = (info[i][1] + 1) * 2 + (info[i][2] + 2) + (info[i][3] + 1) * 5;
			if (info[i][0] == region) {
				listsame.add(new House(i, info[i][0], score));
			} else {
				listdiff.add(new House(i, info[i][0], score));
			}
		}

		Collections.sort(listsame, new Comparator<House>() {
			public int compare(House h1, House h2) {
				if (h1.score > h2.score) {
					return -1;
				} else if (h1.score < h2.score) {
					return 1;
				} else {
					if (h1.index < h2.index) {
						return -1;
					} else if (h1.index > h2.index) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});

		int rank = 1;
		for (int i = 0; i < listsame.size(); i++) {
			if (rank > num)
				break;
			answer[listsame.get(i).index] = rank;
			rank++;
		}

		Collections.sort(listdiff, new Comparator<House>() {
			public int compare(House h1, House h2) {
				if (h1.score > h2.score) {
					return -1;
				} else if (h1.score < h2.score) {
					return 1;
				} else {
					if (h1.index < h2.index) {
						return -1;
					} else if (h1.index > h2.index) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});

		for (int i = 0; i < listdiff.size(); i++) {
			if (rank > num)
				break;
			answer[listdiff.get(i).index] = rank;
			rank++;
		}
		return answer;
	}
}

public class ShinhanBank_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int region = 2;
		int num = 1;
		int[][] info = { { 3, 4, 4, 4 }, { 1, 1, 1, 1 } };
		int[] answer = new Solution14().solution(region, num, info);

		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
