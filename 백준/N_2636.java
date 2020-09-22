//백준 2636번 치즈
//구현 + dfs

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_2636 {
	static class Point{
		int i;
		int j;
		
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	static boolean remain_cheese(int [][] A) {
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				if(A[i][j] == 1)
					return true;
			}
		}
		
		return false;
	}
	
	static void dfs(int i, int j, int [][] A, int [][] c) {
		c[i][j] = 1;
		
		for(int k=0;k<dx.length;k++) {
			if(i+dx[k] >= 0 && i+dx[k] < A.length && j+dy[k] >= 0 && j+dy[k] < A[0].length) {
				if(A[i+dx[k]][j+dy[k]] == 0 && c[i+dx[k]][j+dy[k]] == 0)
					dfs(i+dx[k], j+dy[k], A, c);
			}
		}
	}
	
	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int [][] A = new int[N][M];
		for(int i=0;i<N;i++) {
			String [] arr = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				A[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		int time = 0;
		int lastNum = 0;
		
		while(true) {
			//남아있는 치즈가 있는지 확인
			boolean flag = remain_cheese(A);
			if(flag == false)
				break;
			
			//치즈가 놓여있지 않은 부분이 구멍인지 아닌지 확인하기 위한 dfs
			int [][] c = new int[N][M];    //구멍이면 0, 구멍이 아니면 1 표시
			dfs(0, 0, A, c);     //(0, 0)과 연결된 부분은 모두 구멍이 아니다!
			
			//이번에 녹게될 치즈 선택
			ArrayList<Point> list = new ArrayList<Point>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(A[i][j] == 1) {
						for(int k=0;k<dx.length;k++) {
							if(A[i+dx[k]][j+dy[k]] == 0 && c[i+dx[k]][j+dy[k]] == 1) {
								list.add(new Point(i, j));
								break;
							}
						}
					}
				}
			}
			
			lastNum = list.size();
			//치즈 녹이기
			for(int i=0;i<list.size();i++) {
				A[list.get(i).i][list.get(i).j] = 0;
			}
			
			time++;
		}
		
		System.out.println(time);
		System.out.println(lastNum);
	}

}
