package codingtest_study;

import java.util.Scanner;

public class MaxWinning {
	public static int findMax(StringBuilder numbers){
		char max = 0;
		int max_index = 0;
		for(int i=1;i<numbers.length();i++){
			if(numbers.charAt(i) >= max)
				max = numbers.charAt(i);
			    max_index = i;
		}
		return max_index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for(int i=0;i<testCase;i++){
			String numbers = s.next();
			StringBuilder numbers_b = new StringBuilder(numbers);
			int exNum = s.nextInt();
			if(numbers.length() <= 2){
				for(int j=0;j<exNum;j++){
					char temp = numbers_b.charAt(0);
					numbers_b.setCharAt(0, numbers_b.charAt(1));
					numbers_b.setCharAt(1, temp);
				}
			}else{
				for(int j=0;j<exNum;j++){
					int idx = findMax(numbers_b);
					int k;
					for(k=0;k<numbers_b.length();k++){
						if(numbers_b.charAt(k) < numbers_b.charAt(idx))
							break;
					}
					char temp = numbers_b.charAt(k);
					numbers_b.setCharAt(k, numbers_b.charAt(idx));
					numbers_b.setCharAt(idx, temp);
					System.out.println(idx);
				}
			}
			System.out.println("#"+(i+1)+" "+numbers_b);
			
		}

	}

}
