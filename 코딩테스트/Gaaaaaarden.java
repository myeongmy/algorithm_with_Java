//2020-03-21 Gaaaaaaarden 삼성 코테 백준 모의고사
//bfs+브루트 포스 문제

/*문제
길고 길었던 겨울이 끝나고 BOJ 마을에도 봄이 찾아왔다. BOJ 마을에서는 꽃을 마을 소유의 정원에 피우려고 한다. 정원은 땅과 호수로 이루어져 있고 2차원 격자판 모양이다.

인건비 절감을 위해 BOJ 마을에서는 직접 사람이 씨앗을 심는 대신 초록색 배양액과 빨간색 배양액을 땅에 적절하게 뿌려서 꽃을 피울 것이다. 이 때 배양액을 뿌릴 수 있는 땅은 미리 정해져있다.

배양액은 매 초마다 이전에 배양액이 도달한 적이 없는 인접한 땅으로 퍼져간다.

아래는 초록색 배양액 2개를 뿌렸을 때의 예시이다. 하얀색 칸은 배양액을 뿌릴 수 없는 땅을, 황토색 칸은 배양액을 뿌릴 수 있는 땅을, 하늘색 칸은 호수를 의미한다.



초록색 배양액과 빨간색 배양액이 동일한 시간에 도달한 땅에서는 두 배양액이 합쳐져서 꽃이 피어난다. 꽃이 피어난 땅에서는 배양액이 사라지기 때문에 더 이상 인접한 땅으로 배양액을 퍼트리지 않는다.

아래는 초록색 배양액 2개와 빨간색 배양액 2개를 뿌렸을 때의 예시이다.



배양액은 봄이 지나면 사용할 수 없게 되므로 주어진 모든 배양액을 남김없이 사용해야 한다. 예를 들어 초록색 배양액 2개와 빨간색 배양액 2개가 주어졌는데 초록색 배양액 1개를 땅에 뿌리지 않고, 초록색 배양액 1개와 빨간색 배양액 2개만을 사용하는 것은 불가능하다.

또한 모든 배양액은 서로 다른 곳에 뿌려져야 한다.

정원과 두 배양액의 개수가 주어져있을 때 피울 수 있는 꽃의 최대 개수를 구해보자.

입력
첫째 줄에 정원의 행의 개수와 열의 개수를 나타내는 N(2 ≤ N ≤ 50)과 M(2 ≤ M ≤ 50), 그리고 초록색 배양액의 개수 G(1 ≤ G ≤ 5)와 빨간색 배양액의 개수 R(1 ≤ R ≤ 5)이 한 칸의 빈칸을 사이에 두고 주어진다.

그 다음 N개의 줄에는 각 줄마다 정원의 각 행을 나타내는 M개의 정수가 한 개의 빈 칸을 사이에 두고 주어진다. 각 칸에 들어가는 값은 0, 1, 2이다. 0은 호수, 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅을 의미한다.

배양액을 뿌릴 수 있는 땅의 수는 R+G개 이상이고 10개 이하이다.

출력
첫째 줄에 피울 수 있는 꽃의 최대 개수를 출력한다.*/

package 코딩테스트;

import java.util.*;
import java.io.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	 @Override            // HashSet을 중복을 제거하기 위해 사용 -> 근데 Wrapper class가 아닌 Custom class 상대로 중복 제거하려면 hashCode()와 equals(Object o)메소드를 오버라이딩 해주어야함!
	 public int hashCode()
	 {
	  return Integer.toString(i).hashCode()+Integer.toString(j).hashCode();
	 }
	 
	 @Override
	 public boolean equals(Object o)
	 {
		 Point p = (Point)o;
	  return (this.i == p.i && this.j == p.j);
	 }
}

class Fluid {
	int color;
	int time;

	Fluid(int color, int time) {
		this.color = color;
		this.time = time;
	}
}

public class Gaaaaaarden {
	static ArrayList<Point> list = new ArrayList<Point>();
	static ArrayList<Integer> green = new ArrayList<Integer>(); // 초록색 배양액 뿌리는 땅 번호
	static ArrayList<Integer> red = new ArrayList<Integer>();
	static ArrayList<Integer> nothing = new ArrayList<Integer>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max = Integer.MIN_VALUE;

	static void go(int index, int G, int R, int[][] A) {
		if (index == list.size()) {
			if (green.size() != G || red.size() != R)
				return;

			Fluid[][] c = new Fluid[A.length][A[0].length];
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					c[i][j] = new Fluid(-1, -1); // 0은 초록, 1은 빨강
				}
			}
			// bfs
			Queue<Point> q = new LinkedList<Point>();
			for (int i = 0; i < green.size(); i++) {
				c[list.get(green.get(i)).i][list.get(green.get(i)).j].color = 0;
				c[list.get(green.get(i)).i][list.get(green.get(i)).j].time = 0;
				q.offer(new Point(list.get(green.get(i)).i, list.get(green.get(i)).j));
			}
			for (int i = 0; i < red.size(); i++) {
				c[list.get(red.get(i)).i][list.get(red.get(i)).j].color = 1;
				c[list.get(red.get(i)).i][list.get(red.get(i)).j].time = 0;
				q.offer(new Point(list.get(red.get(i)).i, list.get(red.get(i)).j));
			}

			HashSet<Point> flower = new HashSet<Point>();    //중복 제거 위함

			Label: while (!q.isEmpty()) {
				Point p = q.poll();
				Iterator<Point> it = flower.iterator();
				while(it.hasNext()) {
					Point p1 = it.next();
					if(p1.i == p.i && p1.j == p.j)
						continue Label;
				}
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if (A[p.i + dx[i]][p.j + dy[i]] != 0) { // 호수가 아닌 곳 중에서
							if (c[p.i + dx[i]][p.j + dy[i]].time == -1) { // 방문 안한 곳
								c[p.i + dx[i]][p.j + dy[i]].time = c[p.i][p.j].time + 1;
								c[p.i + dx[i]][p.j + dy[i]].color = c[p.i][p.j].color;
								q.offer(new Point(p.i + dx[i], p.j + dy[i]));

							} else if (c[p.i + dx[i]][p.j + dy[i]].color != -1
									&& c[p.i + dx[i]][p.j + dy[i]].color != c[p.i][p.j].color
									&& c[p.i + dx[i]][p.j + dy[i]].time == c[p.i][p.j].time + 1) { // 꽃이 생기는 경우
								
									flower.add(new Point(p.i + dx[i], p.j + dy[i]));
							}
						}
					}
				}
			}

			if (max < flower.size())
				max = flower.size();
			return;
		}
		green.add(index);
		go(index + 1, G, R, A);
		green.remove(green.size() - 1);

		red.add(index);
		go(index + 1, G, R, A);
		red.remove(red.size() - 1);

		nothing.add(index);
		go(index + 1, G, R, A);
		nothing.remove(nothing.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int G = Integer.parseInt(arr[2]);
			int R = Integer.parseInt(arr[3]);

			int[][] A = new int[N][M];
			for (int i = 0; i < N; i++) {
				String[] arr1 = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					A[i][j] = Integer.parseInt(arr1[j]); // 0은 호수, 1은 뿌릴 수 없는 땅, 2는 뿌릴 수 있는 땅
					if (A[i][j] == 2)
						list.add(new Point(i, j));
				}
			}

			go(0, G, R, A);
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
