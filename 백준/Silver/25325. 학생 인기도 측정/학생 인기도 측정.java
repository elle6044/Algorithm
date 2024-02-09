import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Point implements Comparable<Point>{
        int cnt;
        String name;
        public Point(int cnt, String name){
            this.cnt=cnt;
            this.name=name;
        }
        public void addCnt(){
            this.cnt+=1;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt==o.cnt?this.name.compareTo(o.name):o.cnt-this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Map<String, Point >map=new HashMap<>();
        Set<Point> set=new TreeSet<>();
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String name=st.nextToken();
            Point p=new Point(0, name);
            map.put(name,p);
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String name=st.nextToken();
                Point p=map.get(name);
                p.addCnt();
            }
        }

        for (Point point : map.values()) {
            set.add(point);
        }

        for (Point point : set) {
            bw.write(point.name+" "+point.cnt+"\n");
        }
        bw.close();
    }
}
