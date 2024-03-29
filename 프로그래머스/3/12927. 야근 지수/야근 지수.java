import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        int idx=works.length-1;
        int temp=works[idx];
        for(int i=0;i<n;i++){
            works[idx]--;
            if(idx!=0){
                if(works[idx]>=works[idx-1]){
                    idx=works.length-1;
                }
                else if(works[idx]<works[idx-1]){
                    idx--;
                }
            }
            else{
                if(works[idx]<=works[idx+1]){
                    idx=works.length-1;
                }
            }
        }
        
        for(int i=0;i<works.length;i++){
            if(works[i]<=0)continue;
            answer+=Math.pow(works[i],2);
        }
        
        return answer;
    }
}