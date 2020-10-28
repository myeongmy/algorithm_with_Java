//백준 1764번 듣보잡
//문자열 탐색

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class N_1764 {
	static class TrieNode {
		char ch;
		TrieNode[] next = new TrieNode[26];
		boolean isEnd;

		TrieNode(char ch) {
			this.ch = ch;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			TrieNode root = new TrieNode(' ');

			// 트라이 알고리즘
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				TrieNode temp = root;

				for (int j = 0; j < str.length(); j++) {
					if (temp.next[str.charAt(j) - 97] == null) {
						temp.next[str.charAt(j) - 97] = new TrieNode((char) (str.charAt(j) - 97));
					}

					temp = temp.next[str.charAt(j) - 97];
				}

				temp.isEnd = true;
			}

			ArrayList<String> result = new ArrayList<String>();

			Label: for (int i = 0; i < M; i++) {
				String str = br.readLine();
				TrieNode temp = root;

				for (int j = 0; j < str.length(); j++) {
					if (temp.next[str.charAt(j) - 97] == null)
						continue Label;
					else
						temp = temp.next[str.charAt(j) - 97];
				}

				result.add(str);
			}

			Collections.sort(result);
			System.out.println(result.size());
			for (int i = 0; i < result.size(); i++)
				System.out.println(result.get(i));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
