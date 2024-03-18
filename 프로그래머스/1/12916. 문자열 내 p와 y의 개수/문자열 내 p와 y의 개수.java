class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int cnt=0;
        for(int i=0;i<s.length();i++){
            char word=s.charAt(i);
            if(word=='p'||word=='P') cnt++;
            else if(word=='y'||word=='Y') cnt--;
        }
        answer=cnt==0?true:false;

        return answer;
    }
}