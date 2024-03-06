import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] map;
    static boolean[] v;
    static int[] array;
    static int N,B;

    public static void main(String[] args) throws Exception {
        st=new StringTokenizer(br.readLine());
        String A=st.nextToken();
        N=A.length();
        B=Integer.parseInt(st.nextToken());

        map=new int[N];
        v=new boolean[N];
        array=new int[N];
        for(int i=0;i<N;i++){
            map[i]=Character.getNumericValue(A.charAt(i));
        }
        Arrays.sort(map);

        back(0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=-1;
    private static void back(int cnt) {
        if(cnt==N){
            int sum=array[0];
            for(int i=1;i<N;i++){
                sum=sum*10+array[i];
            }
            if(sum<B){
                answer=sum;
            }
            return;
        }

        for(int i=0;i<N;i++){
            if(cnt==0&&map[i]==0) continue;
            if(!v[i]){
                array[cnt]=map[i];
                v[i]=true;
                back(cnt+1);
                array[cnt]=0;
                v[i]=false;
            }
        }
    }
}
