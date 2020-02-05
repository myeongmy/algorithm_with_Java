//���� 15686��
//���Ʈ ���� ����
/*����
ũ�Ⱑ N��N�� ���ð� �ִ�. ���ô� 1��1ũ���� ĭ���� �������� �ִ�. ������ �� ĭ�� �� ĭ, ġŲ��, �� �� �ϳ��̴�. ������ ĭ�� (r, c)�� ���� ���·� ��Ÿ����, r�� c�� �Ǵ� ���������� r��° ĭ, ���ʿ������� c��° ĭ�� �ǹ��Ѵ�. r�� c�� 1���� �����Ѵ�.

�� ���ÿ� ��� ������� ġŲ�� �ſ� �����Ѵ�. ����, ������� "ġŲ �Ÿ�"��� ���� �ַ� ����Ѵ�. ġŲ �Ÿ��� ���� ���� ����� ġŲ�� ������ �Ÿ��̴�. ��, ġŲ �Ÿ��� ���� �������� ��������, ������ ���� ġŲ �Ÿ��� ������ �ִ�. ������ ġŲ �Ÿ��� ��� ���� ġŲ �Ÿ��� ���̴�.

������ �� ĭ (r1, c1)�� (r2, c2) ������ �Ÿ��� |r1-r2| + |c1-c2|�� ���Ѵ�.

���� ���, �Ʒ��� ���� ������ ���� ���ø� ���캸��.

0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 2
0�� �� ĭ, 1�� ��, 2�� ġŲ���̴�.

(2, 1)�� �ִ� ���� (1, 2)�� �ִ� ġŲ������ �Ÿ��� |2-1| + |1-2| = 2, (5, 5)�� �ִ� ġŲ������ �Ÿ��� |2-5| + |1-5| = 7�̴�. ����, (2, 1)�� �ִ� ���� ġŲ �Ÿ��� 2�̴�.

(5, 4)�� �ִ� ���� (1, 2)�� �ִ� ġŲ������ �Ÿ��� |5-1| + |4-2| = 6, (5, 5)�� �ִ� ġŲ������ �Ÿ��� |5-5| + |4-5| = 1�̴�. ����, (5, 4)�� �ִ� ���� ġŲ �Ÿ��� 1�̴�.

�� ���ÿ� �ִ� ġŲ���� ��� ���� �����������̴�. ���������� ���翡���� ������ ������Ű�� ���� �Ϻ� ġŲ���� �����Ű���� �Ѵ�. ���� ���� ���� �� ���ÿ��� ���� ������ ���� �� �� �ִ�  ġŲ���� ������ �ִ� M����� ����� �˾Ƴ�����.

���ÿ� �ִ� ġŲ�� �߿��� �ִ� M���� ����, ������ ġŲ���� ��� ������Ѿ� �Ѵ�. ��� ����, ������ ġŲ �Ÿ��� ���� �۰� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N(2 �� N �� 50)�� M(1 �� M �� 13)�� �־�����.

��° �ٺ��� N���� �ٿ��� ������ ������ �־�����.

������ ������ 0, 1, 2�� �̷���� �ְ�, 0�� �� ĭ, 1�� ��, 2�� ġŲ���� �ǹ��Ѵ�. ���� ������ 2N���� ���� ������, ��� 1���� �����Ѵ�. ġŲ���� ������ M���� ũ�ų� ����, 13���� �۰ų� ����.

���
ù° �ٿ� �����Ű�� ���� ġŲ���� �ִ� M���� ����� ��, ������ ġŲ �Ÿ��� �ּڰ��� ����Ѵ�.*/

package ����;
import java.util.*;
class Point{
	int i;
	int j;
	
	Point(int i, int j){
		this.i = i;
		this.j = j;
	}
}
public class N_15686 {
	static ArrayList<Point> house = new ArrayList<Point>();   //���� ��ġ�� �����ϴ� ����Ʈ
	static ArrayList<Point> chick = new ArrayList<Point>();   //ġŲ���� ��ġ�� �����ϴ� ����Ʈ
	static ArrayList<Integer> result = new ArrayList<Integer>();   // ������ ġŲ ���� ����Ǿ� �ִ� ����Ʈ
	static int min = 1000000;
	static void go(int index, int selected, int M) {
		if(selected == M) {
			int total = 0;
			for(int i=0;i<house.size();i++) {
				int sub = 10000;
				for(int j=0;j<result.size();j++) {
					int dist = Math.abs(house.get(i).i - chick.get(result.get(j)).i) + Math.abs(house.get(i).j - chick.get(result.get(j)).j);
					if(sub > dist) sub = dist;
				}
				total += sub;
			}
			if(min > total)
				min = total;
			return;
		}
		if(index >= chick.size()) return;
		result.add(index);
		go(index+1, selected+1,M);
		result.remove(result.size() -1);
		
		go(index+1, selected,M);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();  // ġŲ ���� �� M�� ����
		int [][] A = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				A[i][j] = s.nextInt();
				if(A[i][j] == 1) house.add(new Point(i, j));
				if(A[i][j] == 2) chick.add(new Point(i, j));
			}
		}
		go(0, 0, M);
		System.out.println(min);
	}

}
