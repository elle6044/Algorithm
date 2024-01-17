import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        boolean[] map=new boolean[10001];
        for(int i=1;i<=10000;i++){
            int nowNum=i;
            int newNum=i;
            while(nowNum>=1){
                newNum+=nowNum%10;
                nowNum/=10;
            }
            if(newNum<=10000){
                map[newNum]=true;
            }
        }

        for(int i=1;i<=10000;i++){
            if(!map[i]){
                bw.write(i+"\n");
            }
        }

        bw.close();
    }
}
