//최대공약수 이용한 멀쩡한 사각형 문제(블로그 포스팅)

package 프로그래머스;

class Solution14 {
    static long gcd(long w, long h){
    if(h == 0)
        return w;
    return gcd(h, w%h);
    }
	public long solution(int w,int h) {
		long answer = 1;
        
        long w1 = (long)w;
        long h1 = (long)h;
        long num = gcd(w1, h1);    //최대 공약수 구하기
        
        // (w/최대공약수) * (h/최대공약수)의 패턴이 (최대 공약수)개 존재
        answer = w1*h1 - ((w1/num + h1/num - 1) * num);
		return answer;
	}
}

public class FineSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution14().solution(8, 12));
	}

}
