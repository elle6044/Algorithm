import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] paperCnt={0,5,5,5,5,5};

    static int[][] map=new int[10][10];
    static int oneCnt=0;


    public static void main(String[] args) throws Exception {
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                int input=nextInt();
                map[i][j]=input;
                if(input==1){
                    oneCnt++;
                }
            }
        }

        back(0,0,0);
        if (answer==25){
            bw.write("-1");
        }
        else{
            bw.write(answer+"");
        }

        bw.close();
    }

    static int answer=25;
    private static void back(int r, int c, int usePaperCnt) {
        if(oneCnt==0){
            answer=Math.min(answer,usePaperCnt);
            return;
        }

        for(int i=r;i<10;i++){
            for(int j=(i==r?c:0);j<10;j++){
                if(map[i][j]==1){
                    int maxSize=getMaxSize(i,j);
                    for(int s=maxSize;s>=1;s--){
                        if(paperCnt[s]>0){
                            change(i,j,s,0);
                            paperCnt[s]--;
                            oneCnt-=s*s;



                            back(i,j,usePaperCnt+1);
                            change(i,j,s,1);
                            paperCnt[s]++;
                            oneCnt+=s*s;
                        }
                    }
                    if(map[i][j]==1) return;
                }
            }
        }
    }

    private static void change(int r, int c, int size, int num) {
        for(int i=r;i<r+size;i++){
            for(int j=c;j<c+size;j++){
                map[i][j]=num;
            }
        }
    }

    private static int getMaxSize(int r, int c) {
        int maxSize=Math.min(10-r,Math.min(10-c,5));

        L:for(int size=maxSize;size>=1;size--){
            for(int nr=r;nr<r+size;nr++){
                for(int nc=c;nc<c+size;nc++){
                    if(map[nr][nc]==0){
                        continue L;
                    }
                }
            }
            return size;
        }
        return 0;
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
