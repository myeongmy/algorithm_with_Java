package leetcode;

public class PowerOfFour {
	 public boolean isPowerOfFour(int num){
	        if(num == 1) return true;
	        if(num <= 0) return false;
	        
	        int n = num;
	        while(n != 1){
	            if(n % 4 != 0)
	                return false;
	            n = n / 4;
	        }
	        
	        return true;
	    }

	    
	    /*
	    public boolean isPowerOfFour(int num) {
	        if(num <= 0) return false;
	        if(num == 1) return true;
	        
	        int n = num;
	        while(n != 1){
	            if((n >> 2)*4 != n)
	                return false;
	            n = n >> 2;
	        }
	        return true;
	    }
	    */
}
