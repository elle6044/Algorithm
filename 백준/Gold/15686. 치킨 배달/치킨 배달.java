import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


    static ArrayList<Point> storeArray =new ArrayList<>();
    static ArrayList<Point> houseArray=new ArrayList<>();
    static int[] array;
    static boolean[] v;
    static int storeNum=0;

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int M=nextInt();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int input=nextInt();
                if(input==2){
                    storeArray.add(new Point(i,j));
                    storeNum++;
                }
                else if(input==1){
                    houseArray.add(new Point(i,j));
                }
            }
        }

        for(int i=1;i<=M;i++){
            array=new int[i];
            v=new boolean[storeNum];
            back(i,0);
        }

        bw.write(answer+"");
        bw.close();
    }

    static int answer=Integer.MAX_VALUE;
    private static void back(int cnt, int idx) {
        if(cnt==0){
            int sum=0;
            for (Point house : houseArray) {
                int min=Integer.MAX_VALUE;
                for (int storeNum : array) {
                    Point store=storeArray.get(storeNum);
                    min= Math.min(min, Math.abs(store.r-house.r)+Math.abs(store.c- house.c));
                }
                sum+=min;
            }
            answer=Math.min(answer,sum);
            return;
        }

        for(int i=idx;i<storeNum;i++){
            if(!v[i]){
                array[cnt-1]=i;
                v[i]=true;
                back(cnt-1,i);
                v[i]=false;
            }
        }
    }


    static class Point {
        int num=0;
        int r,c;

        public Point(int r, int c){
            this.r=r;
            this.c=c;
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
