package codingtest_study;

import java.util.LinkedList;
import java.util.Scanner;

class Location {
	int x;
	int y;

	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class UTurnNoNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int R = s.nextInt();
		int C = s.nextInt();
		String[][] map = new String[R][C];
		for (int i = 0; i < R; i++) {
			String line = s.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = Character.toString(line.charAt(j));
			}
		}

		int k;
		int z = 0;
		Label: for (k = 0; k < R; k++) {
			for (z = 0; z < C; z++) {
				if (map[k][z].equals("."))
					break Label;
			}

		}

		Location start = new Location(k, z);
		Location current = new Location(k, z);
		Location next = new Location(-1, -1);
		Location init = new Location(-1, -1);
		LinkedList<Location> stack = new LinkedList<Location>();
		stack.add(init);
		while (!(start.x == next.x && start.y == next.y)) {

			if (current.x > 0 && map[current.x - 1][current.y].equals(".")
					&& !(stack.getLast().x == current.x - 1 && stack.getLast().y == current.y)) {
				next.x = current.x - 1;
				next.y = current.y;
			} else if (current.x < R - 1 && map[current.x + 1][current.y].equals(".")
					&& !(stack.getLast().x == current.x + 1 && stack.getLast().y == current.y)) {
				next.x = current.x + 1;
				next.y = current.y;
			} else if (current.y > 0 && map[current.x][current.y - 1].equals(".")
					&& !(stack.getLast().x == current.x && stack.getLast().y == current.y - 1)) {
				next.x = current.x;
				next.y = current.y - 1;
			} else if (current.y < C - 1 && map[current.x][current.y + 1].equals(".")
					&& !(stack.getLast().x == current.x && stack.getLast().y == current.y + 1)) {
				next.x = current.x;
				next.y = current.y + 1;
			}
			if (current.x == next.x && current.y == next.y) {
				System.out.println(1);
				System.exit(0);
			}

			stack.add(new Location(current.x, current.y));
			current.x = next.x;
			current.y = next.y;
		}
		System.out.println(0);

	}

}
