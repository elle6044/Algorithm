class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int result=arr[0];
        for(int i=1;i<arr.length;i++){
            result=lcm(result, arr[i]);
        }
        answer=result;
        
        return answer;
    }
    static int lcm(int a, int b){
        return a*(b/gcd(a,b));
    }
    static int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}