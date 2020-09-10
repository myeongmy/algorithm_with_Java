//백준 3495번 아스키 도형
//구현

package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

public class N_3495 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] arr = br.readLine().split(" ");
			int h = Integer.parseInt(arr[0]);
			int w = Integer.parseInt(arr[1]);
			
			char [][] A = new char[h][w];
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				for(int j=0;j<w;j++) {
					A[i][j] = str.charAt(j);
				}
			}
			
			int halfCnt = 0;
			int oneCnt = 0;
			for(int j=0;j<w;j++) {
				int flag = 0;    //테두리 안에 속하는지 여부
				
				for(int i=0;i<h;i++) {
					if(A[i][j] != '.' && flag == 0) {
						halfCnt++;
						flag = 1;
					}else if(A[i][j] != '.' && flag == 1) {
						halfCnt++;
						flag = 0;
					}else if(A[i][j] == '.' && flag == 1) {
						oneCnt++;
					}
				}
			}
			
			System.out.println(halfCnt / 2 + oneCnt);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
