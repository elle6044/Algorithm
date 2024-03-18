class Solution {
    public long solution(long n) {
        long answer = 0;
        long a=(long)Math.sqrt(n);
        answer=a*a==n?(a+1)*(a+1):-1;
        return answer;
    }
}