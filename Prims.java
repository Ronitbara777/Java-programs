
import java.util.Scanner;

public class Prims {
  public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.print("Enter number of vertices:");
      int n=s.nextInt();
      int[][] cost=new int[n][n];
      System.out.println("Enter the adjacency matrix:");
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          cost[i][j]=s.nextInt();
        }
      }
      prim(cost,n);
  }
  static void prim(int cost[][],int n){
    int[] visited=new int[n];
    int mincost=0;
    int edges=1;
    visited[0]=1;
    while(edges<n){
      int min=999,a=-1,b=-1;
      for(int i=0;i<n;i++){
        if(visited[i]==1){
          for(int j=0;j<n;j++){
            if(visited[j]==0 && cost[i][j]<min){
              min=cost[i][j];
              a=i;
              b=j;
            }
          }
        }
      }
      if(a!=-1&&b!=-1){
        System.out.println("Edge"+a+"->"+b+":"+min);
      }
      visited[b]=1;
      mincost+=min;
      edges++;
      cost[a][b]=cost[b][a]=999;
    }
    System.out.println("Total MST Cost:"+mincost);
  }
  
}
