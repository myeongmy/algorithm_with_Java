//���� 3954�� (Brainf**k ����������)
//�ùķ��̼� ����
/*����
Brainf**k ���α׷��� �־����� ��, �� ���α׷��� ��������, ���� ������ �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

Brainf**k ���������ʹ� ������ ��� �ϳ��� �迭(unsigned 8-bit ����)��, �� �迭�� ĭ �ϳ��� ����Ű�� �����ͷ� �̷���� �ִ�. Brainf**k ���α׷��� ������ ���� 8���� ��ɾ�� �̷���� �ִ�.

-	�����Ͱ� ����Ű�� ���� 1 ���ҽ�Ų��. (modulo 28)
+	�����Ͱ� ����Ű�� ���� 1 ������Ų��. (modulo 28)
<	�����͸� �������� �����δ�.(1 ����)
>	�����͸� ���������� �����δ�.(1 ����)
[	���� �����Ͱ� ����Ű�� ���� 0�� ���ٸ�, [�� ¦�� �̷�� ]�� �����Ѵ�.
]	���� �����Ͱ� ����Ű�� ���� 0�� �ƴ϶��, ]�� ¦�� �̷�� [�� �����Ѵ�.
.	�����Ͱ� ����Ű�� ���� ����Ѵ�.
,	���� �ϳ��� �а� �����Ͱ� ����Ű�� ���� �����Ѵ�. �Է��� ������(EOF)�� ��쿡�� 255�� �����Ѵ�.
���������ʹ� Brainf**k ���α׷��� ù ��° ��ɺ��� �����ϰ�, ���̻� ������ ����� ���ٸ�, ���α׷��� �����Ѵ�. �� ����� �����ϰ� ����, ���� ����� �����Ѵ�. ���� [�̳� ]�� ��쿡�� ���� ������� �̵��ϴ� ���� �ƴ϶� ������ �Ѵ�.

������ �迭�� ũ��� �������� �־����� ���� ����ؾ� �Ѵ�. ��, ������ �迭�� ���� underflow�� overflow�� �������� ���� �Ϲ����� ����� ������ �ȴ�. ���α׷��� �����ϱ� ����, ������ �迭�� ���� 0���� �ʱ�ȭ�Ǿ� �ְ�, �����Ͱ� ����Ű�� ĭ�� 0�� ĭ�̴�.

�����͸� �����̳� ���������� ������ ��, ������ �迭�� ������ �Ѿ�ٸ�, �ݴ������� �Ѿ�� �ȴ�. ��, �����Ͱ� 0�� ����ų ��, 1�� ���ҽ�Ų�ٸ�, �迭�� ũ�� - 1��°�� ����Ű�� �ȴ�.

[�� ]�� ������ �ǹ��ϸ�, ��ø�� �� �ִ�. �Է����� �־��� ���α׷��� �� ¥�� ������ ����ȴ�. �� ���α׷��� ���ʿ��� ���������� �����鼭 [�� �������� ]�� ������ ���� �׻� 0���� ũ�ų� ����, �� ������ ������ �� ���� 0�� �ȴ�.

�� ������ Brainf**k ���α׷��� ���� ������ �������� �� ���������� �˻��ϱ⸸ �ϸ� �ȴ�. ����, ����� �����Ѵ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� t (0 < t �� 20)�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. ù° �ٿ��� sm, sc, si�� �־�����. sm�� �޸�(�迭)�� ũ���̰�, sc�� ���α׷� �ڵ��� ũ��, si�� �Է��� ũ���̴�. (0 < sm �� 100,000, 0 < sc, si < 4096)

��° �ٿ��� Brainf**k ���α׷��� �־�����. ���α׷��� sc���� ���ڷ� �̷���� �ִ�.

��° �ٿ��� ���α׷��� �Է��� �־�����. (������ �ƴϸ鼭 ����� �� �ִ� ���ڸ� �־�����)

���
�� �׽�Ʈ ���̽��� ���ؼ�, ���α׷��� ����ȴٸ� "Terminates"��, ���� ������ ������ �ȴٸ� "Loops"�� ����Ѵ�. ���� ������ ������ ����, ���α׷��� ��� �κ��� ���� ���������� ����Ѵ�. ([�� ]�� ��ġ) ���α׷��� ��ɾ 50,000,000�� �̻� ������ ���, ���α׷��� �׻� ����Ǿ��ų� ���� ������ �����ִ�. ���� ������ ���, �ش� ������ ��� �� �� ������ �Ϸ�� �����̸�, �� ���� ���� �������� ����Ǵ� ��ɾ��� ������ 50,000,000�� �����̴�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;
import java.io.*;

public class N_3954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			Label: for (int T = 0; T < t; T++) {
				String[] arr = br.readLine().split(" ");
				int m = Integer.parseInt(arr[0]); // �迭�� ũ��
				int c = Integer.parseInt(arr[1]); // ���α׷� �ڵ��� ũ��
				int i = Integer.parseInt(arr[2]); // �Է��� ũ��

				String program = br.readLine();
				String input = br.readLine();

				int[] A = new int[m];
				int A_pointer = 0;
				int pro_pointer = 0;
				int input_pointer = 0;

				// ��ȣ ¦ ���صα�
				HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
				Stack<Integer> st = new Stack<Integer>();
				for (int j = 0; j < program.length(); j++) {
					if (program.charAt(j) == '[')
						st.push(j);
					if (program.charAt(j) == ']') {
						int a = st.pop();
						hm.put(a, j);
						hm.put(j, a);
					}
				}
				int cnt = 0; // ��ɾ� ���� Ƚ��
				int max_prolength = 0;

				while (pro_pointer != program.length()) {
					cnt++;
					if (cnt >= 50000000) {
						/*
						 * if (program.charAt(pro_pointer) == '[') { System.out.println("Loops " +
						 * pro_pointer + " " + hm.get(pro_pointer)); continue Label; } else if
						 * (program.charAt(pro_pointer) == ']') { System.out.println("Loops " +
						 * hm.get(pro_pointer) + " " + pro_pointer); continue Label; }
						 */
						System.out.println("Loops " + hm.get(max_prolength) + " " + max_prolength);    //ó���� �ð��ʰ� ������ �̷��� �ٲ�ϱ� accept
						continue Label;
					}
					if (max_prolength < pro_pointer)
						max_prolength = pro_pointer;
					if (program.charAt(pro_pointer) == '-') {
						if (A[A_pointer] == 0) {
							A[A_pointer] = 255;
						} else {
							A[A_pointer]--;
						}
					} else if (program.charAt(pro_pointer) == '+') {
						A[A_pointer] = (A[A_pointer] + 1) % (int) Math.pow(2, 8);
					} else if (program.charAt(pro_pointer) == '<') {
						if (A_pointer == 0)
							A_pointer = A.length - 1;
						else
							A_pointer--;
					} else if (program.charAt(pro_pointer) == '>') {
						if (A_pointer == A.length - 1)
							A_pointer = 0;
						else
							A_pointer++;
					} else if (program.charAt(pro_pointer) == '[') {
						if (A[A_pointer] == 0) {
							pro_pointer = hm.get(pro_pointer);
							continue;
						}
					} else if (program.charAt(pro_pointer) == ']') {
						if (A[A_pointer] != 0) {
							pro_pointer = hm.get(pro_pointer);
							continue;
						}
					} else if (program.charAt(pro_pointer) == '.') {

					} else if (program.charAt(pro_pointer) == ',') {
						if (input_pointer == input.length()) {
							A[A_pointer] = 255;
						} else {
							A[A_pointer] = input.charAt(input_pointer);
							input_pointer++;
						}
					}
					pro_pointer++;
				}
				System.out.println("Terminates");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
