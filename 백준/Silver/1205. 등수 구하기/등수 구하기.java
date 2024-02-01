import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int newScore=nextInt();
        int P=nextInt();

        int answer=1;
        int same=0;

        for(int i=0;i<N;i++){
            int input=nextInt();
            if(newScore<input){
                answer++;
            }
            else if(newScore==input){
                same++;
            }
        }

        if(answer+same<=P){
            bw.write(answer+"");
        }
        else{
            bw.write("-1");
        }
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
