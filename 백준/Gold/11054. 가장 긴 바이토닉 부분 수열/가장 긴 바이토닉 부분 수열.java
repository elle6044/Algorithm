import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=nextInt();
        }
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(array[i]>array[j]){
                    dp1[i]=Math.max(dp1[i],dp1[j]+1);
                }
                if(array[n-i-1]>array[n-j-1]){
                    dp2[n-i-1]=Math.max(dp2[n-i-1],dp2[n-j-1]+1);
                }
            }
        }


        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp1[i]+dp2[i]);
        }
        bw.write((max-1)+"");
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
