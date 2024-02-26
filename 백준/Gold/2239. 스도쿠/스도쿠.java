import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map=new int[9][9];
    static ArrayList<Point> list=new ArrayList<>();

    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws Exception {
        for(int i=0;i<9;i++){
            String word=br.readLine();
            for(int j=0;j<9;j++){
                int input=Character.getNumericValue(word.charAt(j));
                map[i][j]=input;
                if(input==0) {
                    list.add(new Point(i,j));
                }
            }
        }

        back(0);

        bw.write(sb.toString());
        bw.close();
    }

    static boolean isEnd=false;
    static StringBuilder sb=new StringBuilder();
    private static void back(int cnt) throws IOException {
        if(cnt==list.size()){
            for (int[] ints : map) {
                for (int i : ints) {
                    sb.append(i);
                }
                sb.append("\n");
            }
            isEnd=true;
            return;
        }
        Point p=list.get(cnt);
        if (isEnd) return;
        for(int num=1;num<=9;num++){
            if(isPossible(p.r,p.c,num)){
                map[p.r][p.c]=num;
                back(cnt+1);
                map[p.r][p.c]=0;
            }
            if (isEnd) return;
        }
    }
    private static boolean isPossible(int r, int c, int num) {
        for(int i=0;i<9;i++){
            if(map[r][i]==num||map[i][c]==num){
                return false;
            }
        }

        int nr=r/3*3;
        int nc=c/3*3;
        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(map[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }
}