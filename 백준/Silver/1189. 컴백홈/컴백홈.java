import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M,K;
    static char[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new char[N][M];
        v=new boolean[N][M];
        for(int i=0;i<N;i++){
            String input=br.readLine();
            for(int j=0;j<M;j++){
                char word=input.charAt(j);
                map[i][j]=word;
                if(word=='T'){
                    v[i][j]=true;
                }
            }
        }

        v[N-1][0]=true;
        baek(N-1,0,1);

        bw.write(answer+"");
        bw.close();
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static int answer=0;
    private static void baek(int r, int c, int cnt) {
        if(cnt==K){
            if(r==0&&c==M-1){
                answer++;
            }
            return;
        }
        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]){
                v[nr][nc]=true;
                baek(nr,nc,cnt+1);
                v[nr][nc]=false;
            }
        }

    }
}
