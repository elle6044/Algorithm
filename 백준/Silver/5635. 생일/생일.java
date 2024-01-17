import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        Point minP=new Point(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));;
        Point maxP=minP;
        for(int i=1;i<N;i++){
            st=new StringTokenizer(br.readLine());
            Point p=new Point(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            minP=minP.compareTo(p)>0?minP:p;
            maxP=maxP.compareTo(p)<0?maxP:p;
        }

        bw.write(minP.name+"\n");
        bw.write(maxP.name+"\n");
        bw.close();
    }

    static class Point implements Comparable<Point>{
        String name;
        int year,month,day;
        public Point(String name, int day, int month, int year){
            this.name=name;
            this.year=year;
            this.month=month;
            this.day=day;
        }

        @Override
        public int compareTo(Point o) {
            return this.year!=o.year?this.year-o.year:this.month!=o.month?this.month-o.month:this.day-o.day;
        }
    }
}
