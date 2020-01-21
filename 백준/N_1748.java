//���� 1748��
/*����
1���� N������ ���� �̾ ���� ������ ���� ���ο� �ϳ��� ���� ���� �� �ִ�.

1234567891011121314151617181920212223...

�̷��� ������� ���ο� ���� �� �ڸ� ���ϱ�? �� ���� �ڸ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N(1��N��100,000,000)�� �־�����.

���
ù° �ٿ� ���ο� ���� �ڸ����� ����Ѵ�.*/

package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			/* �޸� �ʰ�
			 * long N = Long.parseLong(br.readLine()); 
			 * long length = 0; 
			 * for (long i = 1; i<= N; i++) { 
			 * length += Long.toString(i); 
			 * } 
			 * System.out.println(length);
			 */
			long N = Long.parseLong(br.readLine());
			long start = 1; long end = 9;
			int cnt = 1;
			long length = 0;
			while(end < N) {
				length += (end - start+1)*cnt;
				start *= 10;
				end = start*10 -1;
				cnt ++;
			}
			length += (N-start+1)*cnt;
			System.out.println(length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
