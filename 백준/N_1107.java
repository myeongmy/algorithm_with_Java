//���� 1107��
/*����
�����̴� TV�� ���� �ִ�. �����̴� ä���� �������� ������, ��ư�� �ʹ� ���� ������ �ٶ���, �Ϻ� ���� ��ư�� ���峵��.

���������� ��ư�� 0���� 9���� ����, +�� -�� �ִ�. +�� ������ ���� �����ִ� ä�ο��� +1�� ä�η� �̵��ϰ�, -�� ������ -1�� ä�η� �̵��Ѵ�. ä�� 0���� -�� ���� ��쿡�� ä���� ������ �ʰ�, ä���� ���Ѵ� ��ŭ �ִ�.

�����̰� ���� �̵��Ϸ��� �ϴ� ä���� N�̴�. � ��ư�� ���峵���� �־����� ��, ä�� N���� �̵��ϱ� ���ؼ� ��ư�� �ּ� �� �� �������ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�����̰� ���� ���� �ִ� ä���� 100���̴�.

�Է�
ù° �ٿ� �����̰� �̵��Ϸ��� �ϴ� ä�� N (0 �� N �� 500,000)�� �־�����.  ��° �ٿ��� ���峭 ��ư�� ���� M (0 �� M �� 10)�� �־�����. ���峭 ��ư�� �ִ� ��쿡�� ��° �ٿ��� ���峭 ��ư�� �־�����, ���� ��ư�� ���� �� �־����� ���� ����.

���
ù° �ٿ� ä�� N���� �̵��ϱ� ���� ��ư�� �ּ� �� �� ������ �ϴ����� ����Ѵ�.*/

package ����;


import java.util.Scanner;

public class N_1107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		boolean [] check = new boolean[10];   //ArrayList�� �����صΰ� contains() �޼ҵ� �̿��ϴ� �ͺ��� �ξ� ����
		for (int i = 0; i < M; i++)
			check[s.nextInt()] = true;
		int result;

		result = Math.abs(N - 100);

		Label: for (int i = 0; i <= 1000000; i++) {  //��� ������ ����!! i�� 1���� �����߾���.
			int num = 0;
			String c = Integer.toString(i);
			for (int j = 0; j < c.length(); j++) {
				if(check[c.charAt(j) - 48] == true)
					continue Label;  //continue���� �̿��ϴ� �׷��� ���� ������ �ð��� 3�� �̻� �پ�����.
			}
			num += c.length();
			
			num += Math.abs(N - i);
			if (result > num)
				result = num;
		}
		System.out.println(result);
	}

}
