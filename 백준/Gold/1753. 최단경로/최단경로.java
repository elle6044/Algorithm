import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int V,E,K;
    static ArrayList<Point>[] array;
    static int[] dist;

    static class Point implements Comparable<Point>{
        int e,w;
        public Point(int e,int w){
            this.e=e;
            this.w=w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w-o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(br.readLine());

        array=new ArrayList[V];
        for(int i=0;i<V;i++){
            array[i]=new ArrayList<>();
        }
        dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken())-1;
            int e=Integer.parseInt(st.nextToken())-1;
            int w=Integer.parseInt(st.nextToken());
            array[s].add(new Point(e,w));
        }

        PriorityQueue<Point> q=new PriorityQueue<>();
        dist[K-1]=0;
        q.add(new Point(K-1,0));
        while(!q.isEmpty()){
            Point p=q.poll();
            if(dist[p.e]<p.w) continue;

            for(Point np : array[p.e]){
                int nw=np.w+dist[p.e];
                if(nw<dist[np.e]){
                    dist[np.e]=nw;
                    q.add(new Point(np.e,nw));
                }
            }
        }

        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                bw.write("INF\n");
            }
            else{
                bw.write(dist[i]+"\n");
            }
        }
        bw.close();
    }
}
