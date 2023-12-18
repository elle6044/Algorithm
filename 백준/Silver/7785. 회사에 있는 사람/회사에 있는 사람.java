import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static HashSet<String> hashSet=new HashSet<>();

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            if(st.nextToken().equals("enter")){
                hashSet.add(name);
            }
            else{
                if(hashSet.contains(name)){
                    hashSet.remove(name);
                }
            }
        }

        ArrayList<String> array=new ArrayList<>(hashSet);
        Collections.sort(array,Collections.reverseOrder());
        for(String name:array){
            bw.write(name+"\n");
        }
        bw.close();
    }
}
