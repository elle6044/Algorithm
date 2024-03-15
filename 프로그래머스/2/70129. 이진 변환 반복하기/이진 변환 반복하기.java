class Solution {
    public int[] solution(String s) {
        int cnt1=0;
        int cnt2=0;
        
        while(!s.equals("1")){
            cnt1++;
            int cnt=0;
            for(int i=0;i<s.length();i++){
                if(Character.getNumericValue(s.charAt(i))==1){
                    cnt++;
                }
                else{
                    cnt2++;
                }
            }
            s=Integer.toBinaryString(cnt);
        }
        int[] answer={cnt1,cnt2};
        return answer;
    }
}