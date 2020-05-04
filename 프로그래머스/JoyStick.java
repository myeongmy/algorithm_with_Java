package ���α׷��ӽ�;

//�׸��� �˰���(���� 1021 ȸ���ϴ� ť ������ ���)
//���ĺ� �̵��� �׸����ϰ�!
//Ŀ�� �̵��� �׸����ϰ�!

class Solution25 {
  public int solution(String name) {
      int answer = 0;
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<name.length();i++)
          sb.append("A");
      
      int cursor = 0;
      while(!name.equals(sb.toString())){
          //���ĺ� �̵�
          int alphadist = Math.min(name.charAt(cursor) - sb.charAt(cursor), 90 - name.charAt(cursor) + 1);
          answer += alphadist;
          sb.setCharAt(cursor, name.charAt(cursor));
          
          //Ŀ�� �̵�
          int dist1 = 0;    //������ ���� �̵� �Ÿ�
          int dist2 = 0;    //���� ���� �̵� �Ÿ�
          
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
