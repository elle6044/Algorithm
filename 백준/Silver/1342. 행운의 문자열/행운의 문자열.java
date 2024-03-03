import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static char[] map;
    static int N;
    static boolean[] v;
    static char[] array;
    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        N=input.length();
        map=new char[N];
        for(int i=0;i<N;i++){
            map[i]=input.charAt(i);
        }
        Arrays.sort(map);
        v=new boolean[N];
        array=new char[N];

        back(0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt) {
        if(cnt==N){
            for(int i=1;i<N;i++){
                if(array[i-1]==array[i]){
                    return;
                }
            }

            answer++;
            return;
        }

        char temp=' ';
        for(int i=0;i<N;i++){
            if(temp==map[i]) continue;
            if(!v[i]){
                array[cnt]=map[i];
                v[i]=true;
                temp=map[i];
                back(cnt+1);
                v[i]=false;
            }
        }
    }
}
