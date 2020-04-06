
package 코딩테스트;

//해시
import java.util.*;

class Solution6 {
	public String[][] solution(String[][] snapshots, String[][] transactions) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// snapshots 내용 저장
		for (int i = 0; i < snapshots.length; i++) {
			hm.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}

		int[] freq = new int[100000]; // 중복 제거 위함
		for (int i = 0; i < transactions.length; i++) {
			freq[Integer.parseInt(transactions[i][0])]++;
			if (freq[Integer.parseInt(transactions[i][0])] >= 2)
				continue;

			if (transactions[i][1].equals("SAVE")) {
				hm.put(transactions[i][2],
						hm.getOrDefault(transactions[i][2], 0) + Integer.parseInt(transactions[i][3]));
			} else if (transactions[i][1].equals("WITHDRAW")) {
				hm.put(transactions[i][2],
						hm.getOrDefault(transactions[i][2], 0) - Integer.parseInt(transactions[i][3]));
			}
		}

		Set<String> s = hm.keySet();
		String[][] answer = new String[s.size()][2];
		Iterator<String> it = s.iterator();
		int idx = 0;
		while (it.hasNext()) {
			String str = it.next();
			answer[idx][0] = str;
			answer[idx][1] = Integer.toString(hm.get(str));
			idx++;
		}

		// 정렬
		Arrays.sort(answer, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return s1[0].compareTo(s2[0]);
			}
		});
		return answer;
	}
}

public class LINE_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };

		String[][] answer = new Solution6().solution(snapshots, transactions);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i][0] + " " + answer[i][1]);

		}
	}

}
