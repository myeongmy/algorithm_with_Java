package codingtest_study.���α׷��ӽ�;
 
class MakingStrangeCharacters {
  public String solution(String s) {
      String answer = "";
      
      String [] arr = s.split(" ", -1);   // -1(��)���� ����, limit�� ������ �ڿ� ���鸸 �ִ� ���� �����ع���
      System.out.println(arr.length);
      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr[i].length();j++){
              if(j%2 == 0){
                  if(arr[i].charAt(j)>='a' && arr[i].charAt(j) <= 'z')
                  answer = answer+(char)(arr[i].charAt(j)-32);
                  else
                      answer = answer+arr[i].charAt(j);
              }else{
                  if(arr[i].charAt(j)>='a' && arr[i].charAt(j) <= 'z')
                  answer = answer+arr[i].charAt(j);
                  else
                       answer = answer+(char)(arr[i].charAt(j)+32);
              }
              
          }
          if(i != arr.length-1)
             answer = answer+" ";
      }
    
      return answer;
  }
}