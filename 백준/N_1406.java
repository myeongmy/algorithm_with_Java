//���� 1406��

/*����
�� �ٷ� �� ������ �����͸� �����Ϸ��� �Ѵ�. �� ������� ���� �ҹ��ڸ��� ����� �� �ִ� �������, �ִ� 600,000���ڱ��� �Է��� �� �ִ�.

�� �����⿡�� 'Ŀ��'��� ���� �ִµ�, Ŀ���� ������ �� ��(ù ��° ������ ����), ������ �� ��(������ ������ ������), �Ǵ� ���� �߰� ������ ��(��� ���ӵ� �� ���� ����)�� ��ġ�� �� �ִ�. �� ���̰� L�� ���ڿ��� ���� �����⿡ �ԷµǾ� ������, Ŀ���� ��ġ�� �� �ִ� ���� L+1���� ��찡 �ִ�.

�� �����Ⱑ �����ϴ� ��ɾ�� ������ ����.

L	Ŀ���� �������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
D	Ŀ���� ���������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
B	Ŀ�� ���ʿ� �ִ� ���ڸ� ������ (Ŀ���� ������ �� ���̸� ���õ�)
������ ���� Ŀ���� �� ĭ �������� �̵��� ��ó�� ��Ÿ������, ������ Ŀ���� �����ʿ� �ִ� ���ڴ� �״����
P $	$��� ���ڸ� Ŀ�� ���ʿ� �߰���
�ʱ⿡ �����⿡ �ԷµǾ� �ִ� ���ڿ��� �־�����, �� ���� �Է��� ��ɾ ���ʷ� �־����� ��, ��� ��ɾ �����ϰ� �� �� �����⿡ �ԷµǾ� �ִ� ���ڿ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, ��ɾ ����Ǳ� ���� Ŀ���� ������ �� �ڿ� ��ġ�ϰ� �ִٰ� �Ѵ�.

�Է�
ù° �ٿ��� �ʱ⿡ �����⿡ �ԷµǾ� �ִ� ���ڿ��� �־�����. �� ���ڿ��� ���̰� N�̰�, ���� �ҹ��ڷθ� �̷���� ������, ���̴� 100,000�� ���� �ʴ´�. ��° �ٿ��� �Է��� ��ɾ��� ������ ��Ÿ���� ���� M(1 �� M �� 500,000)�� �־�����. ��° �ٺ��� M���� �ٿ� ���� �Է��� ��ɾ ������� �־�����. ��ɾ�� ���� �� ���� �� �ϳ��� ���·θ� �־�����.

���
ù° �ٿ� ��� ��ɾ �����ϰ� �� �� �����⿡ �ԷµǾ� �ִ� ���ڿ��� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_1406 {
	/*
	 * //1. ���ڿ��� �̿��� ���� => �ð� �ʰ�(�߰��� ����,���� �ϴ� ���� ���� �ɸ�) public static void
	 * main(String[] args) { // TODO Auto-generated method stub Scanner s = new
	 * Scanner(System.in); StringBuilder sb = new StringBuilder(s.nextLine());
	 * int currentCursor = sb.length() - 1; int M = s.nextInt(); s.nextLine();
	 * for (int i = 0; i < M; i++) { String command = s.nextLine(); if
	 * (command.startsWith("P")) { String[] arr = command.split(" "); // Ŀ���� ��
	 * �ڿ� ��ġ�� ��� insert�� �̿��ϸ� IndexOufOfBound���� ���� ������ // append�̿� if
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
	 * // 2. ��ũ�� ����Ʈ�� �̿��� ���� => �׷��� �ð� �ʰ� public static void main(String[] args)
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
