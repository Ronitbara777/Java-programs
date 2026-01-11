import java.util.*;
public class hamiltonian {
  static int a[][],n,source;
  static void path(int succ[]){
    System.out.print(source+"->");
    for(int j=succ[source];j!=0;j=succ[j]){
      System.out.print(j+"->");
    }
    System.out.println(source);
  }  
  static void ckt(int st,int[] succ,int visited){
    int [] temp=new int [n+1];
    if(visited==n && a[st][source]==1){
      path(succ);
      return;
    }
    for(int i=1;i<=n;i++){
      if(a[st][i]==1&&succ[i]==0){
        succ[st]=i;
        System.arraycopy(succ, 1, temp, 1, n);
        ckt(i,temp,visited+1);
      }
    }
  }
  public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.println("Enter the no. of vertices");
      n=s.nextInt();
      int[] succ=new int[n+1];
      a=new int[n+1][n+1];
      System.out.println("Enter the adjacency matrix");
      for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
          a[i][j]=s.nextInt();
        }
      }
      ckt(source=1,succ,1);
  }
}
