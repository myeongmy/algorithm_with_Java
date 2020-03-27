//[���� SW�����׽�Ʈ] �������� ��й�ȣ
//������ ���Ʈ ���� ����
/*�� ���� ������ ���� 16���� ����(0~F)�� ���� �ִ� �������ڰ� �ִ�.

���� ������ �Ѳ��� �ð�������� ���� �� �ְ�, �� �� ���� ������ ���ڰ� �ð�������� �� ĭ�� ȸ���Ѵ�.

 

�� ������ ������ ������ ���ڰ� �ְ�, �ð���� ������ ���� �ڸ� ���ڿ� �ش��ϸ� �ϳ��� ���� ��Ÿ����.

���� ��� [Fig.1]�� ���� 1A3, B54, 8F9, D66�̰�, [Fig.2]�� ���� 61A, 3B5, 48F, 9D6�̴�.

�������ڿ��� �ڹ��谡 �ɷ��ִµ�, �� �ڹ����� ��й�ȣ�� ���� ���ڿ� ���� ���ڷ� ���� �� �ִ� ��� �� ��, K��°�� ū ���� 10�� ���� ���� ���̴�.

N���� ���ڰ� �Է����� �־����� ��, ���������� ��� ��ȣ�� ����ϴ� ���α׷��� ������.

(���� �ٸ� ȸ�� Ƚ������ ������ ���� �ߺ����� ������ �� �ִ�. ũ�� ������ �� �� ���� ���� �ߺ����� ���� �ʵ��� �����Ѵ�.)

 

[���� ����]
 

N�� 4�� ����̰�, 8�̻� 28������ �����̴�. (8 �� N �� 28)       
N���� ���ڴ� ���� 0�̻� F���Ϸ� �־�����. (A~F�� ���ĺ� �빮�ڷθ� �־�����.)
K�� ���� ������ ���� �������� ũ�� �־����� �ʴ´�.
 

[����]
 

�Ʒ��� ���� (1, B, 3, B, 3, B, 8, 1, F, 7, 5, E) 12���� ���ڰ� �־����� K�� 10�� ��츦 ���캸��.
 

 

�� ��쿡 ���� ������ ���� �� ȸ�� ���� ������ ����.  

0ȸ�� : 1B3, B3B, 81F, 75E
1ȸ�� : E1B, 3B3, B81, F75
2ȸ�� : 5E1, B3B, 3B8, 1F7
3ȸ�� : 0ȸ���� ����

���� ������ ���� ���� �������� �����ϸ� ������ ����, K(=10)��°�� ū ���� 503(=1F7)�̴�.
(B3B�� �ߺ����� ���� �ʵ��� �����Ѵ�.)

F75, E1B, B81, B3B, 81F, 75E, 5E1, 3B8, 3B3, 1F7, 1B3

 



[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ������ ���� N�� ũ�� ���� K�� �־� ����.

�� ���� �ٿ��� 16���� 0~F ���ڰ� ���� ���� N�� �־�����.


[���]

����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;
import java.io.*;

public class SWEA_5658 {
	static void moving(StringBuilder sb) {
		char s = sb.charAt(0);
		sb.deleteCharAt(0).append(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int N = Integer.parseInt(arr[0]);
				int K = Integer.parseInt(arr[1]);

				StringBuilder sb = new StringBuilder(br.readLine());

				ArrayList<String> list = new ArrayList<String>();
				int interval = N / 4;
				// 0ȸ��
				for (int j = 0; j < sb.length(); j += interval) {
					list.add(sb.substring(j, j + interval));
				}
				for (int j = 1; j < interval; j++) {
					for (int k = 0; k < interval - 1; k++) {
						moving(sb);
					}
					for (int k = 0; k < sb.length(); k += interval) {
						list.add(sb.substring(k, k + interval));
					}
				}
				Collections.sort(list, Collections.reverseOrder());
				// �ߺ����Ÿ� ���� set
				LinkedHashSet<String> set = new LinkedHashSet<String>();
				for (int k = 0; k < list.size(); k++)
					set.add(list.get(k));

				Iterator<String> it = set.iterator();
				int num = 0;
				while (it.hasNext()) {
					if (num == K - 1) {
						System.out.println("#" + (i + 1) + " " + Integer.parseInt(it.next(), 16));
						break;
					}
					it.next();
					num++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
