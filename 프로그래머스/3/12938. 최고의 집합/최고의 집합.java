class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        int quotient=s/n;
        int remainder=s%n;
        if(quotient==0){
            answer=new int[1];
            answer[0]=-1;
        }
        else{
            answer=new int[n];
            for(int i=0;i<n;i++){
                answer[n-1-i]=remainder>0?quotient+1:quotient;
                remainder--;
            }
        }
        return answer;
    }
}