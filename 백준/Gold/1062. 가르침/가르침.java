import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static boolean[] map=new boolean[26];

    static int answer=0;
    static char[] base={'a','n','t','i','c'};
    static int N,K;
    static Set<String> set=new HashSet<>();

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        if(K>=5){
            for(int i=0;i<5;i++){
                map[base[i]-97]=true;
            }

            back(0,0);
        }

        bw.write(answer+"");
        bw.close();
    }

    private static void back(int cnt, int idx) {
        if(cnt==K-5){
            int sum=0;
            L:for (String word : set) {
                for(int i=4;i<word.length()-4;i++){
                    if(!map[word.charAt(i)-97]){
                        continue L;
                    }
                }
                sum++;
            }
            answer=Math.max(answer,sum);
            return;
        }
        if(idx==26) return;

        if(!map[idx]){
            map[idx]=true;
            back(cnt+1,idx+1);
            map[idx]=false;
        }
        back(cnt,idx+1);
    }
}
