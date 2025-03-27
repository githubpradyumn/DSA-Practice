class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean sign = true;
        if(dividend>=0 && divisor<0) sign = false;
        if(dividend<0 && divisor>=0) sign = false;
        
        long n =  Math.abs((long)dividend), d =  Math.abs((long)divisor),ans=0;
        while(n >= d){
            int count = 0;
            while(n >= (d<<(count+1))){
                count++;
            }
            ans += (1L<<count);
            n -= (d<<count);
        }
        // if(ans >= (1<<31)-1 ) return Integer.MAX_VALUE;
        System.out.println("ans : " + ans);
        System.out.println(sign);
        if( ans >= Integer.MAX_VALUE  && sign ) return Integer.MAX_VALUE;
        if( ans == Integer.MAX_VALUE  && !sign ) return -Integer.MAX_VALUE;
        if( ans > Integer.MAX_VALUE  && !sign ) return Integer.MIN_VALUE;

        if(!sign) return (int)-ans;
        return (int) ans;
    }
}