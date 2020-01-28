//���� 11723��
/*����
����ִ� ������ S�� �־����� ��, �Ʒ� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

add x: S�� x�� �߰��Ѵ�. (1 �� x �� 20) S�� x�� �̹� �ִ� ��쿡�� ������ �����Ѵ�.
remove x: S���� x�� �����Ѵ�. (1 �� x �� 20) S�� x�� ���� ��쿡�� ������ �����Ѵ�.
check x: S�� x�� ������ 1��, ������ 0�� ����Ѵ�.
toggle x: S�� x�� ������ x�� �����ϰ�, ������ x�� �߰��Ѵ�. (1 �� x �� 20)
all: S�� {1, 2, ..., 20} ���� �ٲ۴�.
empty: S�� ���������� �ٲ۴�. 
�Է�
ù° �ٿ� �����ؾ� �ϴ� ������ �� M (1 �� M �� 3,000,000)�� �־�����.

��° �ٺ��� M���� �ٿ� �����ؾ� �ϴ� ������ �� �ٿ� �ϳ��� �־�����.

���
check ������ �־���������, ����� ����Ѵ�.*/

package ����;

import java.io.*;

public class N_11723 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int M = Integer.parseInt(br.readLine());
			int S = 0;
			for (int i = 0; i < M; i++) {
				String command = br.readLine();
				if (command.startsWith("add")) {
					String[] arr = command.split(" ");
					S = S | (1 << (Integer.parseInt(arr[1]) - 1));
				} else if (command.startsWith("remove")) {
					String[] arr = command.split(" ");
					S = S & ~(1 << (Integer.parseInt(arr[1]) - 1));
				} else if (command.startsWith("check")) {
					String[] arr = command.split(" ");
					if ((S & (1 << (Integer.parseInt(arr[1]) - 1))) != 0) {
						bw.write("1");
						bw.newLine();
					} else {
						bw.write("0");
						bw.newLine();
					}

				} else if (command.startsWith("toggle")) {
					String[] arr = command.split(" ");
					S = S ^ (1 << (Integer.parseInt(arr[1]) - 1));
				} else if (command.startsWith("all")) {
					S = (1 << 20) - 1;
				} else if (command.startsWith("empty")) {
					S = 0;
				}

			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
