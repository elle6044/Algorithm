import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dr={-1,-1,0,1,1,1,0,-1};
    static int[] dc={0,-1,-1,-1,0,1,1,1};

    static int answer=0;


    public static void main(String[] args) throws Exception {
        int[][] map=new int[4][4];
        Map<Integer,Point> fishes=new TreeMap<>();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int a=nextInt();
                int b=nextInt()-1;
                map[i][j]=a;
                fishes.put(a,new Point(i,j,a,b));
            }
        }

        Point start=fishes.remove(map[0][0]);
        map[0][0]=-1;

        back(map, fishes,0,0,start.d,1,start.num);

        bw.write(answer+"");
        bw.close();
    }

    private static void back(int[][] map, Map<Integer, Point> fishes, int r, int c, int d, int cnt, int sum) {
        if(cnt==16){
            return;
        }

        int[][]nowMap=new int[4][4];
        for(int i=0;i<4;i++){
            nowMap[i]=Arrays.copyOf(map[i],4);
        }
        Map<Integer,Point>nowFishes=new TreeMap<>();
        for (Integer i : fishes.keySet()) {
            Point p=fishes.get(i);
            nowFishes.put(p.num,new Point(p.r,p.c,p.num,p.d));
        }

        for (Integer num : nowFishes.keySet()) {
            Point fish1=nowFishes.get(num);
            for(int i=0;i<8;i++){
                int nd=fish1.d+i>=8?fish1.d+i-8:fish1.d+i;
                int nr=fish1.r+dr[nd];
                int nc=fish1.c+dc[nd];

                if(nr>=0&&nr<4&&nc>=0&&nc<4){
                    if(nowMap[nr][nc]>0){
                        Point fish2=nowFishes.get(nowMap[nr][nc]);
                        nowMap[fish1.r][fish1.c]=fish2.num;
                        nowMap[nr][nc]=fish1.num;

                        fish2.r=fish1.r;
                        fish2.c=fish1.c;
                        fish1.r=nr;
                        fish1.c=nc;
                        fish1.d=nd;

                        break;
                    }
                    else if(nowMap[nr][nc]==0){
                        nowMap[fish1.r][fish1.c]=0;
                        nowMap[nr][nc]=fish1.num;
                        fish1.r=nr;
                        fish1.c=nc;
                        fish1.d=nd;
                        break;
                    }
                }
            }
        }

        int nr=r;
        int nc=c;
        while(true){
            nr+=dr[d];
            nc+=dc[d];
            if(nr>=0&&nr<4&&nc>=0&&nc<4){
                if(nowMap[nr][nc]>0){
                    Point np=nowFishes.remove(nowMap[nr][nc]);
                    nowMap[r][c]=0;
                    nowMap[nr][nc]=-1;
                    sum+=np.num;
                    answer=Math.max(answer,sum);

                    back(nowMap, nowFishes, nr,nc,np.d,cnt+1,sum);

                    nowFishes.put(np.num,np);
                    nowMap[r][c]=-1;
                    nowMap[nr][nc]=np.num;
                    sum-=np.num;
                }
            }
            else{
                break;
            }
        }
    }

    static class Point{
        int r,c,num,d;
        public Point(int r,int c,int num,int d){
            this.r=r;
            this.c=c;
            this.num=num;
            this.d=d;
        }
        public void change(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }

    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}
