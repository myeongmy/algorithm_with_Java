//큐를 이용한 프린터 문제

package 프로그래머스;

import java.util.*;

class Job{
    int idx;     //처음 문서 위치
    int priority;   //우선 순위
    
    Job(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution15 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<Job> q = new LinkedList<Job>();
        
        //큐에 job 모두 집어넣기
        for(int i=0;i<priorities.length;i++){
            q.offer(new Job(i, priorities[i]));
        }
        
        int returnNum = 1;
        while(!q.isEmpty()){
            Job j = q.poll();
            int flag = 0;     //우선순위 더 큰 문서가 있는지 여부 판별
            
            for(int i=0;i<q.size();i++){
                if(j.priority < q.get(i).priority){
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 1){    //더 우선순위 큰게 있다면
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
