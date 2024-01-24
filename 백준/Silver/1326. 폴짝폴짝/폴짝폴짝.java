import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] map;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        map=new int[N+1];
        v=new boolean[N+1];
        for(int i=1;i<=N;i++){
            map[i]=nextInt();
        }

        int sIdx=nextInt();
        int eIdx=nextInt();
        bfs(sIdx, eIdx);

        if(minCnt==Integer.MAX_VALUE){
            bw.write("-1");
        }
        else{
            bw.write(minCnt+"");
        }
        bw.close();
    }

    static class Point{
        int idx, cnt;
        public Point(int idx, int cnt){
            this.idx=idx;
            this.cnt=cnt;
        }
    }

    static int[] direction={1,-1};
    static int minCnt=Integer.MAX_VALUE;
    private static void bfs(int sIdx, int eIdx) {
        Queue<Point> q=new ArrayDeque<>();
        q.offer(new Point(sIdx,0));
        v[sIdx]=true;

        while(!q.isEmpty()){
            Point p=q.poll();
//            System.out.println(p.idx+" : "+p.cnt);
            if(p.idx==eIdx){
                minCnt=Math.min(minCnt, p.cnt);
            }

            for(int d=1; d<=N/map[p.idx];d++){
                for(int dir=0;dir<2;dir++){
                    int next=p.idx+direction[dir]*d*map[p.idx];
                    if(next>=1&&next<=N&&!v[next]){
                        q.offer(new Point(next, p.cnt+1));
                        v[next]=true;
                    }
                }
            }
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
