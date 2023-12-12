import java.util.*;
import java.io.*;
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
    static ArrayList<Point>[] array;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

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
            array[e].add(new Point(s,w));
        }

        PriorityQueue<Point> q=new PriorityQueue<>();
        dist[0]=0;
        q.add(new Point(0,0));
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

        bw.write(dist[V-1]+"");
        bw.close();
    }
}
