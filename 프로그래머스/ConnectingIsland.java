package 프로그래머스;

//mst 크루스칼 알고리즘 사용
import java.util.*;

class Solution {
  static int [] parent;
  
  static int findParent(int v){
      if(parent[v] == v) return v;
      
      return findParent(parent[v]);
  }
  
  static void union(int a, int b){
      int p1 = findParent(a);
      int p2 = findParent(b);
      
      parent[p1] = p2;
  }
  public int solution(int n, int[][] costs) {
      int answer = 0;
      Arrays.sort(costs, new Comparator<int []>(){
          public int compare(int [] a, int [] b){
              if(a[2] < b[2])
                  return -1;
              else if(a[2] > b[2])
                  return 1;
              else
                  return 0;
          }
      });
      
      //크루스칼 알고리즘
      parent = new int[n+1];
      for(int i=1;i<=n;i++)
          parent[i] = i;
      
      int selected = 0;
      for(int i=0;i<costs.length;i++){
          if(findParent(costs[i][0]) == findParent(costs[i][1]))
              continue;
          
          selected++;
          answer += costs[i][2];
          union(costs[i][0], costs[i][1]);
          
          if(selected == n-1)
              break;
      }
      return answer;
  }
}
