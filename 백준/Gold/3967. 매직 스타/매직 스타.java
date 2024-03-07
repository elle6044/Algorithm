import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map=new int[5][9];
    static boolean[] v=new boolean[13];

    static ArrayList<Point> xList=new ArrayList<>();

    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws IOException {
        for(int i=0;i<5;i++){
            String input=br.readLine();
            for(int j=0;j<9;j++){
                int num=input.charAt(j)-64;
                if(num>0){
                    if(num==56){
                        xList.add(new Point(i,j));
                    }
                    else{
                        map[i][j]=num;
                        v[num]=true;
                    }
                }
            }
        }

        back(0);

        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                if(map[i][j]==0){
                    bw.write(".");
                }
                else{
                    bw.write((char)(map[i][j]+64));
                }
            }
            bw.write("\n");
        }

        bw.close();
    }

    static boolean check=false;
    private static void back(int cnt) {
        if(check) return;
        if(cnt==xList.size()){
            if(check()){
                check=true;
            }
            return;
        }

        Point p=xList.get(cnt);
        for(int i=1;i<=12;i++){
            if(!v[i]){
                map[p.r][p.c]=i;
                v[i]=true;
                back(cnt+1);
                if(check) return;
                map[p.r][p.c]=0;
                v[i]=false;
            }
        }
    }

    private static boolean check() {
        int[] sum=new int[6];
        for(int i=0;i<4;i++){
            sum[0]+=map[1][i*2+1];
            sum[1]+=map[3][i*2+1];
            sum[2]+=map[i][4-i];
            sum[3]+=map[i][4+i];
            sum[4]+=map[4-i][4-i];
            sum[5]+=map[4-i][4+i];
        }
        for(int i=0;i<6;i++){
            if(sum[i]!=26){
                return false;
            }
        }
        return true;
    }
}
