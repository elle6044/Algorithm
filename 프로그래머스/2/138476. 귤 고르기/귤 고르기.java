import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] cnt=new int[10000001];
        for(int a:tangerine){
            cnt[a]++;
        }
        Arrays.sort(cnt);
        for(int i=10000000;true;i--){
            if(k<=0){
                answer=10000000-i;
                break;
            }
            k-=cnt[i];
        }
        return answer;
    }
}