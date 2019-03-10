//sw expert academy 5550¹ø
//arrayList .add, .get, .contains, .indexOf

package codingtest_study;

import java.util.ArrayList;
import java.util.Scanner;

public class Frog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		ArrayList<Integer> frogList = new ArrayList<Integer>();

		String crying = "croak";
		int error = 0;
		for (int i = 0; i < testCase; i++) {

			String cryingNoise = s.next();
			for (int j = 0; j < cryingNoise.length(); j++) {
				if (cryingNoise.charAt(j) == 'c' && !frogList.contains(4)) {
					frogList.add(0);
				} else {
					error = 0;
					for (int k = frogList.size() - 1; k >= 0; k--) {
						int next = (frogList.get(k) + 1) % 5;
						if (cryingNoise.charAt(j) == crying.charAt(next)) {
							frogList.set(k, next);
							error = 1;
							break;
						}
					}
					if (error == 0)
						break;
				}

			}
			for (int z = 0; z < frogList.size(); z++) {
				if (frogList.get(z) != 4) {
					error = 0;
					break;
				}
			}

			if (error == 1)
				System.out.println("#" + (i + 1) + " " + frogList.size());
			else
				System.out.println("#" + (i + 1) + " " + -1);

			frogList.clear();

		}
	}
}
