import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        boolean[][]map=new boolean[101][101];
        int cnt=0;
        for(int i=0;i<4;i++){
            int r1=nextInt();
            int c1=nextInt();
            int r2=nextInt();
            int c2=nextInt();
            for(int r=r1;r<r2;r++){
                for(int c=c1;c<c2;c++){
                    if(!map[r][c]){
                        cnt++;
                        map[r][c]=true;
                    }
                }
            }
        }

        bw.write(cnt+"");
        bw.close();
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
