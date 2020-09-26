//백준 16722번 결!합!
//dfs

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class N_16722 {
	static class Figure {
		int shape;
		int color;
		int backgroundColor;

		Figure(int shape, int color, int backgroundColor) {
			this.shape = shape;
			this.color = color;
			this.backgroundColor = backgroundColor;
		}
	}

	static LinkedList<Figure> list = new LinkedList<Figure>();
	static int[] result = new int[3];
	static Figure[] figureArr = new Figure[10];

	static void go(int idx, int selected, int M) {
		if (selected == M) {
			// 합이 되는지 여부 판단
			// 모양이 모두 같거나 다른지 확인
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // (모양, 갯수)
			for (int i = 0; i < 3; i++) {
				map.put(figureArr[result[i]].shape, map.getOrDefault(figureArr[result[i]].shape, 0) + 1);
			}
			if (map.keySet().size() != 1 && map.keySet().size() != 3)
				return;
			map.clear();
			// 색이 모두 같거나 다른지 확인
			for (int i = 0; i < 3; i++) {
				map.put(figureArr[result[i]].color, map.getOrDefault(figureArr[result[i]].color, 0) + 1);
			}
			if (map.keySet().size() != 1 && map.keySet().size() != 3)
				return;
			map.clear();
			// 배경이 모두 같거나 다른지 확인
			for (int i = 0; i < 3; i++) {
				map.put(figureArr[result[i]].backgroundColor,
						map.getOrDefault(figureArr[result[i]].backgroundColor, 0) + 1);
			}
			if (map.keySet().size() != 1 && map.keySet().size() != 3)
				return;

			list.add(new Figure(result[0], result[1], result[2]));

			return;
		}

		if (idx >= 10)
			return;

		result[selected] = idx;
		go(idx + 1, selected + 1, M);
		result[selected] = 0;

		go(idx + 1, selected, M);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 9; i++) {
			String[] arr = br.readLine().split(" ");
			int shape = 0;
			int color = 0;
			int backgroundColor = 0;
			if (arr[0].equals("CIRCLE"))
				shape = 1;
			else if (arr[0].equals("SQUARE"))
				shape = 2;
			else if (arr[0].equals("TRIANGLE"))
				shape = 3;

			if (arr[1].equals("YELLOW"))
				color = 1;
			else if (arr[1].equals("RED"))
				color = 2;
			else if (arr[1].equals("BLUE"))
				color = 3;

			if (arr[2].equals("GRAY"))
				backgroundColor = 1;
			else if (arr[2].equals("BLACK"))
				backgroundColor = 2;
			else if (arr[2].equals("WHITE"))
				backgroundColor = 3;

			figureArr[i] = new Figure(shape, color, backgroundColor);

		}

		// 합이 되는 모든 경우의 수 찾기
		go(1, 0, 3);

		// 게임 시작
		int N = Integer.parseInt(br.readLine());
		int score = 0;
		int flag = 0; // 결을 외침 여부

		Label: for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			if (arr[0].equals("H")) {
				int[] A = { Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]) };
				Arrays.sort(A);
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).shape == A[0] && list.get(k).color == A[1] && list.get(k).backgroundColor == A[2]) {
						score++;
						list.remove(k);
						continue Label;
					}
				}
				score--;
			} else if (arr[0].equals("G")) {
				if (flag == 0 && list.size() == 0) {
					score += 3;
					flag = 1;
				} else {
					score--;
				}
			}
		}

		System.out.println(score);
	}

}
