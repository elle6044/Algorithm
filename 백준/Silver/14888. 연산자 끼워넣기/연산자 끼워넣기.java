import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] num;
    static int[] cal=new int[4];

    static int[] array;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        num=new int[N];
        for(int i=0;i<N;i++){
            num[i]=nextInt();
        }

        for(int i=0;i<4;i++){
            cal[i]=nextInt();
        }

        array=new int[N-1];

        back(0);

        bw.write(max+"\n"+min);
        bw.close();
    }

    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;

    private static void back(int cnt) {
        if(cnt==array.length){
            int sum=num[0];
            for(int i=1;i<N;i++){
                switch (array[i-1]){
                    case 0:
                        sum+=num[i];
                        break;
                    case 1:
                        sum-=num[i];
                        break;
                    case 2:
                        sum*=num[i];
                        break;
                    case 3:
                        sum/=num[i];
                        break;
                }
            }

            min= Math.min(min,sum);
            max= Math.max(max,sum);
            return;
        }

        for(int i=0;i<4;i++){
            if(cal[i]>0){
                array[cnt]=i;
                cal[i]--;
                back(cnt+1);
                cal[i]++;
            }
        }
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
