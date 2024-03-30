class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int last=0;
        for(int i=0;i<stations.length;i++){
            if(stations[i]-w-1<=last){
                last=Math.min(stations[i]+w,n);
            }
            else{
                int space=stations[i]-w-1-last;
                answer+=space/(2*w+1);
                answer+=space%(2*w+1)==0?0:1;
                last=Math.min(stations[i]+w,n);
            }
        }
        int end=n-last;
        answer+=end/(w*2+1)+(end%(w*2+1)==0?0:1);

        return answer;
    }
}