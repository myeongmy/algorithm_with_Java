//���� 5622��
//���ڿ� ó�� ����
/*����
������� �ҸӴϴ� �Ʒ� �׸��� ���� ������ ���̾� ��ȭ�⸦ ����Ѵ�.



��ȭ�� �ɰ� ���� ��ȣ�� �ִٸ�, ���ڸ� �ϳ��� ���� ������ �ݼ� ���� �ִ� �� ���� �ð�������� ������ �Ѵ�. ���ڸ� �ϳ� ������ ���̾��� ó�� ��ġ�� ���ư���, ���� ���ڸ� �������� ���̾��� ó�� ��ġ���� �ٽ� ������ �Ѵ�.

���� 1�� �ɷ��� �� 2�ʰ� �ʿ��ϴ�. 1���� ū ���� �Ŵµ� �ɸ��� �ð��� �̺��� �� �ɸ���, �� ĭ ���� �ִ� ���ڸ� �ɱ� ���ؼ� 1�ʾ� �� �ɸ���.

������� �ҸӴϴ� ��ȭ ��ȣ�� �� ���ڿ� �ش��ϴ� ���ڷ� �ܿ��. ��, � �ܾ �� ��, �� ���ĺ��� �ش��ϴ� ���ڸ� �ɸ� �ȴ�. ���� ���, UNUCIC�� 868242�� ����.

�ҸӴϰ� �ܿ� �ܾ �־����� ��, �� ��ȭ�� �ɱ� ���ؼ� �ʿ��� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���ĺ� �빮�ڷ� �̷���� �ܾ �־�����. �ܾ�� 2����~15���ڷ� �̷���� �ִ�.

���
ù° �ٿ� ���̾��� �ɱ� ���ؼ� �ʿ��� �ð��� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_5622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('A', 2);
		hm.put('B', 2);
		hm.put('C', 2);
		hm.put('D', 3);
		hm.put('E', 3);
		hm.put('F', 3);
		hm.put('G', 4);
		hm.put('H', 4);
		hm.put('I', 4);
		hm.put('J', 5);
		hm.put('K', 5);
		hm.put('L', 5);
		hm.put('M', 6);
		hm.put('N', 6);
		hm.put('O', 6);
		hm.put('P', 7);
		hm.put('Q', 7);
		hm.put('R', 7);
		hm.put('S', 7);
		hm.put('T', 8);
		hm.put('U', 8);
		hm.put('V', 8);
		hm.put('W', 9);
		hm.put('X', 9);
		hm.put('Y', 9);
		hm.put('Z', 9);

		Scanner s = new Scanner(System.in);
		String str = s.next();
		int time = 0;
		for (int i = 0; i < str.length(); i++) {
			time += hm.get(str.charAt(i)) + 1;
		}
		System.out.println(time);

	}

}
