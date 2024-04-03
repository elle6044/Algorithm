import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a=findGCD(arrayA);
        int b=findGCD(arrayB);
        if(a!=1){
            L:for(int i=a;i>=2;i--){
                if(a%i==0){
                    for(int j=0;j<arrayB.length;j++){
                        if(arrayB[j]%i==0){
                            continue L;
                        }
                    }
                    answer=i;
                    break;
                }
            }
        }
        if(b!=1){
            L:for(int i=b;i>=2;i--){
                if(b%i==0){
                    for(int j=0;j<arrayA.length;j++){
                        if(arrayA[j]%i==0){
                            continue L;
                        }
                    }
                    answer=Math.max(answer,i);
                    break;
                }
            }
        }
        
        return answer;
    }
    public int findGCD(int[] array){
        int result=array[0];
        for(int i=1;i<array.length;i++){
            result=gcd(result,array[i]);
            if(result==1){
                return 1;
            }
        }
        return result;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}