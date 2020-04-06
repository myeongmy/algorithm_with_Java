package 코딩테스트;

//해시
import java.util.*;

class Solution7 {
	public String[] solution(String[][] dataSource, String[] tags) {
		HashMap<String, LinkedList<String>> mapping = new HashMap<String, LinkedList<String>>();
		for (int i = 0; i < dataSource.length; i++) {
			String doc = dataSource[i][0];
			for (int j = 1; j < dataSource[i].length; j++) {
				LinkedList<String> list = mapping.get(dataSource[i][j]);
				if (list == null) {
					list = new LinkedList<String>();
					mapping.put(dataSource[i][j], list);
				}
				list.add(doc);
			}
		}
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < tags.length; i++) {
			LinkedList<String> list = mapping.get(tags[i]);
			if (list == null)
				continue;

			for (int j = 0; j < list.size(); j++) {
				hm.put(list.get(j), hm.getOrDefault(list.get(j), 0) + 1);
			}
		}

		List<String> keySetList = new ArrayList<>(hm.keySet());
		Collections.sort(keySetList, new Comparator<String>() {
			public int compare(String a, String b) {
				if (hm.get(a) > hm.get(b))
					return -1;
				else if (hm.get(a) < hm.get(b))
					return 1;
				else {
					return a.compareTo(b);
				}
			}
		});
		String[] answer = new String[keySetList.size()];
		int idx = 0;
		for (String key : keySetList) {
			answer[idx] = key;
			idx++;
		}

		return answer;
	}
}

public class LINE_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };

		String[] tags = { "t1", "t2", "t3" };

		String[] answer = new Solution7().solution(dataSource, tags);

		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
