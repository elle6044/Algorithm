import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int R,C;
    static int[][] map;


    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static boolean[] words=new boolean[26];

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new int[R][C];
        for(int i=0;i<R;i++){
            String input=br.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=input.charAt(j)-65;
            }
        }
        words[map[0][0]]=true;

        back(0,0, 1);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=1;
    private static void back(int r, int c, int cnt) {

        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(nr>=0&&nr<R&&nc>=0&&nc<C){
                int next=map[nr][nc];
                if(!words[next]){
                    words[next]=true;
                    answer=Math.max(answer,cnt+1);
                    back(nr,nc,cnt+1);
                    words[next]=false;
                }
            }
        }
    }
}
