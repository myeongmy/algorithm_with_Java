// HashMap 이용
// .put(), .get() 메소드 이용

package codingtest_study;

import java.util.HashMap;
import java.util.Scanner;

public class CellPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('a', '2'); map.put('b', '2'); map.put('c', '2'); map.put('d', '3');
		map.put('e', '3'); map.put('f', '3'); map.put('g', '4'); map.put('h', '4');
		map.put('i', '4'); map.put('j', '5'); map.put('k', '5'); map.put('l', '5');
		map.put('m', '6'); map.put('n', '6'); map.put('o', '6'); map.put('p', '7');
		map.put('q', '7'); map.put('r', '7'); map.put('s', '7'); map.put('t', '8');
		map.put('u', '8'); map.put('v', '8'); map.put('w', '9'); map.put('x', '9');
		map.put('y', '9'); map.put('z', '9');
		
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			String key = s.next();
			int numOfWords = s.nextInt();
			int numCorrect = 0;
			Label: for (int j = 0; j < numOfWords; j++) {
				String word = s.next();

				int k;
				for (k = 0; k < word.length(); k++) {
					if (word.length() != key.length())
						continue Label;
					if (key.charAt(k) != map.get(word.charAt(k)))
						continue Label;

				}

				numCorrect += 1;

			}
			System.out.println("#" + (i + 1) + " " + numCorrect);
		}

	}

}
