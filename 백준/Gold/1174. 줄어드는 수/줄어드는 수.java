import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());

        for(int i=1;true;i++){
            back(i,10,0);
            if(N==0||i>=10) break;
        }

        bw.write(answer+"");
        bw.close();
    }

    private static void back(int cnt, int num, long sum) {
//        System.out.println(N+" "+sum);
        if(N==0) return;
        if(cnt==0){
            N--;
            if(N==0){
                answer=sum;
            }
            return;
        }

        for(int i=0;i<num;i++){
            if(i>cnt-2){
                back(cnt-1,i,sum*10+i);
            }
        }
    }

    static int cnt;
    static long answer=-1;
}
