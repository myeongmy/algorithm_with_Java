//백준 9466번 텀 프로젝트
//브루트 포스 - DFS + 사이클

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class N_9466 {
	static int [] A;
	static int [] c;
	static int [] cycle;   //현재 정점이 어느 정점에서부터 시작되었는지 저장!
	
	static int dfs(int start, int num, int depth) {
		c[num] = depth;
		cycle[num] = start;
		
		if(c[A[num]] != 0 && cycle[A[num]] == start) {
			return depth - c[A[num]]+1;
		}else if(c[A[num]] != 0 && cycle[A[num]] != start)
			return 0;
		
		return dfs(start, A[num], depth+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for(int t=0;t<T;t++) {
				int n = Integer.parseInt(br.readLine());
				String [] arr = br.readLine().split(" ");
				
				A = new int[n+1];
				c = new int[n+1];
				cycle = new int[n+1];
				
				for(int i=1;i<=n;i++)
					A[i] = Integer.parseInt(arr[i-1]);
				
				int result = 0;   //팀을 이룬 사람들의 수
				for(int i=1;i<=n;i++) {
					if(c[i] == 0)
						result += dfs(i, i, 1);
				}
				System.out.println(n-result);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
