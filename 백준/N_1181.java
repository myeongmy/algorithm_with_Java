//���� 1181��
//���� ���� Ǯ��
/*����
���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

���̰� ª�� �ͺ���
���̰� ������ ���� ������
�Է�
ù° �ٿ� �ܾ��� ���� N�� �־�����. (1��N��20,000) ��° �ٺ��� N���� �ٿ� ���� ���ĺ� �ҹ��ڷ� �̷���� �ܾ �� �ٿ� �ϳ��� �־�����. �־����� ���ڿ��� ���̴� 50�� ���� �ʴ´�.

���
���ǿ� ���� �����Ͽ� �ܾ���� ����Ѵ�. ��, ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ����Ѵ�.*/

package ����;

import java.util.*;
import java.io.*;

public class N_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];

			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}

			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String a, String b) {
					if (a.length() < b.length()) {
						return -1;
					} else if (a.length() > b.length()) {
						return 1;
					} else {
						return a.compareTo(b);
		
					}
				}
			});

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if(i != 0 && arr[i].equals(arr[i-1])) continue;
					sb.append(arr[i]).append("\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
