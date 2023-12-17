import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        set=new HashSet<>(N);
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        ArrayList<String> array=new ArrayList<>();
        for(int i=0;i<M;i++){
            String word=br.readLine();
            if(set.contains(word)){
                array.add(word);
            }
        }
        Collections.sort(array);

        bw.write(array.size()+"\n");
        for(String name:array){
            bw.write(name+"\n");
        }
        bw.close();
    }

}
