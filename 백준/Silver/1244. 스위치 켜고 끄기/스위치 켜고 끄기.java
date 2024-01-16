import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        boolean[] buttons=new boolean[N+1];

        for(int i=1;i<=N;i++){
            buttons[i]=nextInt()==0?false:true;
        }

        int M=nextInt();
        for(int i=0;i<M;i++){
            int man=nextInt();
            int num=nextInt();
            if(man==1){
                for(int j=1;j<=N/num;j++){
                    buttons[num*j] = !buttons[num * j];
                }
            }
            else{
                buttons[num]=!buttons[num];
                int left=num-1;
                int right=num+1;
                while(left>=1&&right<=N){
                    if(buttons[left]==buttons[right]){
                        buttons[left] = !buttons[left];
                        buttons[right] = buttons[left];
                        left--;
                        right++;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        for(int i=1;i<=N;i++){
            if(buttons[i]){
                bw.write("1 ");
            }
            else{
                bw.write("0 ");
            }
            if(i%20==0){
                bw.write("\n");
            }
        }
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
