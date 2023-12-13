import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Point implements Comparable<Point>{
        int e,w;
        public Point(int e, int w){
            this.e=e;
            this.w=w;
        }
        @Override
        public int compareTo(Point o) {
            return this.w-o.w;
        }
    }

    static int V,E;
    static int[] check;
    static ArrayList<Point>[] array;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        array=new ArrayList[V];
        for(int i=0;i<V;i++){
            array[i]=new ArrayList<>();
        }
        dist=new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        check=new int[V];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<V;i++){
            check[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            if((check[s]==0&&check[e]==0)||(check[s]==0&&check[e]==1&&e==V-1)||(check[e]==0&&check[s]==1&&s==V-1)){
                array[s].add(new Point(e,w));
                array[e].add(new Point(s,w));
            }
        }

        PriorityQueue<Point> pq=new PriorityQueue<>();
        dist[0]=0;
        pq.add(new Point(0,0));
        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(p.w>dist[p.e]) continue;

            for(Point np:array[p.e]){
                long nw=dist[p.e]+np.w;
                if(nw<dist[np.e]){
                    pq.add(new Point(np.e, (int) nw));
                    dist[np.e]=nw;
                }
            }
        }

        if(dist[V-1]==Long.MAX_VALUE){
            bw.write("-1");
        }
        else{
            bw.write(dist[V-1]+"");
        }

        bw.close();
    }
}
