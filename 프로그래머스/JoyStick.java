package 프로그래머스;

//그리디 알고리즘(백준 1021 회전하는 큐 문제와 비슷)
//알파벳 이동을 그리디하게!
//커서 이동도 그리디하게!

class Solution25 {
  public int solution(String name) {
      int answer = 0;
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<name.length();i++)
          sb.append("A");
      
      int cursor = 0;
      while(!name.equals(sb.toString())){
          //알파벳 이동
          int alphadist = Math.min(name.charAt(cursor) - sb.charAt(cursor), 90 - name.charAt(cursor) + 1);
          answer += alphadist;
          sb.setCharAt(cursor, name.charAt(cursor));
          
          //커서 이동
          int dist1 = 0;    //오른쪽 방향 이동 거리
          int dist2 = 0;    //왼쪽 방향 이동 거리
          
          int next1 = cursor;
          int next2 = cursor;
          
          while(true){
              if((next1 == cursor && dist1 != 0) || sb.charAt(next1) != name.charAt(next1)) break;
              next1++;
              dist1++;
              if(next1 >= sb.length()) next1 = 0;
          }
          while(true){
              if((next2 == cursor && dist2 != 0) || sb.charAt(next2) != name.charAt(next2)) break;
              next2--;
              dist2++;
              if(next2 < 0) next2 += name.length();
          }
          
          if(next2 == cursor && dist2 != 0) break;
          if(next1 == cursor && dist1 != 0) break;
          if(dist1 <= dist2){
              cursor = next1;
              answer += dist1;
          }else if(dist1 > dist2){
              cursor = next2;
              answer += dist2;
          }
         
      }
      return answer;
  }
}

public class JoyStick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "JEROEN";
		System.out.println(new Solution25().solution(name));
	}

}
