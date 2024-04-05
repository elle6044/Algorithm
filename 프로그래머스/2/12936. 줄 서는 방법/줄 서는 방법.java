import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer>numbers=new ArrayList();
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }
        long[] factorial=new long[n];
        factorial[0]=1;
        for(int i=1;i<n;i++){
            factorial[i]=factorial[i-1]*i;
        }
        
        k--;
        for(int i=n-1;i>=0;i--){
            long idx=k/factorial[i];
            answer[n-1-i]=numbers.remove((int)idx);
            k-=factorial[i]*idx;
        }
        return answer;
    }
}