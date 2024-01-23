import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T=1;
        while(true){
            int N=Integer.parseInt(br.readLine());
            if(N==0)break;

            ArrayList<Set> sets=new ArrayList<>();
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                String head=st.nextToken();
                String tail=st.nextToken();

                boolean check=false;
                for(int j=0;j<sets.size();j++){
                    if(sets.get(j).contains(head)||sets.get(j).contains(tail)){
                        sets.get(j).add(head);
                        sets.get(j).add(tail);
                        check=true;
                    }
                }

                if(!check){
                    Set<String> newSet=new HashSet<>();
                    newSet.add(head);
                    newSet.add(tail);
                    sets.add(newSet);
                }
            }

            bw.write(T+" "+sets.size()+"\n");
            T++;
        }
        bw.close();
    }
}
