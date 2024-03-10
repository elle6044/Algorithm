import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] map=new int[10];
    static int[] array=new int[10];

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<10;i++){
            map[i]=Integer.parseInt(st.nextToken());
        }

        back(0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt) {
        if(cnt==10){
            int a=0;
            for(int i=0;i<10;i++){
                if(map[i]==array[i]){
                    a++;
                }
            }
            if(a>=5){
                answer++;
            }
            return;
        }

        for(int i=1;i<=5;i++){
            if(cnt>=2){
                if(i==array[cnt-1]&&i==array[cnt-2]){
                    continue;
                }
            }
            array[cnt]=i;
            back(cnt+1);
            array[cnt]=0;
        }
    }
}
