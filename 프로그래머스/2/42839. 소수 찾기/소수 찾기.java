import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        N=numbers.length();
        map=new int[N];
        Arrays.sort(map);
        for(int i=0;i<N;i++){
            map[i]=numbers.charAt(i)-48;
        }
        
        for(int i=1;i<=N;i++){
            v=new boolean[N];
            back(i,0);
        }
        answer=count;
        return answer;
    }
    static int count=0;
    static Set<Integer>set=new HashSet();
    public void back(int cnt, int sum){
        if(cnt==0){
            if(isPrime(sum)&&!set.contains(sum)){
                set.add(sum);
                count++;
            }
            return;
        }
        
        for(int i=0;i<N;i++){
            if(!v[i]){
                v[i]=true;
                back(cnt-1,sum*10+map[i]);
                v[i]=false;
            }
        }
    }
    public boolean isPrime(int num){
        if(num<=1) return false;
        if(num==2) return true;
        for(int i=2;i<num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    static int N;
    static int[] map;
    static boolean[] v;
}