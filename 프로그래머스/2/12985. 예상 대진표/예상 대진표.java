import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int temp=Math.min(a,b);
        b=Math.max(a,b);
        a=temp;

        while(!(a+1==b&&a%2==1)){
            answer++;
            a=a/2+a%2;
            b=b/2+b%2;
        }

        return answer;
    }
}