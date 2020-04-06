package 프로그래머스;

//시뮬레이션 문제 (시간에 따른 시뮬은 time 대로 구현)
import java.util.*;

class Truck {
	int weight;
	int duration; // 다리 건너온 시간

	Truck(int weight, int duration) {
		this.weight = weight;
		this.duration = duration;
	}
}

class Solution17 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		int end_truck = 0; // 다리를 지난 트럭 개수
		int time = 0;
		int passing_weight = 0; // 건너고 있는 트럭의 무게 총합

		LinkedList<Truck> passing = new LinkedList<Truck>();
		LinkedList<Integer> waiting = new LinkedList<Integer>();
		for (int i = 0; i < truck_weights.length; i++) {
			waiting.add(truck_weights[i]);
		}

		while (end_truck != truck_weights.length) {
			time++;
			// duration 다 된 트럭 빼내기
			for (int i = passing.size() - 1; i >= 0; i--) {
				if (passing.get(i).duration == bridge_length) {
					end_truck++;
					passing_weight -= passing.get(i).weight;
					passing.remove(i);
				}
			}
			// 건너고 있는 트럭 duration 1씩 증가
			for (int i = 0; i < passing.size(); i++) {
				passing.get(i).duration += 1;
			}
			// 대기 트럭에서 가져온다
			if (waiting.size() > 0 && passing_weight + waiting.get(0) <= weight) {
				passing_weight += waiting.get(0);
				passing.add(new Truck(waiting.remove(0), 1));

			}
		}

		answer = time;
		return answer;
	}
}

public class PassingTruck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(new Solution17().solution(bridge_length, weight, truck_weights));
	}

}
