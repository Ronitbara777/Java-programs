import java.util.*;
public class dijkstra {
  public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.println("Enter the vertices:");
      int n=s.nextInt();
      int[][] cost=new int[n][n];
      int dist[]=new int[n];
      System.out.println("Enter the cost matrix=");
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          cost[i][j]=s.nextInt();
        }
      }
      System.out.print("Enter source:");
      int src=s.nextInt();
  }
}
