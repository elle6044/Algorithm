import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[n];
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        for(int i=0;i<n;i++){
            array[i]=nextInt();
            dp1[i]=1;
            dp2[i]=1;
        }

        for(int i=1;i<n;i++){
            if(array[i]>=array[i-1]){
                dp1[i]=dp1[i-1]+1;
            }
            if(array[i]<=array[i-1]){
                dp2[i]=dp2[i-1]+1;
            }
        }

        int up=0;
        int down=0;
        for(int i=0;i<n;i++){
            up=Math.max(up,dp1[i]);
            down=Math.max(down,dp2[i]);
        }

        bw.write(Math.max(up,down)+"");
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
