//���� 15683��(����)
//����Ž���� �ùķ��̼� ����
/*����
��ŸƮ��ũ�� �繫���� 1��1ũ���� ���簢������ �������� �ִ� N��M ũ���� ���簢������ ��Ÿ�� �� �ִ�. �繫�ǿ��� �� K���� CCTV�� ��ġ�Ǿ��� �ִµ�, CCTV�� 5���� ������ �ִ�. �� CCTV�� ������ �� �ִ� ����� ������ ����.

				
1��	2��	3��	4��	5��
1�� CCTV�� �� �� ���⸸ ������ �� �ִ�. 2���� 3���� �� ������ ������ �� �ִµ�, 2���� �����ϴ� ������ ���� �ݴ�����̾�� �ϰ�, 3���� ���� �����̾�� �Ѵ�. 4���� �� ����, 5���� �� ������ ������ �� �ִ�.

CCTV�� ������ �� �ִ� ���⿡ �ִ� ĭ ��ü�� ������ �� �ִ�. �繫�ǿ��� ���� �ִµ�, CCTV�� ���� ����� �� ����. CCTV�� ������ �� ���� ������ �簢������ �Ѵ�.

CCTV�� ȸ����ų �� �ִµ�, ȸ���� �׻� 90�� �������� �ؾ� �ϸ�, �����Ϸ��� �ϴ� ������ ���� �Ǵ� ���� �����̾�� �Ѵ�.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
�������� 0�� �� ĭ, 6�� ��, 1~5�� CCTV�� ��ȣ�̴�. ���� ���ÿ��� 1���� ���⿡ ���� ������ �� �ִ� ������ '#'�� ��Ÿ���� �Ʒ��� ����.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 # 6 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
# # 1 0 6 0
0 0 0 0 0 0
0 0 # 0 0 0
0 0 # 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 # 0 0 0
��	��	��	��
CCTV�� ���� ����� �� ���� ������, 1���� �� ������ �����ϰ� ���� ���� 6�� �����ʿ� �ִ� ���� ������ �� ����.

0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
���� ���ÿ��� ������ �� �ִ� ������ �˾ƺ��� �Ʒ��� ����.

0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
���� ��� 2: ��, ������ �ϴ� 2: ��	���� ��� 2: ��, ������ �ϴ� 2: ��	���� ��� 2: ��, ������ �ϴ� 2: ��	���� ��� 2: ��, ������ �ϴ� 2: ��
CCTV�� CCTV�� ����� �� �ִ�. �Ʒ� ���ø� ����.

0 0 2 0 3
0 6 0 0 0
0 0 6 6 0
0 0 0 0 0
���� ���� ��쿡 2�� ������ �� 3�� ������ ��� ���� ��� ���ù޴� ������ ������ ����.

# # 2 # 3
0 6 # 0 #
0 0 6 6 #
0 0 0 0 #
�繫���� ũ��� ����, �׸��� CCTV�� ������ �־����� ��, CCTV�� ������ ������ ���ؼ�, �簢 ������ �ּ� ũ�⸦ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �繫���� ���� ũ�� N�� ���� ũ�� M�� �־�����. (1 �� N, M �� 8)

��° �ٺ��� N���� �ٿ��� �繫�� �� ĭ�� ������ �־�����. 0�� �� ĭ, 6�� ��, 1~5�� CCTV�� ��Ÿ����, �������� ������ CCTV�� �����̴�. 

CCTV�� �ִ� ������ 8���� ���� �ʴ´�.

���
ù° �ٿ� �簢 ������ �ּ� ũ�⸦ ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class CCTV {
	int num; // ����Ƽ�� ��ȣ
	int i; // ����Ƽ���� ��ġ
	int j;

	CCTV(int num, int i, int j) {
		this.num = num;
		this.i = i;
		this.j = j;
	}
}

public class N_15683 {
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int min = 100;

	static void go(int index, int[][] A, ArrayList<CCTV> list) {
		if (index == list.size()) {
			int[][] test = new int[A.length][A[0].length];
			for (int i = 0; i < test.length; i++)
				test[i] = A[i].clone();
			for (int i = 0; i < result.size(); i++) {
				if (list.get(i).num == 1) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 2) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 3) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 2) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 3) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 2) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 3) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 4) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					}else if(result.get(i) == 2) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					}else if(result.get(i) == 3) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 5) {
					int x = list.get(i).i;
					int y = list.get(i).j;
					while (y - 1 >= 0 && test[x][y - 1] != 6) {
						y -= 1;
						test[x][y] = 1;
					}
					x = list.get(i).i;
					y = list.get(i).j;
					while (x + 1 < A.length && test[x + 1][y] != 6) {
						x += 1;
						test[x][y] = 1;
					}
					x = list.get(i).i;
					y = list.get(i).j;
					while (y + 1 < A[0].length && test[x][y + 1] != 6) {
						y += 1;
						test[x][y] = 1;
					}
					x = list.get(i).i;
					y = list.get(i).j;
					while (x - 1 >= 0 && test[x - 1][y] != 6) {
						x -= 1;
						test[x][y] = 1;
					}
				}
			}
			int numZero = 0;
			for (int i = 0; i < test.length; i++) {
				for (int j = 0; j < test[0].length; j++) {
					if (test[i][j] == 0)
						numZero++;
				}
			}
			if (min > numZero)
				min = numZero;

			return;
		}
		if (list.get(index).num == 1) {
			for (int i = 0; i <= 3; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 2) {
			for (int i = 0; i <= 1; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 3) {
			for (int i = 0; i <= 3; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 4) {
			for (int i = 0; i <= 3; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 5) {
			for (int i = 0; i <= 0; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] A = new int[N][M];
		ArrayList<CCTV> list = new ArrayList<CCTV>(); // ����Ƽ���� ��ȣ�� ��ġ�� �����ϴ� ����Ʈ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] >= 1 && A[i][j] <= 5)
					list.add(new CCTV(A[i][j], i, j));
			}
		}

		go(0, A, list);

		System.out.println(min);
	}

}
