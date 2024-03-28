class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        N=numbers.length;
        map=numbers;
        back(0,target);
        answer=cnt;
        return answer;
    }
    static int cnt=0;
    public void back(int idx, int sum){
        if(idx==N){
            if(sum==0){
                cnt++;
            }
            return;
        }
        
        back(idx+1, sum+map[idx]);
        back(idx+1, sum-map[idx]);
    }
    static int N;
    static int[]map;
}