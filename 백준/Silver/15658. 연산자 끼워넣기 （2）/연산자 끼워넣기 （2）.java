import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] map;
    static int[] operator=new int[4];
    static int[] array;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        map=new int[N];
        for(int i=0;i<N;i++){
            map[i]=nextInt();
        }

        for(int i=0;i<4;i++){
            operator[i]=nextInt();
        }

        array=new int[N-1];
        back(0);

        bw.write(max+"\n"+min);
        bw.close();
    }

    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    private static void back(int cnt) {
        if(cnt==N-1){
            int sum=map[0];
            for(int i=0;i<N-1;i++){
                switch (array[i]){
                    case 0:
                        sum+=map[i+1];
                        break;
                    case 1:
                        sum-=map[i+1];
                        break;
                    case 2:
                        sum*=map[i+1];
                        break;
                    case 3:
                        if(sum<0){
                            sum=-1*(Math.abs(sum)/map[i+1]);
                        }
                        else{
                            sum/=map[i+1];
                        }
                        break;
                }
            }

            max=Math.max(max,sum);
            min=Math.min(min,sum);
            return;
        }

        for(int i=0;i<4;i++){
            if(operator[i]>0){
                array[cnt]=i;
                operator[i]--;
                back(cnt+1);
                operator[i]++;
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
