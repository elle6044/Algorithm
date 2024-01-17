import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int K=nextInt();
        PriorityQueue<Point> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int num=nextInt();
            if(num==K)num=0;
            pq.offer(new Point(num, nextInt(), nextInt(), nextInt()));
        }

        int cnt=1;
        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(p.num==0){
                bw.write(cnt+"");
                break;
            }
            cnt++;
        }

        bw.close();
    }

    static class Point implements Comparable<Point>{
        int num,g,s,b;
        public Point(int num, int g, int s, int b){
            this.num=num;
            this.g=g;
            this.s=s;
            this.b=b;
        }

        @Override
        public int compareTo(Point o) {
            return this.g!=o.g?o.g-this.g:this.s!=o.s?o.s-this.s:this.b!=o.b?o.b-this.b:this.num-o.num;
        }
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
