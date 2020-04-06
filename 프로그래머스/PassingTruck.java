package ���α׷��ӽ�;

//�ùķ��̼� ���� (�ð��� ���� �ù��� time ��� ����)
import java.util.*;

class Truck {
	int weight;
	int duration; // �ٸ� �ǳʿ� �ð�

	Truck(int weight, int duration) {
		this.weight = weight;
		this.duration = duration;
	}
}

class Solution17 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		int end_truck = 0; // �ٸ��� ���� Ʈ�� ����
		int time = 0;
		int passing_weight = 0; // �ǳʰ� �ִ� Ʈ���� ���� ����

		LinkedList<Truck> passing = new LinkedList<Truck>();
		LinkedList<Integer> waiting = new LinkedList<Integer>();
		for (int i = 0; i < truck_weights.length; i++) {
			waiting.add(truck_weights[i]);
		}

		while (end_truck != truck_weights.length) {
			time++;
			// duration �� �� Ʈ�� ������
			for (int i = passing.size() - 1; i >= 0; i--) {
				if (passing.get(i).duration == bridge_length) {
					end_truck++;
					passing_weight -= passing.get(i).weight;
					passing.remove(i);
				}
			}
			// �ǳʰ� �ִ� Ʈ�� duration 1�� ����
			for (int i = 0; i < passing.size(); i++) {
				passing.get(i).duration += 1;
			}
			// ��� Ʈ������ �����´�
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
