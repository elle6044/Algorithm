import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Point implements Comparable<Point>{
        int num;
        String eng;
        public Point(int num, String eng){
            this.num=num;
            this.eng=eng;
        }

        @Override
        public int compareTo(Point o) {
            return this.eng.compareTo(o.eng);
        }
    }

    public static void main(String[] args) throws IOException {
        Map<Integer,String> map=new HashMap<>();
        map.put(0,"zero");
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");

        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        Set<Point> set=new TreeSet<>();
        for(int n=N;n<=M;n++){
            int num=n;
            String eng="";
            while(num>=10){
                eng+=map.get(num/10);
                num%=10;
            }
            eng+=map.get(num);
            set.add(new Point(n,eng));
        }

        int cnt=0;
        for (Point point : set) {
            if(cnt==10){
                bw.write("\n");
                cnt=0;
            }
            bw.write(point.num+" ");
            cnt++;
        }

        bw.close();
    }
}
