package codingtest_study;

import java.util.Scanner;

public class NumberSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int [][] arr = new int[N][M];
		for(int i=0;i<N;i++){
			String str = s.next();
			for(int j=0;)
			
		}
		int min = N;
		int result = 0;
		if(N<=M);
		else
			min = M;
		Label: for(int i = min; i>=1; i--){
		     for(int j=0;j<N;j++){
		    	for(int k=0;k<M;k++){
		    		int a = arr[j][k];
		    		if(arr[j][k+i] <0 || arr[j][k+i] >= M || arr[j+i][k] <0 || arr[j+i][k] >= M || arr[j+i][k+i]<0 || arr[j+i][k+i] >= M)
		    			continue;
		    		if(a == arr[j][k+i] && a == arr[j+i][k] && a == arr[j+i][k+i]){
		    			result = min*min;
		    			break Label;
		    		}
		    	}
		    }
		}
		System.out.println(result);

	}

}
