import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        int[] array=new int[10];
        while(n>0){
            array[(int)(n%10)]++;
            n/=10;
        }
        for(int i=9;i>=0;i--){
            for(int j=0;j<array[i];j++){
                answer=answer*10+i;
            }
        }
        return answer;
    }
}