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
    static char[][] map;


    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static Set<Character> set=new HashSet<>();

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new char[R][C];
        for(int i=0;i<R;i++){
            String input=br.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=input.charAt(j);
            }
        }

        set.add(map[0][0]);
        back(0,0,0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=1;
    private static void back(int r, int c, int cnt) {

        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(nr>=0&&nr<R&&nc>=0&&nc<C){
                char next=map[nr][nc];
                if(!set.contains(next)){
                    set.add(next);
                    answer= Math.max(answer,set.size());
                    back(nr,nc,cnt+1);
                    set.remove(next);
                }
            }
        }
    }
}
