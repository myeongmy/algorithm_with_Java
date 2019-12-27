package codingtest_study;

import java.util.Scanner;

public class ColorPaper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for(int i=0;i<testCase;i++){
			int N = s.nextInt();
			int K = s.nextInt();
			int [] arr = new int[N];
			int [] endindex = new int[K];
			int [] numpaper = new int[K];
			for(int j=0;j<N;j++){
				arr[j] = s.nextInt();
				if(j>0 &&arr[j-1]+1 == arr[j])
					endindex[arr[j-1]-1] = j-1;
			}
			int index = 0;
			for(int j=0;j<N;j++){
				if(j == 0)
					numpaper[index] += 1;
				else{
					if(arr[j] != 0){
						numpaper[arr[j]-1] += 1;
						index = arr[j] - 1;
					}else{
						if(j < endindex[index])
							numpaper[index] += 1;
						else{
							//두 가지 경우(
						}
					}
				}
			}
				
		}

	}

}
