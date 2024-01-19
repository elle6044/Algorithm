import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Set<String> set=new HashSet<>();

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String man1=st.nextToken();
            String man2=st.nextToken();

            if(set.isEmpty()){
                if(man1.equals("ChongChong")||man2.equals("ChongChong")){
                    set.add(man1);
                    set.add(man2);
                }
            }
            else{
                if(set.contains(man1)||set.contains(man2)){
                    set.add(man1);
                    set.add(man2);
                }
            }
        }

        bw.write(set.size()+"");
        bw.close();
    }
}
