//백준 5052번 전화번호 목록
//trie 알고리즘

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class N_5052 {
	static class TrieNode {
		char num;
		TrieNode[] next = new TrieNode[10];
		boolean isEnd;

		TrieNode(char num) {
			this.num = num;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			Label: for (int t = 0; t < T; t++) {
				int N = Integer.parseInt(br.readLine());
				TrieNode root = new TrieNode(' ');

				ArrayList<String> list = new ArrayList<String>();
				for (int i = 0; i < N; i++) {
					list.add(br.readLine());
				}

				Collections.sort(list, new Comparator<String>() {
					public int compare(String a, String b) {
						if (a.length() < b.length())
							return -1;
						else if (a.length() > b.length())
							return 1;
						else
							return 0;
					}
				});
				for (int i = 0; i < N; i++) {
					String str = list.get(i);
					TrieNode temp = root;

					// trie 트리 구조에 삽입
					for (int j = 0; j < str.length(); j++) {
						if (temp.next[str.charAt(j) - 48] == null) {
							temp.next[str.charAt(j) - 48] = new TrieNode((char) (str.charAt(j) - 48));
						}

						temp = temp.next[str.charAt(j) - 48];
						if (temp.isEnd == true) {
							System.out.println("NO");
							continue Label;
						}
					}

					temp.isEnd = true;
				}

				System.out.println("YES");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
