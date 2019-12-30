//백준 1406번

/*문제
한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.

이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다. 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.

이 편집기가 지원하는 명령어는 다음과 같다.

L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
P $	$라는 문자를 커서 왼쪽에 추가함
초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오. 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.

입력
첫째 줄에는 초기에 편집기에 입력되어 있는 문자열이 주어진다. 이 문자열은 길이가 N이고, 영어 소문자로만 이루어져 있으며, 길이는 100,000을 넘지 않는다. 둘째 줄에는 입력할 명령어의 개수를 나타내는 정수 M(1 ≤ M ≤ 500,000)이 주어진다. 셋째 줄부터 M개의 줄에 걸쳐 입력할 명령어가 순서대로 주어진다. 명령어는 위의 네 가지 중 하나의 형태로만 주어진다.

출력
첫째 줄에 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 출력한다.*/

package codingtest_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_1406 {
	/*
	 * //1. 문자열을 이용한 구현 => 시간 초과(중간에 삽입,삭제 하는 연산 오래 걸림) public static void
	 * main(String[] args) { // TODO Auto-generated method stub Scanner s = new
	 * Scanner(System.in); StringBuilder sb = new StringBuilder(s.nextLine());
	 * int currentCursor = sb.length() - 1; int M = s.nextInt(); s.nextLine();
	 * for (int i = 0; i < M; i++) { String command = s.nextLine(); if
	 * (command.startsWith("P")) { String[] arr = command.split(" "); // 커서가 맨
	 * 뒤에 위치한 경우 insert를 이용하면 IndexOufOfBound에러 나기 때문에 // append이용 if
	 * (currentCursor == sb.length() - 1) sb.append(arr[1]); else
	 * sb.insert(currentCursor + 1, arr[1]); currentCursor++; } else if
	 * (command.startsWith("L")) { if (currentCursor == -1) continue;
	 * currentCursor--;
	 * 
	 * } else if (command.startsWith("D")) { if (currentCursor == sb.length() -
	 * 1) continue; currentCursor++; } else { if (currentCursor == -1) continue;
	 * sb.delete(currentCursor, currentCursor + 1); currentCursor--; } }
	 * System.out.println(sb.toString()); }
	 */

	/*
	 * // 2. 링크드 리스트를 이용한 구현 => 그래도 시간 초과 public static void main(String[] args)
	 * { // TODO Auto-generated method stub Scanner s = new Scanner(System.in);
	 * String sentence = s.nextLine(); LinkedList<Character> list = new
	 * LinkedList<Character>(); for (int i = 0; i < sentence.length(); i++) {
	 * list.add(sentence.charAt(i)); } int currentCursor = list.size() - 1; int
	 * M = s.nextInt(); s.nextLine(); for (int i = 0; i < M; i++) { String
	 * command = s.nextLine(); if (command.startsWith("L")) { if (currentCursor
	 * == -1) continue; currentCursor--; } else if (command.startsWith("D")) {
	 * if (currentCursor == list.size() - 1) continue; currentCursor++; } else
	 * if (command.startsWith("B")) { if (currentCursor == -1) continue;
	 * list.remove(currentCursor); currentCursor--; } else { String[] arr =
	 * command.split(" "); list.add(currentCursor + 1, arr[1].charAt(0));
	 * currentCursor++; } } for (int i = 0; i < list.size(); i++) {
	 * System.out.print(list.get(i)); } }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left;
		Stack<Character> right;
		try {
			String sentence = br.readLine();
			left = new Stack<Character>();
			right = new Stack<Character>();
			for (int i = 0; i < sentence.length(); i++)
				left.push(sentence.charAt(i));

			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				String command = br.readLine();
				if (command.startsWith("L")) {
					if (left.empty())
						continue;
					right.push(left.pop());
				} else if (command.startsWith("D")) {
					if (right.empty())
						continue;
					left.push(right.pop());
				} else if (command.startsWith("B")) {
					if (left.empty())
						continue;
					left.pop();
				} else {
					String[] arr = command.split(" ");
					left.push(arr[1].charAt(0));
				}
			}
			Character[] result = new Character[left.size() + right.size()];
			int flag = left.size();
			while (!right.empty()) {
				result[flag] = right.pop();
				flag++;
			}
			flag = left.size() - 1;
			while (!left.empty()) {
				result[flag] = left.pop();
				flag--;
			}
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
