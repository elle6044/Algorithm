import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int E=nextInt();
        Set[] sets=new Set[N];
        for(int i=0;i<N;i++){
            Set<Integer> set=new HashSet<>();
//            set.add(i);
            sets[i]=set;
        }

        int songCnt=0;

        for(int e=0;e<E;e++){
            int K=nextInt();
            Set<Integer> members=new HashSet<>();
            for(int k=0;k<K;k++){
                members.add(nextInt()-1);
            }

            if(members.contains(0)){
                songCnt++;
                for (Integer member : members) {
                    sets[member].add(songCnt);
                }
            }
            else{
                Set<Integer> allSong=new HashSet<>();
                for (Integer member : members) {
                    allSong.addAll(sets[member]);
                }

                for (Integer member : members) {
                    sets[member].addAll(allSong);
                }
            }
        }

        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(sets[i].toArray()));
            if(sets[i].size()==songCnt){
                bw.write(i+1+"\n");
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
