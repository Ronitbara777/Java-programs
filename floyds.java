import java.util.Scanner;
public class floyds {
  static final int INF=999;
  public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.println("Enter the nubmer of vertices:");
      int v=s.nextInt();
      int dist[][]=new int[v][v];
      System.out.println("Enter the adjacency matrix:");
      for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
          dist[i][j]=s.nextInt();
        }
      }
      floydWarshall(dist,v);
      System.out.println("Shortest Paths:");
      printSol(dist,v);
  }
  static void floydWarshall(int[][] dist,int v){
    for(int k=0;k<v;k++){
      for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
          if(dist[i][k]+dist[k][j]<dist[i][j]){
            dist[i][j]=dist[i][k]+dist[k][j];
          }
        }
      }
    }
  }
  static void printSol(int dist[][],int v){
    for(int i=0;i<v;i++){
      for(int j=0;j<v;j++){
        if(dist[i][j]==INF){
          System.out.print("INF\t");
        }else{
          System.out.print(dist[i][j]+"\t");
        }
      }
      System.out.println();
    }
  }
}
