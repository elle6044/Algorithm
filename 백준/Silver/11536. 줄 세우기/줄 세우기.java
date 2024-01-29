import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());

        String answer="";
        int isIncrease=0;
        String lastName=br.readLine();

        for(int i=1;i<N;i++){
            String nowName=br.readLine();
            if(i==1){
                if (lastName.compareTo(nowName)<0){
                    isIncrease=-1;
                    answer="INCREASING";
                }
                else{
                    isIncrease=1;
                    answer="DECREASING";
                }
            }
            else{
                if(lastName.compareTo(nowName)*isIncrease<0){
                    answer="NEITHER";
                    break;
                }
            }
            lastName=nowName;
        }
        bw.write(answer);
        bw.close();
    }
}
