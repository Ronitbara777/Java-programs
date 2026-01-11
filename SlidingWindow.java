import java.util.*;
public class SlidingWindow {
  static final int MAX=50;
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      Random r=new Random();
      System.out.print("Enter the total number of frames");
      int totalFrames=sc.nextInt();
      System.out.print("Enter the windowSize:");
      int windowSize=sc.nextInt();
      int framesSent=0;
      while(framesSent<totalFrames){
        int framesToSend=Math.min(windowSize,totalFrames-framesSent);
        System.out.println("Sending Frames:");
        for(int i=0;i<framesToSend;i++){
          System.out.println("Sending frame:"+framesSent+i);
        }
        boolean allAcked=true;
        for(int i=0;i<framesToSend;i++){
          boolean ackReceived=r.nextInt(10)<9;
          if(ackReceived){
            System.out.println("Ack received for frame:"+(framesSent+i));
          }else{
            System.out.println("Ack Lost for frame"+(framesSent+i));
            System.out.println("retransmitting from here");
            allAcked=false;
            break;
          }
        }
        if(allAcked){
            framesSent+=framesToSend;
          }
      }
      System.out.println("\n All frames send and acknowledged succesfully.");
  }
}
