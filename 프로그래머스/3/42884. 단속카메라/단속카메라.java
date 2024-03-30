import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(a->a[1]));
        int idx=Integer.MIN_VALUE;
        for(int[]route:routes){
            if(idx<route[0]){
                idx=route[1];
                answer++;
            }
        }
        return answer;
    }
}