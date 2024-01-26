import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();

        int cnt=0;

        if(input.length()>1){
            while(true){
                int sum=0;
                for(int i=0;i<input.length();i++){
                    sum+=Character.getNumericValue(input.charAt(i));
                }
                cnt++;
                input=Integer.toString(sum);
                if(sum<10) break;
            }
        }

        bw.write(cnt+"\n");
        if(Integer.parseInt(input)%3==0){
            bw.write("YES");
        }
        else{
            bw.write("NO");
        }
        bw.close();
    }
}
