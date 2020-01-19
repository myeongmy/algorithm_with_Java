//sw expert academy 7272번 안경이 없어!
//HashMap 이용, .concat()주의

package codingtest_study;

import java.util.HashMap;
import java.util.Scanner;

public class NoGlasses {
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public static void mapping(){
    	map.put('C', 0);  map.put('H', 0);  map.put('L', 0);  map.put('T', 0);
    	map.put('E', 0);  map.put('I', 0);  map.put('M', 0);  map.put('U', 0);
    	map.put('F', 0);  map.put('J', 0);  map.put('N', 0);  map.put('V', 0);
    	map.put('G', 0);  map.put('K', 0);  map.put('S', 0);  map.put('W', 0);
    	map.put('X', 0);  map.put('Y', 0);  map.put('Z', 0);  map.put('A', 1);
    	map.put('D', 1);  map.put('O', 1);  map.put('P', 1);  map.put('Q', 1);
    	map.put('R', 1);  map.put('B', 2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		mapping();
		int testCase = s.nextInt();
		for(int i=0;i<testCase;i++){
			String str1 = s.next();
			String str2 = s.next();
			String str3 = "";
			String str4 = "";
			for(int j=0;j<str1.length();j++){
				str3 = str3.concat(Integer.toString(map.get(str1.charAt(j))));
			}
			for(int j=0;j<str2.length();j++){
				str4 = str4.concat(Integer.toString(map.get(str2.charAt(j))));
			}
			
			if(str3.equals(str4))
				System.out.println("#"+(i+1)+" "+"SAME");
			else
				System.out.println("#"+(i+1)+" "+"DIFF");
		}
		

	}

}
