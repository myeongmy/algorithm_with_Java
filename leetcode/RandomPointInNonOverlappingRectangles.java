package leetcode;
import java.util.*;

//랜덤하게 선택해야하므로 주어진 직사각형들로부터 얻을 수 있는 모든 points의 수를 구해야한다.
//그리고 해당 점이 어느 직사각형에 속하는지 구하기 위해 map이용(treemap: key값을 오름차순 정렬)
//.ceilingKey(숫자) : 해당 숫자보다 크거나 같은 key들 중에서 가장 작은 key 값 반환
//랜덤하게 숫자(1~총 points 수)를 하나 선택한 뒤,
//해당 숫자가 어느 직사각형에 속하는지 구한뒤
//좌표 값 계산!

class Solution {
  static int [][] arr;
  static int area;
  static TreeMap<Integer, int []> map;
  
  public Solution(int[][] rects) {
      area = 0;
      map = new TreeMap<Integer, int []>();
      
      for(int [] rect : rects){
          int width = rect[2] - rect[0] + 1;
          int height = rect[3] - rect[1] + 1;
          
          area += width * height;
          map.put(area, rect);
      }
  }
  
  public int[] pick() {
      int [] result = new int[2];
      
      int random = (int)(Math.random() * area) + 1;
      int key = map.ceilingKey(random);
      int [] ans = map.get(key);
      int width = ans[2] - ans[0] + 1;
      
      result[0] = ans[0] + (key - random)%width;
      result[1] = ans[1] + (key - random)/width;
      
      return result;
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(rects);
* int[] param_1 = obj.pick();
*/
