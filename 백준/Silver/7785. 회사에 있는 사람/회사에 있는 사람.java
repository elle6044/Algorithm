import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static TreeSet<String> treeSet=new TreeSet<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            if(st.nextToken().equals("enter")){
                treeSet.add(name);
            }
            else{
                treeSet.remove(name);
            }
        }
        for(String name:treeSet){
            bw.write(name+"\n");
        }
        bw.close();
    }
}
