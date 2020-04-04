//ť�� �̿��� ������ ����

package ���α׷��ӽ�;

import java.util.*;

class Job{
    int idx;     //ó�� ���� ��ġ
    int priority;   //�켱 ����
    
    Job(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution15 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<Job> q = new LinkedList<Job>();
        
        //ť�� job ��� ����ֱ�
        for(int i=0;i<priorities.length;i++){
            q.offer(new Job(i, priorities[i]));
        }
        
        int returnNum = 1;
        while(!q.isEmpty()){
            Job j = q.poll();
            int flag = 0;     //�켱���� �� ū ������ �ִ��� ���� �Ǻ�
            
            for(int i=0;i<q.size();i++){
                if(j.priority < q.get(i).priority){
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 1){    //�� �켱���� ū�� �ִٸ�
                q.offer(new Job(j.idx, j.priority));
            }
            if(flag == 0){
                if(j.idx == location){
                    answer = returnNum;
                    break;
                }else{
                    returnNum++;
                }
            }
        }
        return answer;
    }
}

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println(new Solution15().solution(priorities, location));
	}

}
