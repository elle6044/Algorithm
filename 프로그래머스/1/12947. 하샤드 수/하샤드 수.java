class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num=x;
        int a=0;
        while(num>0){
            a+=num%10;
            num/=10;
        }
        answer=x%a==0;
        return answer;
    }
}