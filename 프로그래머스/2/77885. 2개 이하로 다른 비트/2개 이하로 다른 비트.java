import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long number=numbers[i];
            String input=Long.toBinaryString(number);
            if(input.length()==Long.bitCount(number)){
                answer[i]=number+1;
                for(int j=0;j<input.length()-1;j++){
                    answer[i]+=Math.pow(2,j);
                }
            }
            else{
                answer[i]=number;
                for(int j=0;j<input.length();j++){
                    if(input.charAt(input.length()-1-j)=='0'){
                        answer[i]+=(long)Math.pow(2,j);
                        if(j>0){
                            answer[i]-=(long)Math.pow(2,j-1);
                        }
                        break;
                    }
                }
            }
        }
        return answer;
    }
}