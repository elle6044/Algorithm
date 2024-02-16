import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static class Point{
        int start,end,distance;
        public Point(int start, int end, int distance){
            this.start=start;
            this.end=end;
            this.distance=distance;
        }
    }

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int d=nextInt();
        Point[] points=new Point[n];
        for(int i=0;i<n;i++){
            points[i]=new Point(nextInt(),nextInt(),nextInt());
        }
        int[] dp=new int[d+1];
        for(int i=0;i<=d;i++){
            dp[i]=i;
        }


        for(int i=1;i<=d;i++){
            for(int j=0;j<n;j++){
                Point p=points[j];
                if(p.end==i){
                    dp[p.end]=Math.min(dp[p.end],dp[p.start]+p.distance);
                }
                else{
                    dp[i]=Math.min(dp[i],dp[i-1]+1);
                }
            }
        }

        bw.write(dp[d]+"");
        bw.close();
    }

    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}
