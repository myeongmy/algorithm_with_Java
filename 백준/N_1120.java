//���� 1120��
//���Ʈ ���� ���� Ǯ��
//x�� ���ڸ� �߰��ϴ� ������� �����ߴ��� �޸� �ʰ�
//�ݴ�� y���� ���ڸ� �����ϴ� ������� �����ߴ��� pass -> String�̳� StringBuilder�� ��� append �ϴ� ���� �޸� �ʰ�
/*����
���̰� N���� ���� ���ڿ� X�� Y�� ���� ��, �� ���ڿ� X�� Y�� ���̴� X[i] �� Y[i]�� i�� �����̴�. ���� ���, X=��jimin��, Y=��minji���̸�, ���� ���̴� 4�̴�.

�� ���ڿ� A�� B�� �־�����. �̶�, A�� ���̴� B�� ���̺��� �۰ų� ����. ���� A�� ���̰� B�� ���̿� ������ �� ���� ������ ���� ������ �� �� �ִ�.

A�� �տ� �ƹ� ���ĺ��̳� �߰��Ѵ�.
A�� �ڿ� �ƹ� ���ĺ��̳� �߰��Ѵ�.
�̶�, A�� B�� ���̰� �����鼭, A�� B�� ���̸� �ּҷ� �ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� A�� B�� �־�����. A�� B�� ���̴� �ִ� 50�̰�, A�� ���̴� B�� ���̺��� �۰ų� ����, ���ĺ� �ҹ��ڷθ� �̷���� �ִ�.

���
A�� B�� ���̰� �����鼭, A�� B�� ���̸� �ּҰ� �ǵ��� ���� ��, �� ���̸� ����Ͻÿ�.*/

package ����;
import java.util.*;

public class N_1120 {
	static Character [] result = new Character[50];
	static StringBuilder x;
	static StringBuilder y;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		x = new StringBuilder(s.next());
		y = new StringBuilder(s.next());
		
		int length = y.length() - x.length();
		for(int i=0;i<=length;i++) {
			StringBuilder temp = new StringBuilder(y);
			//�� �����
			int cnt = i;
			while(cnt != 0) {
				temp.deleteCharAt(0);
				cnt--;
			}
			//�� �����
			int time = length - i;
			while(time != 0) {
				temp.deleteCharAt(temp.length()-1);
				time--;
			}
			//x�� temp ��
			int num = 0;
			for(int j=0;j<x.length();j++) {
				if(x.charAt(j) != temp.charAt(j))
					num++;
			}
			if(min > num)
				min = num;
		}
		System.out.println(min);
	}

}
