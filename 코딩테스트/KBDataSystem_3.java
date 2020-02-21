package 코딩테스트;
//달팽이 1(시뮬레이션)
import java.io.*;
public class KBDataSystem_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		int H = Integer.parseInt(arr[0]);   //올라가야하는 우물의 높이
		int U = Integer.parseInt(arr[1]);
		int D = Integer.parseInt(arr[2]);
		int F = Integer.parseInt(arr[3]);
		
		int day = 0;
		double decline = U * F * 0.01;
		double up = U;
		double current_height = 0;
		while(true){
			if(H == 0){
				System.out.println("Success "+0);
				System.exit(0);
			}
			day++;
			current_height += up;
			if(current_height > H){
				System.out.println("Success "+day);
				System.exit(0);
			}
			current_height -= D;
			if(current_height <= 0){
				System.out.println("Failure "+day);
				System.exit(0);
			}
			up -= decline;
		}
	}
}
