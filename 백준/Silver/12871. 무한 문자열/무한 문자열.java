import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input1=br.readLine();
        String input2=br.readLine();
        int answer=0;
        if(input1.length()>=input2.length()){
            input1=input1.repeat(input2.length());
            input1=input1.replace(input2,"");
            if(input1.isEmpty()){
                answer=1;
            }
        }
        else{
            input2=input2.repeat(input1.length());
            input2=input2.replace(input1,"");
            if(input2.isEmpty()){
                answer=1;
            }
        }
        bw.write(answer+"");
        bw.close();
    }
}
