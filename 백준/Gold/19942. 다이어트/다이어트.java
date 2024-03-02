import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] minScore=new int[4];
    static int[][] map;

    static int[] sum;
    static int[] array;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        for(int i=0;i<4;i++){
            minScore[i]=nextInt();
        }
        sum=new int[5];
        array=new int[N];
        map=new int[N][5];
        for(int i=0;i<N;i++){
            for(int j=0;j<5;j++){
                map[i][j]=nextInt();
            }
        }

        answer=new int[N];

        back(0,0,0);


        if(min==Integer.MAX_VALUE){
            bw.write("-1");
        }
        else{
            bw.write(min+"\n");
        }
        for (int i : answer) {
            if(i==0) break;
            bw.write(i+" ");
        }
        bw.close();

    }

    static int[] answer;
    static int min=Integer.MAX_VALUE;
    private static void back(int cnt, int idx, int temp) {
        boolean check=true;
        for(int i=0;i<4;i++){
            if(minScore[i]>sum[i]){
                check=false;
            }
        }
        if(check){
            if(min>temp){
                for(int i=0;i<cnt;i++){
                    answer[i]=array[i];
                }
                for(int i=cnt;i<N;i++){
                    answer[i]=0;
                }
                min=temp;
            }
        }

        if(cnt==N||idx==N){
            return;
        }


        array[cnt]=idx+1;
        for(int j=0;j<5;j++){
            sum[j]+=map[idx][j];
        }

        back(cnt+1,idx+1,temp+map[idx][4]);

        array[cnt]=0;
        for(int j=0;j<5;j++){
            sum[j]-=map[idx][j];
        }

        back(cnt,idx+1,temp);
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
