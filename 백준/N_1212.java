//���� 1212��
/*����
8������ �־����� ��, 2������ ��ȯ�ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� 8������ �־�����. �־����� ���� ���̴� 333,334�� ���� �ʴ´�.

���
ù° �ٿ� �־��� ���� 2������ ��ȯ�Ͽ� ����Ѵ�. ���� 0�� ��츦 �����ϰ�� �ݵ�� 1�� �����ؾ� �Ѵ�.*/

package codingtest_study.����;

import java.util.HashMap;
import java.util.Scanner;

public class N_1212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		HashMap<Character, String> hm = new HashMap<Character, String>();
		hm.put('0', "000");
		hm.put('1', "001");
		hm.put('2', "010");
		hm.put('3', "011");
		hm.put('4', "100");
		hm.put('5', "101");
		hm.put('6', "110");
		hm.put('7', "111");
		String num = s.nextLine();
		StringBuilder result = new StringBuilder();
		if (num.equals("0")) {
			System.out.println("0");
			System.exit(0);
		}
		for (int i = 0; i < num.length(); i++) {
			if (i == 0 && num.charAt(i) >= '0' && num.charAt(i) <= '3') {
				switch (num.charAt(i)) {
				case '0':
					result.append("");
					break;
				case '1':
					result.append("1");
					break;
				case '2':
					result.append("10");
					break;
				case '3':
					result.append("11");
					break;
				}
			} else {
				result.append(hm.get(num.charAt(i)));
			}
		}
		System.out.println(result);
	}

}