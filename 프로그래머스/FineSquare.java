//�ִ����� �̿��� ������ �簢�� ����(��α� ������)

package ���α׷��ӽ�;

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
        long num = gcd(w1, h1);    //�ִ� ����� ���ϱ�
        
        // (w/�ִ�����) * (h/�ִ�����)�� ������ (�ִ� �����)�� ����
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
