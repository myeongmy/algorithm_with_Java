//간단한 시뮬레이션

package 코딩테스트;

class Ahnlab_2 {
    public long solution(String block, int pos) {
        long answer = 0;
        StringBuilder sb = new StringBuilder(block);
        int posi = pos -  1;

        while(posi >= 0 && posi < sb.length()){
            if(sb.charAt(posi) == '>'){
                sb.setCharAt(posi, '<');
                posi++;
            }else if(sb.charAt(posi) == '<'){
                sb.setCharAt(posi, '>');
                posi--;
            }
            answer++;
        }
        return answer;
    }
}
