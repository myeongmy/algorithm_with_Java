//���� 1152��
//���ڿ� ó�� ����
/*����
���� ��ҹ��ڿ� ���⸸���� �̷���� ���ڿ��� �־�����. �� ���ڿ����� �� ���� �ܾ ������? �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.

�Է�
ù �ٿ� ���� ��ҹ��ڿ� ����� �̷���� ���ڿ��� �־�����. �� ���ڿ��� ���̴� 1,000,000�� ���� �ʴ´�. �ܾ�� ���� �� ���� ���еǸ�, ������ �����ؼ� ������ ���� ����. ���� ���ڿ��� �հ� �ڿ��� ������ ���� ���� �ִ�.

���
ù° �ٿ� �ܾ��� ������ ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String[] arr = s.nextLine().trim().split(" ");
		if(arr.length == 1 && arr[0].equals("")) {    //����ó�� (���⸸���� �̷���� ���ڿ��� ���� ��)
			System.out.println(0);
			System.exit(0);
		}
		System.out.println(arr.length);
	}

}
