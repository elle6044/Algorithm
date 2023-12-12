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

    static int V,E,X;
    static ArrayList<Point>[] array, arrayR;


    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken())-1;

        array=new ArrayList[V];
        arrayR=new ArrayList[V];
        for(int i=0;i<V;i++){
            array[i]=new ArrayList<>();
            arrayR[i]=new ArrayList<>();
        }


        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken())-1;
            int e=Integer.parseInt(st.nextToken())-1;
            int w=Integer.parseInt(st.nextToken());
            array[s].add(new Point(e,w));
            arrayR[e].add(new Point(s,w));
        }

        int[] distTo = dijkstra(array, X);
        int[] distFrom = dijkstra(arrayR, X);

        int answer=0;
        for(int i=0;i<V;i++){
            answer=Math.max(answer, distTo[i]+distFrom[i]);
        }

        bw.write(answer+"");
        bw.close();

    }

    static int[] dijkstra(ArrayList<Point>[] array, int start){
        int[] dist=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Point> pq=new PriorityQueue<>();
        dist[start]=0;
        pq.add(new Point(start,0));

        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(p.w>dist[p.e]) continue;

            for(Point np:array[p.e]){
                int nw=dist[p.e]+np.w;
                if(nw<dist[np.e]){
                    pq.add(new Point(np.e,nw));
                    dist[np.e]=nw;
                }
            }
        }
        return dist;
    }
}
