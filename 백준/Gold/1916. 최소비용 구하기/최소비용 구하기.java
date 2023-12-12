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
        public Point(int e,int w){
            this.e=e;
            this.w=w;
        }
        @Override
        public int compareTo(Point o) {
            return this.w-o.w;
        }
    }

    static int V,E;
    static ArrayList<Point>[] array;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        V=Integer.parseInt(br.readLine());
        E=Integer.parseInt(br.readLine());

        array=new ArrayList[V];
        for(int i=0;i<V;i++){
            array[i]=new ArrayList<>();
        }
        dist=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken())-1;
            int e=Integer.parseInt(st.nextToken())-1;
            int w=Integer.parseInt(st.nextToken());
            array[s].add(new Point(e,w));
        }

        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken())-1;
        int end=Integer.parseInt(st.nextToken())-1;

        PriorityQueue<Point> q=new PriorityQueue<>();
        dist[start]=0;
        q.add(new Point(start,0));
        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.w>dist[p.e]) continue;

            for(Point np:array[p.e]){
                int nw=dist[p.e]+np.w;
                if(nw<dist[np.e]){
                    q.add(new Point(np.e,nw));
                    dist[np.e]=nw;
                }
            }
        }

        bw.write(dist[end]+"");
        bw.close();
    }
}
