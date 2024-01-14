import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        boolean[][] map=new boolean[101][101];

        int cnt=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int sx=Integer.parseInt(st.nextToken());
            int sy=Integer.parseInt(st.nextToken());
            int ex=sx+10;
            int ey=sy+10;


            for(int x=sx;x<ex;x++){
                for(int y=sy;y<ey;y++){
                    if(!map[x][y]){
                        cnt++;
                        map[x][y]=true;
                    }
                }
            }
        }
        bw.write(cnt+"");
        bw.close();
    }


}
