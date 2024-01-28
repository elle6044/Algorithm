import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());

        int score=0;
        int time=0;
        int[] winTime=new int[2];

        for(int n=0;n<N;n++){
            st=new StringTokenizer(br.readLine());
            int team=Integer.parseInt(st.nextToken());
            String[] times=st.nextToken().split(":");
            int nowTime=Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);

            score+=team==1?1:-1;

            if(score==0){
                if(team==1){
                    winTime[1]+=nowTime-time;
                }
                else{
                    winTime[0]+=nowTime-time;
                }
            }
            else if((score==1&&team==1)||(score==-1&&team==2)){
                time=nowTime;
            }
        }

        if(score>=1){
            winTime[0]+=48*60-time;
        }
        else if(score<=-1){
            winTime[1]+=48*60-time;
        }

        for(int i=0;i<winTime.length;i++){
            String hour=Integer.toString(winTime[i]/60);
            hour=hour.length()==1?"0"+hour:hour;
            String min=Integer.toString(winTime[i]%60);
            min=min.length()==1?"0"+min:min;
            bw.write(hour+":"+min+"\n");
        }
        bw.close();
    }
}
