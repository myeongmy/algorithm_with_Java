//���� 11655��
/*����
ROT13�� ī�̻縣 ��ȣ�� �������� ���� ���ĺ��� 13���ھ� �о �����.

���� ���, "Baekjoon Online Judge"�� ROT13���� ��ȣȭ�ϸ� "Onrxwbba Bayvar Whqtr"�� �ȴ�. ROT13���� ��ȣȭ�� ������ ���� �������� �ٲٷ��� ��ȣȭ�� ���ڿ��� �ٽ� ROT13�ϸ� �ȴ�. �տ��� ��ȣȭ�� ���ڿ� "Onrxwbba Bayvar Whqtr"�� �ٽ� ROT13�� �����ϸ� "Baekjoon Online Judge"�� �ȴ�.

ROT13�� ���ĺ� �빮�ڿ� �ҹ��ڿ��� ������ �� �ִ�. ���ĺ��� �ƴ� ���ڴ� ���� ���� �״�� ���� �־�� �Ѵ�. ���� ���, "One is 1"�� ROT13���� ��ȣȭ�ϸ� "Bar vf 1"�� �ȴ�.

���ڿ��� �־����� ��, "ROT13"���� ��ȣȭ�� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���ĺ� �빮��, �ҹ���, ����, ���ڷθ� �̷���� ���ڿ� S�� �־�����. S�� ���̴� 100�� ���� �ʴ´�.

���
ù° �ٿ� S�� ROT13���� ��ȣȭ�� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_11655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				char nw = (char) (str.charAt(i) + 13);
				if (str.charAt(i) + 13 > 90)
					result.append((char)(nw - 26));
				else
					result.append(nw);
			} else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				char nw = (char) (str.charAt(i) + 13);
				if (str.charAt(i) + 13 > 122)
					result.append((char)(nw - 26));
				else
					result.append(nw);
			} else {
				result.append(str.charAt(i));
			}
		}
		System.out.println(result);
	}

}
