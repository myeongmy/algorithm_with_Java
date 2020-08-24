package 코딩테스트;

//완전탐색 + 시뮬레이션
import java.util.*;

public class KakaoIntern2020_4 {
  static class Road{
      int x;
      int y;
      int cost;
      int dir;
      
      Road(int x, int y, int cost, int dir){
          this.x = x;
          this.y = y;
          this.cost = cost;
          this.dir = dir;
      }
  }
  
  static int [][] arr;
  static int [] dx = {0, 0, -1, 1};
  static int [] dy = {-1, 1, 0, 0};
  static int sum = 0;
  static int min = Integer.MAX_VALUE;
  
  
  static void dfs(int i, int j, int dir, int [][] c){
      if(i == arr.length - 1 && j == arr.length - 1){
          if(min > sum)
              min = sum;
          return;
      }
      
      for(int k=0;k<dx.length;k++){
          if(i+dx[k] >= 0 && i+dx[k] < arr.length && j+dy[k] >= 0 && j+dy[k] < arr.length){
              if(arr[i+dx[k]][j+dy[k]] == 0 && c[i+dx[k]][j+dy[k]] == 0){
                  c[i+dx[k]][j+dy[k]] = 1;
                  sum += 100;
                  if(dir != -1 && dir != k) sum += 500;
                  dfs(i+dx[k], j+dy[k], k, c);
                  sum -= 100;
                  if(dir != -1 && dir != k) sum -= 500;
                  c[i+dx[k]][j+dy[k]] = 0;
              }
          }        
      }
  }
  public int solution(int[][] board) {
      int answer = 0;
      arr = board;
      
      int [][] c = new int[board.length][board.length];
      Queue<Road> q = new LinkedList<Road>();
      c[0][0] = -1;
      q.offer(new Road(0, 0, 0, 5));
      
      //dfs(0, 0, -1, c);   -> 시간 초과 발생
      
      while(!q.isEmpty()){
          Road r = q.poll();
          
          if(r.x == board.length -1 && r.y == board.length-1){
              if(min > r.cost)
                  min =  r.cost;
          }
          
          for(int i=0;i<dx.length;i++){
              if(r.x+dx[i] >= 0 && r.x+dx[i] < board.length && r.y+dy[i] >= 0 && r.y+dy[i] < board.length){
                  if(board[r.x+dx[i]][r.y+dy[i]] == 0 && c[r.x+dx[i]][r.y+dy[i]] == 0){   //벽이 아니면
                      if(r.dir != 5 && r.dir != i){
                          q.offer(new Road(r.x+dx[i], r.y+dy[i], r.cost+600, i));
                          c[r.x+dx[i]][r.y+dy[i]] = r.cost+600;
                      }else{
                          q.offer(new Road(r.x+dx[i], r.y+dy[i], r.cost+100, i));
                          c[r.x+dx[i]][r.y+dy[i]] = r.cost+100;
                      }
                  }else if(board[r.x+dx[i]][r.y+dy[i]] == 0 && c[r.x+dx[i]][r.y+dy[i]] != 0){
                      int newCost = r.cost;
                      if(r.dir != 5 && r.dir != i)
                          newCost += 600;
                      else
                          newCost += 100;
                      
                      if(c[r.x+dx[i]][r.y+dy[i]] >= newCost){   // 등호 빠지면 값이 다르게 출력됨
                          q.offer(new Road(r.x+dx[i], r.y+dy[i], newCost, i));
                          c[r.x+dx[i]][r.y+dy[i]] = newCost;
                      }
                  }
              }
          }
      }
      
      return min;
  }
  
  public static void main(String [] args) {
	  int [][] board = {{0,0,0}, {0,0,0}, {0,0,0}};
	  System.out.println(new KakaoIntern2020_4().solution(board));
  }
}
