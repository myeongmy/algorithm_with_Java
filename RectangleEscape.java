// ���� 1085�� ���簢������ Ż��

package codingtest_study;

import java.util.Arrays;
import java.util.Scanner;

public class RectangleEscape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		int w = s.nextInt();
		int h = s.nextInt();
		int[] dist = new int[4];  // �����¿� �Ÿ� ����
		dist[0] = x;
		dist[1] = w - x;
		dist[2] = y;
		dist[3] = h - y;
		Arrays.sort(dist);
		System.out.println(dist[0]);

	}

}
