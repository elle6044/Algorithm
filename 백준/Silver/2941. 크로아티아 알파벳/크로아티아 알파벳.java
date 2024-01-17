import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Set<String> set=new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");

        String input=br.readLine();
        int cnt=0;
        for(int i=0;i<input.length();i++){
            boolean check=false;
            if(i+1<input.length()){
                if(set.contains(input.substring(i,i+1)+input.charAt(i+1))){
                    cnt++;
                    i++;
                    check=true;
                }
            }
            if(i+2<input.length()){
                if(set.contains(input.substring(i,i+2)+input.charAt(i+2))){
                    cnt++;
                    i+=2;
                    check=true;
                }
            }
            if(!check){
                cnt++;
            }
        }
        bw.write(cnt+"");
        bw.close();
    }
}
