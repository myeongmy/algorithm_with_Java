//���� 11656��
/*����
���̻� �迭�� ���ڿ� S�� ��� ���̻縦 ���������� ������ ���� �迭�̴�.

baekjoon�� ���̻�� baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n ���� �� 8������ �ְ�, �̸� ���������� �����ϸ�, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon�� �ȴ�.

���ڿ� S�� �־����� ��, ��� ���̻縦 ���������� ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���ڿ� S�� �־�����. S�� ���ĺ� �ҹ��ڷθ� �̷���� �ְ�, ���̴� 1,000���� �۰ų� ����.

���
ù° �ٺ��� S�� ���̻縦 ���������� �� �ٿ� �ϳ��� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class N_11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringBuilder sb = new StringBuilder(br.readLine());
			LinkedList<String> result = new LinkedList<String>();

			for (int i = 0; i < sb.length(); i++) {
				result.add(sb.substring(i, sb.length()));
			}
			Collections.sort(result);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
