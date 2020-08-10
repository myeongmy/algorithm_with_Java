package leetcode;
import java.util.*;

class Solution {
    static class Point{
        int i;
        int j;
        int cnt;
        
        Point(int i, int j, int cnt){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    
    //최단 거리 구하기 => BFS 알고리즘
    public int orangesRotting(int[][] grid) {
        
        Queue<Point> q = new LinkedList<Point>();
        int [][] c = new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.offer(new Point(i, j, 0));
                    c[i][j] = 1;
                }
            }
        }
        
        int time = 0;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            if(time < p.cnt)
                time = p.cnt;
            
            for(int i=0;i<dx.length;i++){
                if(p.i+dx[i] >= 0 && p.i+dx[i] < grid.length && p.j+dy[i] >= 0 && p.j+dy[i] < grid[0].length){
                    if(grid[p.i+dx[i]][p.j+dy[i]] == 1 && c[p.i+dx[i]][p.j+dy[i]] == 0){
                        q.offer(new Point(p.i+dx[i], p.j+dy[i], p.cnt+1));
                        c[p.i+dx[i]][p.j+dy[i]] = 1;
                    }
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && c[i][j] == 0)
                    return -1;
            }
        }
        return time;
        
    }
}
