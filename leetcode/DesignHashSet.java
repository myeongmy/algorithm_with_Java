package leetcode;

import java.util.*;

public class DesignHashSet {
	private int itemNum = 13000;
	LinkedList<Integer>[] list;

	private int hashFunction(int num) {
		return num % itemNum;
	}

	/** Initialize your data structure here. */
	public DesignHashSet() {
		list = (LinkedList<Integer>[]) new LinkedList[itemNum];
	}

	public void add(int key) {
		int i = hashFunction(key);
		if (list[i] == null) {
			list[i] = new LinkedList<Integer>();
		}
		// 중복 저장 피하기 위함
		if (list[i].indexOf(key) == -1)
			list[i].add(key);
	}

	public void remove(int key) {
		int i = hashFunction(key);
		if (list[i] == null)
			return; // The reason of runtime error

		for (int j = 0; j < list[i].size(); j++) {
			if (list[i].get(j) == key) {
				list[i].remove(j);
			}
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int i = hashFunction(key);
		if (list[i] == null)
			return false;
		for (int j = 0; j < list[i].size(); j++) {
			if (list[i].get(j) == key) {
				return true;
			}
		}
		return false;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
