package 코딩테스트;
//Trie 알고리즘 활용 (백준 5052번 풀어보기)

//문자열 처리
import java.util.*;

class Solution8 {
	public String[] solution(String[] directory, String[] command) {
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < directory.length; i++) {
			list.add(directory[i]);
		}

		// 명령어 수행
		for (int i = 0; i < command.length; i++) {
			if (command[i].startsWith("mkdir")) {
				String[] arr = command[i].split(" ");
				list.add(arr[1]);
			} else if (command[i].startsWith("rm")) {
				String[] arr = command[i].split(" ");
				for (int j = list.size() - 1; j >= 0; j--) {
					if (list.get(j).startsWith(arr[1]))
						list.remove(j);
				}
			} else if (command[i].startsWith("cp")) {
				String[] arr = command[i].split(" ");
				String source = arr[1];
				String dest = arr[2];

				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).startsWith(source)) {
						list.add(dest + list.get(j));
					}
				}
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).indexOf("//") != -1) {
				StringBuilder sb = new StringBuilder(list.get(i));
				int start = list.get(i).indexOf("//") + 1;
				int end = 0;
				for (int j = start + 1; j < list.get(i).length(); j++) {
					if (list.get(i).charAt(j) == '/') {
						end = j;
						break;
					}
				}
				sb.delete(start, end + 1);
				list.set(i, sb.toString());
			}
		}
		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);
		return answer;
	}
}

public class LINE_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] directory = { "/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc",
				"/root/abcd/hello" };
		String[] command = { "mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello" };

		String[] answer = new Solution8().solution(directory, command);
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);

	}

}
