class Solution {
    public String largestOddNumber(String num) {
        String str="";

        // if(Integer.parseInt(num) % 2 != 0)
        // return num;
        
         if (num.charAt(num.length() - 1) % 2 != 0) {
            return num;
         }
        else
        {
            for(int i= num.length() -1 ;0 <= i; i--)
            {
                   int digit = num.charAt(i) - '0'; 
                    if (digit % 2 != 0) {
                    str=num.substring(0, 1+i);
                    break;
                }
            } 
        }
       
        return str;

    // if(Integer.parseInt(String.valueOf(num.charAt(i))) % 2 != 0) 
    }
}