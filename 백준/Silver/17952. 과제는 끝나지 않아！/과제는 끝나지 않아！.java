import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        Stack<Integer> score=new Stack<>();
        Stack<Integer> minute=new Stack<>();
        int sum=0;

        for(int i=0;i<N;i++){
            int type=nextInt();
            if(type==1){
                int inputScore=nextInt();
                int inputMinute=nextInt()-1;
                if(inputMinute==0){
                    sum+=inputScore;
                }
                else{
                    score.push(inputScore);
                    minute.push(inputMinute);
                }
            }
            else{
                if(minute.isEmpty()) continue;
                int outputMinute=minute.pop()-1;
                if(outputMinute==0){
                    sum+=score.pop();
                }
                else{
                    minute.push(outputMinute);
                }
            }
        }
        bw.write(sum+"");
        bw.close();
    }



    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}
