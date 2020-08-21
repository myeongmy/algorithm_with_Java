package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//1. 먼저 리스트의 중간 지점을 찾아 두 개의 리스트로 분리한다.
//2. 두 번째 리스트를 역순으로 정렬한다.
//3. 두 개의 리스트를 병합한다.

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode slow = head;   //두 번째 리스트 시작 노드
        ListNode fast = head;
        ListNode last = head;   //첫 번째 리스트 마지막 노드
        
        //리스트 분리
        while(fast != null && fast.next != null){
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        last.next = null;
        
        //두 번째 리스트 역순
        ListNode prev = null;        //역순된 두 번째 리스트 시작 노드
        ListNode curr = slow;    

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        
        ListNode first = head;
        ListNode second = prev;
        
        while(first != null && second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            
            first.next = second;
            if(firstNext != null)
                second.next = firstNext;
            
            first = firstNext;
            second = secondNext;
        }
        
    }
}
