//연속된 수 갯수 구하는 알고리즘

package 코딩테스트;

public class Ahnlab_1 {
    public int[] solution(String[] words) {
        int[] answer = new int[words.length];
        for(int i=0;i<answer.length;i++)
            answer[i] = 1;

        Label: for(int i=0;i<words.length;i++){   //각 단어마다
            //1번 조건
            int cnt = 0;
            for(int j=0;j<words[i].length();j++){
                if(words[i].charAt(j) == 'a' || words[i].charAt(j) == 'e' || words[i].charAt(j) == 'i' || words[i].charAt(j) == 'o' || words[i].charAt(j) == 'u')
                    cnt++;
                else{
                    if(cnt >= 4){
                        answer[i] = 0;
                        continue Label;
                    }
                    cnt = 0;
                }
            }
            if(cnt >= 4){
                answer[i] = 0;
                continue Label;
            }
            //2번 조건
             cnt = 0;
            for(int j=0;j<words[i].length();j++){
                if(!(words[i].charAt(j) == 'a' || words[i].charAt(j) == 'e' || words[i].charAt(j) == 'i' || words[i].charAt(j) == 'o' || words[i].charAt(j) == 'u'))
                    cnt++;
                else{
                    if(cnt >= 4){
                        answer[i] = 0;
                        continue Label;
                    }
                    cnt = 0;
                }
            }
            if(cnt >= 4){
                answer[i] = 0;
                continue Label;
            }
            //3번 조건
            cnt = 1;
            for(int j=1;j<words[i].length();j++){
                if(words[i].charAt(j) == words[i].charAt(j-1))
                    cnt++;
                else{
                    if(cnt >= 3){
                        answer[i] = 0;
                        continue Label;
                    }
                    cnt = 1;
                }
            }
            if(cnt >= 3){
                 answer[i] = 0;
                 continue Label;
            }
            //4번 조건
             cnt = 1;
            for(int j=1;j<words[i].length();j++){
                if(Math.abs(words[i].charAt(j) - words[i].charAt(j-1)) == 1)
                    cnt++;
                else{
                    if(cnt >= 4){
                        answer[i] = 0;
                        continue Label;
                    }
                    cnt = 1;
                }
            }
            if(cnt >= 4){
                 answer[i] = 0;
                 continue Label;
            }
        }
        return answer;
    }
}
